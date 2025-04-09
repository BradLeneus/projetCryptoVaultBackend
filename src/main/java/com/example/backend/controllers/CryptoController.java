package com.example.backend.controllers;


import com.example.backend.Service.CryptoService;
import com.example.backend.model.Crypto;
import com.example.backend.repositories.CryptoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("crypto")
@CrossOrigin
public class CryptoController {
    @Autowired
    CryptoService cryptoService;

    @GetMapping("getall")
    public List<Crypto> getAllCrypto(){
        return cryptoService.getAllCrypto();
    }


    @GetMapping("getAllByPrice/{asc}")
    public List<Crypto> getAllCryptoByPrice(@PathVariable boolean asc){
        return cryptoService.getAllCryptoByPrice(asc);
    }

    @GetMapping("getAllByName/{asc}")
    public List<Crypto> getAllCryptoByName(@PathVariable boolean asc){
        return cryptoService.getAllCryptoByName(asc);
    }
}
