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
            boolean isInDouble = false;
            for(Wallet wfilt : listFilter){
                if(wfilt.getIdcrypto().getId() == w.getIdcrypto().getId()) {
                    wfilt.setQty(wfilt.getQty() + w.getQty());

                    isInDouble = true;
                }

            }
            if(!isInDouble){
                listFilter.add(w);

            }

        }
        for(Wallet w : listFilter){
            if(w.getQty() < 0){
                w.setQty(0);

            }
        }
        return listFilter;
    }
    public boolean createWallet(Wallet wallet){
        Wallet temp = walletRepository.findWalletByCustomer_IdAndIdcrypto_Id(wallet.getCustomer().getId(), wallet.getIdcrypto().getId());
        if(temp != null){
            temp.setQty(wallet.getQty());
            walletRepository.save(temp);
        }else{

        walletRepository.save(wallet);
        }
        return true;
    }
    public boolean deleteWalletUserBYId(int id){
        List<Wallet> listWallet = walletRepository.findAllByCustomer_Id(id);
        for(Wallet w : listWallet){
            walletRepository.delete(w);
        }

        return true;
    }

}
