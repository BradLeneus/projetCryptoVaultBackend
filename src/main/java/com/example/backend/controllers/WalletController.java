package com.example.backend.controllers;

import com.example.backend.Service.WalletService;
import com.example.backend.model.Crypto;
import com.example.backend.model.Customer;
import com.example.backend.model.Wallet;
import com.example.backend.repositories.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/wallet")
@CrossOrigin
public class WalletController {

    @Autowired
    WalletRepository walletRepository;


    @Autowired
    WalletService walletService;
    @GetMapping("/getall")
    public List<Wallet> getAll(){
    return walletService.getAll();


    }

    @GetMapping("/getbyuser/{id}")
    public List<Wallet> getByIdUser(@PathVariable int id){
        return walletService.getByUserId(id);
    }

    @PostMapping("/newWallet")
    // le @RequestBody regle le bug des données
    public Wallet createWallet(@RequestBody Wallet wallet){
        walletService.createWallet(wallet);

        return wallet;
    }
}


