package be.bastinjul.springintegrationtest.repositories;

import be.bastinjul.springintegrationtest.entities.LibraryBook;
import be.bastinjul.springintegrationtest.entities.LibraryBookId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryBookRepository extends JpaRepository<LibraryBook, LibraryBookId> {
}
