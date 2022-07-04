package be.bastinjul.springintegrationtest.entities;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Double borrowingPrice;

    @Column(nullable = false)
    private Double purchasePrice;

    @Column(nullable = false)
    private Calendar releaseDate;

    @ManyToMany(mappedBy = "books")
    private Set<Author> authors;

    @ManyToMany(mappedBy = "purchasedBooks")
    private List<Customer> purchasers;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BorrowerBookLibrary> borrowerLibrary;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LibraryBook> libraries;

    public Book() {
        //needed for serialization
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getBorrowingPrice() {
        return borrowingPrice;
    }

    public void setBorrowingPrice(Double borrowingPrice) {
        this.borrowingPrice = borrowingPrice;
    }

    public Double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Calendar getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Calendar releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public List<Customer> getPurchasers() {
        return purchasers;
    }

    public void setPurchasers(List<Customer> purchasers) {
        this.purchasers = purchasers;
    }

    public List<BorrowerBookLibrary> getBorrowerLibrary() {
        return borrowerLibrary;
    }

    public void setBorrowerLibrary(List<BorrowerBookLibrary> borrowerLibrary) {
        this.borrowerLibrary = borrowerLibrary;
    }

    public List<LibraryBook> getLibraries() {
        return libraries;
    }

    public void setLibraries(List<LibraryBook> libraries) {
        this.libraries = libraries;
    }
}
