package be.bastinjul.springintegrationtest.repositories;

import be.bastinjul.springintegrationtest.entities.BorrowerBookLibrary;
import be.bastinjul.springintegrationtest.entities.BorrowerBookLibraryId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowerBookLibraryRepository extends JpaRepository<BorrowerBookLibrary, BorrowerBookLibraryId> {
}
