package com.library.management.system.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "BOOK")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    @NotBlank
    private Integer id;
    @Column(name = "BOOK_TITLE")
    @NotBlank(message = "Book Title must Not be null, empty, and blank")
    private String bookTitle;
    @NotNull(message = "You Can Enter Book Edition")
    @Column(name = "EDITION")
    private String bookEdition;
    @NotBlank(message = "You Must Enter Book Author")
    @Column(name = "AUTHOR")
    private String bookAuthor;

    @NotBlank(message = "You Must Enter Book Publisher Name")
    @Column(name = "PUBLISHER_NAME")
    private String bookPublisherName;
    @NotNull(message = "You Can Enter Book Publication Year")
    @Column(name = "PUBLICATION_YEAR")
    private Long bookPublicationYear;

    @NotEmpty(message = "You Must Enter Book ISBN")
    @Column(name = "ISBN")
    private String bookISBN;
    @NotBlank(message = "You Must Check Book Status ")
    @Column(name = "BOOK_STATUS")
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

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
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

    public String getBookEdition() {
        return bookEdition;
    }

    public void setBookEdition(String bookEdition) {
        this.bookEdition = bookEdition;
    }

    public String getBookPublisherName() {
        return bookPublisherName;
    }

    public void setBookPublisherName(String bookPublisherName) {
        this.bookPublisherName = bookPublisherName;
    }

    public String getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(String bookStatus) {
        this.bookStatus = bookStatus;
    }
}
