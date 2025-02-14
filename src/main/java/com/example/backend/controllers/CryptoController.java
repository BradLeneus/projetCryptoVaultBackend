package com.example.backend.controllers;


import com.example.backend.model.Crypto;
import com.example.backend.repositories.CryptoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("crypto")
@CrossOrigin
public class CryptoController {

    @Autowired
    CryptoRepository cryptoRepository;

    @GetMapping("getall")
    public List<Crypto> getAllCrypto(){
        return cryptoRepository.findAll();
    }
}
