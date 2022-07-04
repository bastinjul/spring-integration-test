package be.bastinjul.springintegrationtest.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "library")
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(name = "borrow_max_days", nullable = false)
    private Integer borrowMaxDays;

    @Column(name = "price_per_day_of_delay")
    private Double pricePerDayOfDelay;

    @ManyToMany(mappedBy = "libraries")
    private Set<Customer> customers;

    @OneToMany(mappedBy = "library", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LibraryBook> books = new ArrayList<>();

    @OneToMany(mappedBy = "library", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BorrowerBookLibrary> bookBorrowers;

    public Library() {
        //needed for db
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getBorrowMaxDays() {
        return borrowMaxDays;
    }

    public void setBorrowMaxDays(Integer borrowMaxDays) {
        this.borrowMaxDays = borrowMaxDays;
    }

    public Double getPricePerDayOfDelay() {
        return pricePerDayOfDelay;
    }

    public void setPricePerDayOfDelay(Double pricePerDayOfDelay) {
        this.pricePerDayOfDelay = pricePerDayOfDelay;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }

    public List<LibraryBook> getBooks() {
        return books;
    }

    public void setBooks(List<LibraryBook> books) {
        this.books = books;
    }

    public List<BorrowerBookLibrary> getBookBorrowers() {
        return bookBorrowers;
    }

    public void setBookBorrowers(List<BorrowerBookLibrary> bookBorrowers) {
        this.bookBorrowers = bookBorrowers;
    }
}
