package com.library.management.system.models.responses;

import java.util.HashMap;
import java.util.Map;

public class PatronResponseModel {
    private Integer id;
    private String patronName;
    private String patronAddress;
    private String patronPhoneNumber;
    private String bookTitle;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPatronName() {
        return patronName;
    }

    public void setPatronName(String patronName) {
        this.patronName = patronName;
    }

    public String getPatronAddress() {
        return patronAddress;
    }

    public void setPatronAddress(String patronAddress) {
        this.patronAddress = patronAddress;
    }

    public String getPatronPhoneNumber() {
        return patronPhoneNumber;
    }

    public void setPatronPhoneNumber(String patronPhoneNumber) {
        this.patronPhoneNumber = patronPhoneNumber;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }
}
