package com.library.management.system.entities;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PATRON")
public class Patron {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    @NotBlank
    private Integer id;
    @Column(name = "NAME")
    @NotEmpty(message = "You Must Enter Patron Name")
    @Min(value = 4, message = "Minimum Size Of Patron Name Is Four Characters")
    private String patronName;
    @Column(name = "ADDRESS")
    @NotNull(message = "you can Enter Patron Address")
    private String patronAddress;
    @Column(name = "PHONE_NUMBER")
    @Max(value = 11, message = "Maximum Digits For Phone Number Is 11")
    @NotEmpty(message = "you must enter the Patron Phone Number")
    private String patronPhoneNumber;
    @ManyToMany
    @JoinTable(
            name = "BorrowingRecord", joinColumns = @JoinColumn(name = "patronId"),
            inverseJoinColumns =@JoinColumn(name = "bookId")
    )
    private List<Book> books = new ArrayList<>();

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

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public String getPatronPhoneNumber() {
        return patronPhoneNumber;
    }

    public void setPatronPhoneNumber(String patronPhoneNumber) {
        this.patronPhoneNumber = patronPhoneNumber;
    }
}
