package com.library.management.system.services;

import com.library.management.system.models.requests.PatronRequestModel;
import com.library.management.system.models.responses.BookResponseModel;
import com.library.management.system.utils.BasicResponse;

public interface BorrowingRecordService {

    public BasicResponse allowToBorrow(Integer bookId, PatronRequestModel patronRequestModel);
    public BookResponseModel getBorrowedBookByPatron(Integer patronId);
}
