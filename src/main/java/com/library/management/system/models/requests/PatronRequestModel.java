package com.library.management.system.models.requests;

public class PatronRequestModel {
    private Integer id;
    private String patronName;
    private String patronAddress;
    private String patronPhoneNumber;

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
}
