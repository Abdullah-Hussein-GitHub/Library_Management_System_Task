package com.library.management.system.serviceImpl;

import com.library.management.system.entities.Book;
import com.library.management.system.entities.Patron;
import com.library.management.system.models.requests.PatronRequestModel;
import com.library.management.system.models.responses.BookResponseModel;
import com.library.management.system.repositories.BookRepository;
import com.library.management.system.repositories.PatronRepository;
import com.library.management.system.services.BorrowingRecordService;
import com.library.management.system.utils.BasicResponse;
import com.library.management.system.utils.Defines;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BorrowingRecordServiceImpl implements BorrowingRecordService {

    Logger logger = LoggerFactory.getLogger(PatronServiceKImpl.class);

    @Autowired
    PatronRepository patronRepository;
    @Autowired
    BookRepository bookRepository;
    @Override
    public BasicResponse allowToBorrow(Integer bookId, PatronRequestModel patronRequestModel) {
        List<Book> bookList = bookRepository.findAll();
        List<Book> books = new ArrayList<>();
        try {
            if(bookRepository.findBookIdByBookStatus() != null){
                Patron patron = new Patron();
                for(Book book : bookList){
                    patron.setPatronName(patronRequestModel.getPatronName());
                    patron.setPatronAddress(patronRequestModel.getPatronAddress());
                    patron.setPatronPhoneNumber(patronRequestModel.getPatronPhoneNumber());
                    if(book.getBookStatus().equals("A")){
                        books.add(book);
                    }
                    patron.setBooks(books);
                }
                patronRepository.save(patron);
            }
        }catch (Exception e){
            logger.error(Defines.BASIC_ERROR_REPLY_MSG.concat("{}"),e);
            return new BasicResponse.Builder()
                    .ReplyCode(Defines.BASIC_ERROR_REPLY_CODE)
                    .ReplyMsg(Defines.BASIC_ERROR_REPLY_MSG)
                    .build();
        }
        return new BasicResponse.Builder()
                .ReplyCode(Defines.BASIC_ERROR_REPLY_CODE)
                .ReplyMsg(Defines.DELETE_PATRON_SUCCESS_REPLY_MSG)
                .build();
    }

    @Override
    public BookResponseModel getBorrowedBookByPatron(Integer patronId) {
        BookResponseModel bookResponseModel = new BookResponseModel();
        try {
            Patron patron = patronRepository.findById(patronId).get();
            if(patron != null && patron.getBooks() != null){
                for(Book book : patron.getBooks()){
                    if(book.getBookStatus().equals("A")){
            bookResponseModel.setId(book.getId());
            bookResponseModel.setBookStatus(book.getBookStatus());
            bookResponseModel.setBookEdition(book.getBookEdition());
            bookResponseModel.setBookISBN(book.getBookISBN());
            bookResponseModel.setBookTitle(book.getBookTitle());
            bookResponseModel.setBookPublisherName(book.getBookPublisherName());
            bookResponseModel.setBookAuthor(book.getBookAuthor());
            bookResponseModel.setBookPublicationYear(book.getBookPublicationYear());
                    }
                }
            }
        }catch (Exception e){
            logger.error(Defines.BASIC_ERROR_REPLY_MSG.concat("{}"),e);
        }
        return bookResponseModel;
    }
}
