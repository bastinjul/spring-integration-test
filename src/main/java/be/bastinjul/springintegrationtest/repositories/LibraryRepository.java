package be.bastinjul.springintegrationtest.repositories;

import be.bastinjul.springintegrationtest.entities.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<Library, Long> {
}
