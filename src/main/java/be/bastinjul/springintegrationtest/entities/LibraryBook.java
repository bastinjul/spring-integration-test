package be.bastinjul.springintegrationtest.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "library_book")
public class LibraryBook {

    @EmbeddedId
    private LibraryBookId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("libraryId")
    private Library library;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("bookId")
    private Book book;

    @Column(name = "quantity")
    private Integer quantity;

    public LibraryBook() {
        //needed for DB
    }

    public LibraryBook(Library library, Book book) {
        this.library = library;
        this.book = book;
        this.id = new LibraryBookId(library.getId(), book.getId());
    }

    public LibraryBookId getId() {
        return id;
    }

    public void setId(LibraryBookId id) {
        this.id = id;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LibraryBook that = (LibraryBook) o;
        return Objects.equals(id, that.id) && Objects.equals(library, that.library) && Objects.equals(book, that.book) && Objects.equals(quantity, that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, library, book, quantity);
    }
}
