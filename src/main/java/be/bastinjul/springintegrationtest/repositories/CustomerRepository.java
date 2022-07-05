package be.bastinjul.springintegrationtest.repositories;

import be.bastinjul.springintegrationtest.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
