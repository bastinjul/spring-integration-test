package be.bastinjul.springintegrationtest.entities;

import java.util.Set;

public class Book {
    private Long id;
    private String name;
    private String description;

    private Set<Long> authorsIds;

    private Set<Author> authors;

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

    public Set<Long> getAuthorsIds() {
        return authorsIds;
    }

    public void setAuthorsIds(Set<Long> authorsIds) {
        this.authorsIds = authorsIds;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }
}
