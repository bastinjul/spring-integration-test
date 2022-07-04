package be.bastinjul.springintegrationtest.entities;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false)
    private Double money;

    @Column(name = "birth_date")
    private Calendar birthDate;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "library_customer",
        joinColumns = @JoinColumn(name = "library_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "customer_id", referencedColumnName = "id"))
    private Set<Library> libraries;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "purchaser_book",
        joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "purchaser_id", referencedColumnName = "id"))
    private List<Book> purchasedBooks;

    @OneToMany(mappedBy = "borrower", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BorrowerBookLibrary> borrowedLibraryBooks;

    public Customer() {
        //needed for db
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

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Calendar getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Calendar birthDate) {
        this.birthDate = birthDate;
    }

    public Set<Library> getLibraries() {
        return libraries;
    }

    public void setLibraries(Set<Library> libraries) {
        this.libraries = libraries;
    }

    public List<Book> getPurchasedBooks() {
        return purchasedBooks;
    }

    public void setPurchasedBooks(List<Book> purchasedBooks) {
        this.purchasedBooks = purchasedBooks;
    }

    public List<BorrowerBookLibrary> getBorrowedLibraryBooks() {
        return borrowedLibraryBooks;
    }

    public void setBorrowedLibraryBooks(List<BorrowerBookLibrary> borrowedBooks) {
        this.borrowedLibraryBooks = borrowedBooks;
    }
}
