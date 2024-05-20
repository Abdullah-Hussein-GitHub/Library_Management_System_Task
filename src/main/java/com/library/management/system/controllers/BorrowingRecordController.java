package com.library.management.system.controllers;

import com.library.management.system.models.requests.PatronRequestModel;
import com.library.management.system.models.responses.BookResponseModel;
import com.library.management.system.services.BorrowingRecordService;
import com.library.management.system.utils.BasicResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/borrow/v1")
public class BorrowingRecordController {

    @Autowired
    BorrowingRecordService borrowingRecordService;
    @PostMapping("/allowToBorrow/book/{bookId}/patron/{patronId}")
    public ResponseEntity<BasicResponse> allowToBorrow(@PathVariable Integer bookId, @RequestBody PatronRequestModel patronRequestModel){
       return new ResponseEntity<>(borrowingRecordService.allowToBorrow(bookId, patronRequestModel), HttpStatus.OK);
    }
    @PutMapping("/allowToBorrow/book/{bookId}/patron/{patronId}")
    public ResponseEntity<BookResponseModel> getBorrowedBookByPatron(@PathVariable Integer patronId){
        return new ResponseEntity<>(borrowingRecordService.getBorrowedBookByPatron(patronId), HttpStatus.OK);
    }
}
