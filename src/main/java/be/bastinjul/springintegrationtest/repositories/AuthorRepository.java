package be.bastinjul.springintegrationtest.repositories;

import be.bastinjul.springintegrationtest.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
