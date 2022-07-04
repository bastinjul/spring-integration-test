package be.bastinjul.springintegrationtest.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class BorrowerBookLibraryId implements Serializable {
    @Column(name = "borrower_id")
    private Long borrowerId;

    @Column(name = "book_id")
    private Long bookId;

    @Column(name = "library_id")
    private Long libraryId;

    public BorrowerBookLibraryId() {
        //needed for db
    }

    public BorrowerBookLibraryId(Long borrowerId, Long bookId, Long libraryId) {
        this.borrowerId = borrowerId;
        this.bookId = bookId;
        this.libraryId = libraryId;
    }

    public Long getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(Long borrowerId) {
        this.borrowerId = borrowerId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(Long libraryId) {
        this.libraryId = libraryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BorrowerBookLibraryId that = (BorrowerBookLibraryId) o;
        return borrowerId.equals(that.borrowerId) && bookId.equals(that.bookId) && libraryId.equals(that.libraryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(borrowerId, bookId, libraryId);
    }
}
