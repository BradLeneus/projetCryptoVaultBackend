package com.example.backend.controllers;

import com.example.backend.Service.CustomerService;
import com.example.backend.Service.WalletService;
import com.example.backend.model.Customer;
import com.example.backend.model.CustomerNoPwd;
import com.example.backend.model.Wallet;
import com.example.backend.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
// par default le rest se met en mode "private"
// elle ne permet pas de call il faut donc autorisé
// @CrossOrigin ouvre la porte a n'importe qui de call les methodes
@CrossOrigin
@RequestMapping("/samuel")
public class CustomerController {


    CustomerRepository repository;

    @Autowired
    CustomerService customerService;
    @Autowired
    WalletService walletService;
    // post mapping parce que avec axios on fait un post
    @PostMapping("/newCustomer")
    // le @RequestBody regle le bug des données
    public boolean createCustomer(@RequestBody Customer customer){
        return customerService.createCustomer(customer);
    }

    @GetMapping("/getAll")
    public List<CustomerNoPwd> getall(){
       return customerService.getallCustomer();
    }

    @GetMapping("/getCustomer/{name}/{lname}")
    public CustomerNoPwd getCustomer(@PathVariable String name, @PathVariable String lname){
       return customerService.findCustomerByNameAndPassword(name, lname);
    }
    @GetMapping("/customer/{id}")
    public CustomerNoPwd getCustomerById(@PathVariable int id) {
        return customerService.findCustomerById(id);


    }
    //marche pas
    @DeleteMapping("/deleteCustomer/{id}")
    public boolean deleteCustomerById(@PathVariable int id){
        walletService.deleteWalletUserBYId(id);
        customerService.deleteCustomerById(id);
        return true;
    }
}
