package com.example.backend.Service;

import com.example.backend.model.CustomerNoPwd;
import com.example.backend.model.Wallet;
import com.example.backend.repositories.WalletRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WalletService {

    private final WalletRepository walletRepository;

    public WalletService(WalletRepository walletRepository){
        this.walletRepository = walletRepository;
    }

    public List<Wallet> getAll(){

        List<Wallet> listTempo = walletRepository.findAll();
        for (Wallet w : listTempo){
            w.getCustomer().setLname(null);

        }
        return listTempo;
    }
    public List<Wallet> getByUserId(int id){
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
                listFilter.remove(w);
            }
        }
        return listFilter;
    }

}
