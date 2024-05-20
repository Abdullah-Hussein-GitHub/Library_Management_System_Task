package com.library.management.system.serviceImpl;

import com.library.management.system.entities.Book;
import com.library.management.system.entities.Patron;
import com.library.management.system.models.requests.PatronRequestModel;
import com.library.management.system.models.responses.PatronResponseModel;
import com.library.management.system.repositories.BookRepository;
import com.library.management.system.repositories.PatronRepository;
import com.library.management.system.services.PatronService;
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
public class PatronServiceKImpl implements PatronService {

    @Autowired
    PatronRepository patronRepository;
    @Autowired
    BookRepository  bookRepository;

    Logger  logger = LoggerFactory.getLogger(PatronServiceKImpl.class);
    @Override
    public List<PatronResponseModel> getAllPatrons() {
        List<PatronResponseModel> patronsList = new ArrayList<>();
        try {
            List<Patron> patrons = patronRepository.findAll();
            patrons.stream().forEach(patron ->{
                PatronResponseModel patronResponseModel = new PatronResponseModel();
                patronResponseModel.setId(patron.getId());
                patronResponseModel.setPatronName(patron.getPatronName());
                patronResponseModel.setPatronAddress(patron.getPatronAddress());
                patronResponseModel.setPatronPhoneNumber(patron.getPatronPhoneNumber());
                patronsList.add(patronResponseModel);
            });
        }catch (Exception e){
            logger.error(Defines.BASIC_ERROR_REPLY_MSG.concat("{}"),e);
        }
        return patronsList;
    }

    @Transactional
    @Override
    public BasicResponse createPatron(PatronRequestModel patronRequestModel) {
    try {
        Patron patron = new Patron();
        patron.setPatronAddress(patronRequestModel.getPatronAddress());
        patron.setPatronName(patronRequestModel.getPatronName());
        patron.setPatronPhoneNumber(patronRequestModel.getPatronPhoneNumber());
        List<Book> bookList = bookRepository.findAll();
        if(bookRepository.findAll() != null && bookRepository.findBookIdByBookStatus() != null){
            patron.setBooks(bookList);
        }
        patronRepository.save(patron);
    }catch (Exception e){
        logger.error(Defines.BASIC_ERROR_REPLY_MSG.concat("{}"),e);
        return new BasicResponse.Builder()
                .ReplyCode(Defines.BASIC_ERROR_REPLY_CODE)
                .ReplyMsg(Defines.BASIC_ERROR_REPLY_MSG)
                .build();
    }
        return new BasicResponse.Builder()
                .ReplyCode(Defines.BASIC_ERROR_REPLY_CODE)
                .ReplyMsg(Defines.CREATE_PATRON_SUCCESS_REPLY_MSG)
                .build();
    }

    @Override
    public BasicResponse updatePatronById(PatronRequestModel patronRequestModel) {
        try {
            Patron patron = patronRepository.findById(patronRequestModel.getId()).get();
            if(patron != null){
            patron.setPatronPhoneNumber(patronRequestModel.getPatronPhoneNumber());
            patron.setPatronAddress(patronRequestModel.getPatronAddress());
            patron.setPatronName(patronRequestModel.getPatronName());
                List<Book> bookList = bookRepository.findAll();

                if(bookRepository.findAll() != null && bookRepository.findBookIdByBookStatus() != null){
                    patron.setBooks(bookList);
                }
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
                .ReplyMsg(Defines.UPDATE_BOOK_SUCCESS_REPLY_MSG)
                .build();
    }

    @Override
    public BasicResponse deletePatronById(Integer patronId) {
        try {
            Patron patron = patronRepository.findById(patronId).get();
            Integer bookId = bookRepository.findBookIdByBookStatus();
            if(patron != null && bookId != null){
            bookRepository.deleteById(bookId);
            patronRepository.deleteById(patron.getId());
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
    public PatronResponseModel getPatronById(Integer patronId) {
        PatronResponseModel patronResponseModel = new PatronResponseModel();

        try {
           Patron patron = patronRepository.findById(patronId).get();
           if(patron != null){
           patronResponseModel.setId(patron.getId());
           patronResponseModel.setPatronAddress(patron.getPatronAddress());
           patronResponseModel.setPatronName(patron.getPatronName());
               List<Book> bookList = bookRepository.findAll();

               if(bookRepository.findAll() != null && bookRepository.findBookIdByBookStatus() != null){
               for(Book book : bookList){
                   patronResponseModel.setBookTitle(book.getBookTitle());
               }
               }
           }
        }catch (Exception e){
            logger.error(Defines.BASIC_ERROR_REPLY_MSG.concat("{}"),e);
        }
        return patronResponseModel;
    }
}
