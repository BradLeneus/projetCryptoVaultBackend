package com.example.backend.Service;

import com.example.backend.model.Crypto;
import com.example.backend.repositories.CryptoRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class CryptoService {
    private final CryptoRepository cryptoRepository;
    CryptoService(CryptoRepository cryptoRepository){
        this.cryptoRepository = cryptoRepository;
    }
    public List<Crypto> getAllCrypto(){
        List<Crypto> cryptoList = cryptoRepository.findAll();
        for(Crypto c :cryptoList ){
            c.setPrice((int)(Math.random() * (c.getPrice()) * 0.1) + c.getPrice());
        }
        return cryptoList;
    }
//    public List<Crypto> sortByPrice() {
//        List<Crypto> cryptoList = getAllCrypto();
//        Collections.sort(cryptoList, new Comparator<Crypto>() {
//            public int compare(Crypto p1, Crypto p2) {
//                return p1.getPrice()
//            }
//        });
//    }
}
