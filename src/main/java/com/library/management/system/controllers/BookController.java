package com.library.management.system.controllers;

import com.library.management.system.models.requests.BookRequestModel;
import com.library.management.system.models.responses.BookResponseModel;
import com.library.management.system.services.BookService;
import com.library.management.system.utils.BasicResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/books/v1")
public class BookController {

       @Autowired
       BookService bookService;

       @GetMapping("/getAllBooks")
       ResponseEntity<List<BookResponseModel>> getAllBooks(){
       return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK) ;
       }
       @GetMapping("/getBookDetailsBy/{bookId}")
       ResponseEntity<BookResponseModel> getBookDetailsById(@PathVariable Integer bookId){
              return new ResponseEntity<>( bookService.getBookDetailsById(bookId), HttpStatus.OK);
       }
       @PostMapping("/createBook")
       ResponseEntity<BasicResponse> createBook(@RequestBody BookRequestModel bookRequestModel){
        return new ResponseEntity<>(bookService.createBook(bookRequestModel), HttpStatus.OK);
       }
       @PutMapping("/updateBookDetailsById/{bookId}")
       ResponseEntity<BasicResponse> updateBookDetailsById(@RequestBody BookRequestModel bookRequestModel){
              return new ResponseEntity<>(bookService.updateBookDetailsById(bookRequestModel), HttpStatus.OK);
       }
       @DeleteMapping("/deleteBookBy/{bookId}")
       ResponseEntity<BasicResponse> deleteBookBy(@PathVariable Integer bookId){
              return new ResponseEntity<>(bookService.deleteBookBy(bookId), HttpStatus.OK);
       }



}
