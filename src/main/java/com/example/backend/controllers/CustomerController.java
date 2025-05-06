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
@RequestMapping("/Customer")
public class CustomerController {




    @Autowired
    CustomerService customerService;
    @Autowired
    WalletService walletService;

    // creer un compte
    @PostMapping("/newCustomer")
    // le @RequestBody regle le bug des données
    public boolean createCustomer(@RequestBody Customer customer){
        return customerService.createCustomer(customer);
    }


    // afficher tous le monde pour le admin
    @GetMapping("/getAll")
    public List<CustomerNoPwd> getall(){
       return customerService.getallCustomer();
    }

    //voir si le user existe deja
    @GetMapping("/getByName/{name}")
    public boolean isUsernameExist(@PathVariable String name){
        return customerService.isUserExistByCustomerName(name);
    }
    // se connecter
    @GetMapping("/getCustomer/{name}/{lname}")
    public CustomerNoPwd getCustomer(@PathVariable String name, @PathVariable String lname){
       return customerService.findCustomerByNameAndPassword(name, lname);
    }

    //pas utilisé
    @GetMapping("/customer/{id}")
    public CustomerNoPwd getCustomerById(@PathVariable int id) {
        return customerService.findCustomerById(id);


    }

    // utilisé par l'admin
    @DeleteMapping("/deleteCustomer/{id}")
    public boolean deleteCustomerById(@PathVariable int id){
        walletService.deleteWalletUserBYId(id);
        customerService.deleteCustomerById(id);
        return true;
    }
}
