package be.bastinjul.springintegrationtest.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class LibraryBookId implements Serializable {

    @Column(name = "library_id")
    private Long libraryId;

    @Column(name = "book_id")
    private Long bookId;

    public LibraryBookId() {
        //needed for db
    }

    public LibraryBookId(Long libraryId, Long bookId) {
        this.libraryId = libraryId;
        this.bookId = bookId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LibraryBookId that = (LibraryBookId) o;
        return libraryId.equals(that.libraryId) && bookId.equals(that.bookId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(libraryId, bookId);
    }
}
