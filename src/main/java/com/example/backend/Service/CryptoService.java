package com.example.backend.Service;

import com.example.backend.model.Crypto;
import com.example.backend.repositories.CryptoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class CryptoService {
    private List<Crypto> cryptoList = null;
    private final CryptoRepository cryptoRepository;
    CryptoService(CryptoRepository cryptoRepository){
        this.cryptoRepository = cryptoRepository;

    }


    public List<Crypto> getAllCrypto(){
        cryptoList = cryptoRepository.findAll();
        for(Crypto c :cryptoList ){
            //semi random price varie de 10%
            c.setPrice((int)(Math.random() * (c.getPrice()) * 0.1) + c.getPrice());
        }
        return cryptoList;
    }

    public List<Crypto> getAllCryptoByPrice(boolean asc){
        return sortByPrice(asc);
    }
    public List<Crypto> getAllCryptoByName(boolean asc){
        return sortByName(asc);
    }

    public List<Crypto> sortByPrice(boolean asc) {

        Collections.sort(cryptoList, new Comparator<Crypto>() {
            public int compare(Crypto p1, Crypto p2) {
                if(asc){
                    return (int) (p1.getPrice() - p2.getPrice());
                }
                else {
                    return (int) (p2.getPrice() - p1.getPrice());
                }

            }
        });
        return cryptoList;
    }

    public List<Crypto> sortByName(boolean asc) {

        Collections.sort(cryptoList, new Comparator<Crypto>() {
            public int compare(Crypto p1, Crypto p2) {
                if(asc){
                    return  (p1.getName().compareTo(p2.getName()));
                }
                else {
                    return  (p2.getName().compareTo(p1.getName()));
                }
            }
        });
        return cryptoList;
    }
}
