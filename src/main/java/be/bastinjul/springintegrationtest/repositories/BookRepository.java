package be.bastinjul.springintegrationtest.repositories;

import be.bastinjul.springintegrationtest.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
