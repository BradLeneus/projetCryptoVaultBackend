package com.example.backend.controllers;

import com.example.backend.model.Customer;
import com.example.backend.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
// par default le rest se met en mode "private"
// elle ne permet pas de call il faut donc autorisé
// @CrossOrigin ouvre la porte a n'importe qui de call les methodes
@CrossOrigin
@RequestMapping("/samuel")
public class CustomerController {

    @Autowired
    CustomerRepository repository;
    // post mapping parce que avec axios on fait un post
    @PostMapping("/newCustomer")
    // le @RequestBody regle le bug des données
    public Customer createCustomer(@RequestBody Customer customer){
        repository.save(customer);
        return customer;
    }

    @GetMapping("/getAll")
    public List<Customer> getall(){
        return repository.findAll();
    }

    @GetMapping("/getCustomer/{name}/{lname}")
    public Customer getCustomer(@PathVariable String name, @PathVariable String lname){
        List<Customer> arr = repository.findAll();
        for (Customer c : arr){
            if (c.getFname().equals(name) && c.getLname().equals(lname)){
                return c;
            }


        }
        return null;
    }
    @GetMapping("/customer/{id}")
    public Optional<Customer> getCustomerById(@PathVariable Long id) {
        return repository.findById(id);


    }
}
