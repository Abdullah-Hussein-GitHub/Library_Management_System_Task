package com.library.management.system.serviceImpl;

import com.library.management.system.entities.Book;
import com.library.management.system.models.requests.BookRequestModel;
import com.library.management.system.models.responses.BookResponseModel;
import com.library.management.system.repositories.BookRepository;
import com.library.management.system.services.BookService;
import com.library.management.system.utils.BasicResponse;
import com.library.management.system.utils.Defines;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);

    @Transactional
    @Override
    public BasicResponse createBook(BookRequestModel bookRequestModel) {
       try {
           Book book = new Book();
           book.setBookAuthor(bookRequestModel.getBookAuthor());
           book.setBookEdition(book.getBookEdition());
           book.setBookISBN(book.getBookISBN());
           book.setBookTitle(book.getBookTitle());
           book.setBookPublicationYear(book.getBookPublicationYear());
           book.setBookPublisherName(book.getBookPublisherName());
           book.setBookStatus("A");
           bookRepository.save(book);
       }catch (Exception e){
           logger.error(Defines.BASIC_ERROR_REPLY_MSG.concat("{}"),e);
           return new BasicResponse.Builder()
                   .ReplyCode(Defines.BASIC_ERROR_REPLY_CODE)
                   .ReplyMsg(Defines.CREATE_PATRON_SUCCESS_REPLY_MSG)
                   .build();
       }
        return new BasicResponse.Builder()
                .ReplyCode(Defines.BASIC_SUCCESS_REPLY_CODE)
                .ReplyMsg(Defines.CREATE_BOOK_SUCCESS_REPLY_MSG)
                .build();
    }

    @Transactional
    @Override
    public BasicResponse updateBookDetailsById(BookRequestModel bookRequestModel) {

                 try {
                 Book book = bookRepository.findById(bookRequestModel.getId()).get();
                 if(book != null){
                   book.setBookTitle(bookRequestModel.getBookTitle());
                   book.setBookStatus(bookRequestModel.getBookStatus());
                   book.setBookISBN(bookRequestModel.getBookISBN());
                   book.setBookAuthor(bookRequestModel.getBookAuthor());
                   book.setBookPublisherName(bookRequestModel.getBookPublisherName());
                   book.setBookPublicationYear(bookRequestModel.getBookPublicationYear());
                   bookRepository.save(book);
                 }
                 }catch (Exception e){
                     logger.error(Defines.BASIC_ERROR_REPLY_MSG.concat("{}"),e);
                 }
        return new BasicResponse.Builder()
                .ReplyCode(Defines.BASIC_SUCCESS_REPLY_CODE)
                .ReplyMsg(Defines.UPDATE_BOOK_SUCCESS_REPLY_MSG)
                .build();
    }

    @Transactional
    @Override
    public BasicResponse deleteBookBy(Integer bookId) {
        try {
            Book book = bookRepository.findById(bookId).get();
            if(book != null && book.getId().equals(bookId)){
              bookRepository.delete(book);
            }
        }catch (Exception e){
            logger.error(Defines.BASIC_ERROR_REPLY_MSG.concat("{}"),e);
            return new BasicResponse.Builder()
                    .ReplyCode(Defines.BASIC_ERROR_REPLY_CODE)
                    .ReplyMsg(Defines.BASIC_ERROR_REPLY_MSG)
                    .build();
        }
        return new BasicResponse.Builder()
                .ReplyCode(Defines.BASIC_SUCCESS_REPLY_CODE)
                .ReplyMsg(Defines.DELETE_BOOK_SUCCESS_REPLY_MSG)
                .build();
    }

    @Override
    public List<BookResponseModel> getAllBooks() {
        List<BookResponseModel> bookResponseModelList = new ArrayList<>();
        try{
            BookResponseModel bookResponseModel = new BookResponseModel();
            List<Book> bookList = bookRepository.findAll();
            bookList.stream().forEach( book -> {
                bookResponseModel.setId(book.getId());
                bookResponseModel.setBookTitle(book.getBookTitle());
                bookResponseModel.setBookAuthor(book.getBookAuthor());
                bookResponseModel.setBookISBN(book.getBookISBN());
                bookResponseModel.setBookPublisherName(book.getBookPublisherName());
                bookResponseModel.setBookPublicationYear(book.getBookPublicationYear());
                bookResponseModel.setBookStatus(book.getBookStatus());
                bookResponseModel.setBookEdition(book.getBookEdition());
                bookResponseModelList.add(bookResponseModel);
            } );
        }catch (Exception e){
            logger.error(Defines.BASIC_ERROR_REPLY_MSG.concat("{}"),e);
        }
         return bookResponseModelList;
    }

    @Override
    public BookResponseModel getBookDetailsById(Integer bookId) {
        BookResponseModel bookResponseModel = new BookResponseModel();
        try{
            Book getBookDetails = bookRepository.findById(bookId).get();
            if(getBookDetails.getId() != null){
              bookResponseModel.setId(getBookDetails.getId());
              bookResponseModel.setBookISBN(getBookDetails.getBookISBN());
              bookResponseModel.setBookPublisherName(getBookDetails.getBookPublisherName());
              bookResponseModel.setBookAuthor(getBookDetails.getBookAuthor());
              bookResponseModel.setBookEdition(bookResponseModel.getBookEdition());
              bookResponseModel.setBookStatus(getBookDetails.getBookStatus());
              bookResponseModel.setBookTitle(getBookDetails.getBookTitle());
            }
        }catch (Exception e){
            logger.error(Defines.BASIC_ERROR_REPLY_MSG.concat("{}"),e);
        }
        return bookResponseModel;
    }
}
