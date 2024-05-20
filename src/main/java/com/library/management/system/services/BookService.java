package com.library.management.system.services;

import com.library.management.system.models.requests.BookRequestModel;
import com.library.management.system.models.responses.BookResponseModel;
import com.library.management.system.utils.BasicResponse;
import java.util.List;

public interface BookService {
    BasicResponse createBook(BookRequestModel bookRequestModel);

    BasicResponse deleteBookBy(Integer bookId);
    public List<BookResponseModel> getAllBooks();

    public BookResponseModel getBookDetailsById(Integer bookId);

    BasicResponse updateBookDetailsById(BookRequestModel bookRequestModel);
}
