package com.example.backend.controllers;

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

    @GetMapping("/getall")
    public List<Wallet> getAll(){

        return walletRepository.findAll();

    }

    @GetMapping("/getbyuser/{id}")
    public List<Wallet> getByIdUser(@PathVariable int id){
        List<Wallet> listWallet = walletRepository.findAllByCustomer_Id(id);
        List<Wallet> listFilter = new ArrayList<>();
        for(Wallet w : listWallet){


                boolean isThere = false;
                for(Wallet wfilt : listFilter){
                    if(wfilt.getIdcrypto().getId() == w.getIdcrypto().getId()) {
                        wfilt.setQty(wfilt.getQty() + w.getQty());

                        isThere = true;
                    }

                }
                if(isThere){
                    isThere = false;
                }
                else {

                        listFilter.add(w);


                }

            }
        for(Wallet w : listFilter){
            if(w.getQty() == 0){
                System.out.println(w.getQty());
            }
        }
      return listFilter;
    }

    @PostMapping("/newWallet")
    // le @RequestBody regle le bug des données
    public Wallet createWallet(@RequestBody Wallet wallet){
        walletRepository.save(wallet);

        return wallet;
    }
}


