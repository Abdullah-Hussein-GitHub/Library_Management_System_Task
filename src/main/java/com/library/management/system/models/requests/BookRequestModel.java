package com.library.management.system.models.requests;

public class BookRequestModel {

    private Integer id;
    private String bookTitle;
    private String bookEdition;
    private String bookAuthor;
    private String bookPublisherName;
    private Long bookPublicationYear;
    private String bookISBN;
    private String bookStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookEdition() {
        return bookEdition;
    }

    public void setBookEdition(String bookEdition) {
        this.bookEdition = bookEdition;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookPublisherName() {
        return bookPublisherName;
    }

    public void setBookPublisherName(String bookPublisherName) {
        this.bookPublisherName = bookPublisherName;
    }

    public Long getBookPublicationYear() {
        return bookPublicationYear;
    }

    public void setBookPublicationYear(Long bookPublicationYear) {
        this.bookPublicationYear = bookPublicationYear;
    }

    public String getBookISBN() {
        return bookISBN;
    }

    public void setBookISBN(String bookISBN) {
        this.bookISBN = bookISBN;
    }

    public String getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(String bookStatus) {
        this.bookStatus = bookStatus;
    }
}
