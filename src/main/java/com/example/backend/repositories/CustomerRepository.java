package com.example.backend.repositories;

import com.example.backend.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(collectionResourceRel = "customer", path = "oui")
@CrossOrigin()
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
