package com.library.management.system.services;

import com.library.management.system.models.requests.PatronRequestModel;
import com.library.management.system.models.responses.PatronResponseModel;
import com.library.management.system.utils.BasicResponse;

import java.util.List;

public interface PatronService {
    public List<PatronResponseModel> getAllPatrons();
    public BasicResponse createPatron(PatronRequestModel patronRequestModel);
    public BasicResponse updatePatronById(PatronRequestModel patronRequestModel);
    public BasicResponse deletePatronById(Integer patronId);
    public PatronResponseModel getPatronById(Integer patronId);
}
