package be.bastinjul.springintegrationtest.entities;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Objects;

@Entity
@Table(name = "borrower_book_library")
public class BorrowerBookLibrary {

    @EmbeddedId
    private BorrowerBookLibraryId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("borrowerId")
    private Customer borrower;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("bookId")
    private Book book;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("libraryId")
    private Library library;

    @Column(name = "borrow_date", nullable = false)
    private Calendar borrowDate;

    public BorrowerBookLibrary() {
        //needed for DB
    }

    public BorrowerBookLibrary(Customer borrower, Book book, Library library) {
        this.borrower = borrower;
        this.book = book;
        this.library = library;
        this.id = new BorrowerBookLibraryId(borrower.getId(), book.getId(), library.getId());
    }

    public BorrowerBookLibraryId getId() {
        return id;
    }

    public void setId(BorrowerBookLibraryId id) {
        this.id = id;
    }

    public Customer getBorrower() {
        return borrower;
    }

    public void setBorrower(Customer borrower) {
        this.borrower = borrower;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public Calendar getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Calendar borrowDate) {
        this.borrowDate = borrowDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BorrowerBookLibrary that = (BorrowerBookLibrary) o;
        return Objects.equals(id, that.id) && Objects.equals(borrower, that.borrower) && Objects.equals(book, that.book) && Objects.equals(library, that.library) && Objects.equals(borrowDate, that.borrowDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, borrower, book, library, borrowDate);
    }
}
