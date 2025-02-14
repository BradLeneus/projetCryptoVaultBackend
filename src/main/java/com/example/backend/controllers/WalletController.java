package com.example.backend.controllers;

import com.example.backend.model.Wallet;
import com.example.backend.repositories.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/wallet")
@CrossOrigin()
public class WalletController {

    @Autowired
    WalletRepository walletRepository;

    @GetMapping("/getall")
    public List<Wallet> getAll(){

        return walletRepository.findAll();

    }
}
