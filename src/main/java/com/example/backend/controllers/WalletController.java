package com.example.backend.controllers;

import com.example.backend.model.Customer;
import com.example.backend.model.Wallet;
import com.example.backend.repositories.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/wallet")
@CrossOrigin
public class WalletController {

    @Autowired
    WalletRepository walletRepository;

    @GetMapping("/getall")
    public List<Wallet> getAll(){

        return walletRepository.findAll();

    }

    @GetMapping("/getbyuser/{id}")
    public List<Wallet> getByIdUser(@PathVariable int id){
      return  walletRepository.findAllByCustomer_Id(id);
    }
}
