package be.bastinjul.springintegrationtest.entities;

import java.util.Calendar;
import java.util.Set;

public class Author {
    private Long id;
    private String firstname;
    private String lastname;
    private Calendar birthDate;

    private Set<Long> booksIds;

    private Set<Book> books;

    public Author() {
        //needed for serialization
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Calendar getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Calendar birthDate) {
        this.birthDate = birthDate;
    }

    public Set<Long> getBooksIds() {
        return booksIds;
    }

    public void setBooksIds(Set<Long> booksIds) {
        this.booksIds = booksIds;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
