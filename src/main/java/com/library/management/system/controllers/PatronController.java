package com.library.management.system.controllers;

import com.library.management.system.models.requests.PatronRequestModel;
import com.library.management.system.models.responses.PatronResponseModel;
import com.library.management.system.services.PatronService;
import com.library.management.system.utils.BasicResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/patrons/v1")
public class PatronController {

    @Autowired
    PatronService patronService;

    @GetMapping("/getAllPatrons")
    public ResponseEntity<List<PatronResponseModel>> getAllPatrons(){
        return new ResponseEntity<>(patronService.getAllPatrons(), HttpStatus.OK);
    }

    @GetMapping("/getPatronBy/{patronId}")
    public ResponseEntity<PatronResponseModel> getPatronById(@PathVariable Integer patronId){
        return new ResponseEntity<>(patronService.getPatronById(patronId), HttpStatus.OK);
    }

    @PostMapping("/createPatron")
    public ResponseEntity<BasicResponse> createPatron(@RequestBody PatronRequestModel patronRequestModel){
        return new ResponseEntity<>(patronService.createPatron(patronRequestModel), HttpStatus.OK);
    }

    @PutMapping("/updatePatron/{patronId}")
    public ResponseEntity<BasicResponse> updatePatronById(@RequestBody PatronRequestModel  patronRequestModel){
        return new ResponseEntity<>(patronService.updatePatronById(patronRequestModel), HttpStatus.OK);
    }

    @DeleteMapping("/deletePatron/{patronId}")
    public ResponseEntity<BasicResponse> deletePatronById(@PathVariable Integer patronId){
        return new ResponseEntity<>(patronService.deletePatronById(patronId), HttpStatus.OK);
    }
}
