package com.example.backend.Service;

import com.example.backend.model.CustomerNoPwd;
import com.example.backend.model.Wallet;
import com.example.backend.repositories.WalletRepository;
import org.springframework.stereotype.Service;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class WalletService {

    private final WalletRepository walletRepository;
    private List<Wallet> walletList = null;
    public WalletService(WalletRepository walletRepository){
        this.walletRepository = walletRepository;
    }


    public List<Wallet> getAll(){
        List<Wallet> listTempo = walletRepository.findAll();
        if(listTempo != null){
            for (Wallet w : listTempo){
                w.getCustomer().setLname(null);

            }
            return listTempo;
        }
        return null;
    }

    public List<Wallet> getByUserId(int id){
        List<Wallet> listTempo = walletRepository.findAllByCustomer_Id(id);
        if(listTempo != null){
            for (Wallet w : listTempo){
                w.getCustomer().setLname(null);
            }
            return  listTempo;
        }
        else {
            return null;
        }

    }

    // pas utilisé, un peu un bug mais c'etais drole
    public List<Wallet> getByUserIdFunny(int id){
        List<Wallet> listTempo = walletRepository.findAllByCustomer_Id(id);
        if(walletList == null){
            walletList = listTempo;
            return listTempo;
        }
        else {
            for(Wallet w : listTempo){
                if(walletList.contains(w)){
                    walletList.get( walletList.indexOf(w)).getIdcrypto().setPrice(555.55);
                }
                else {
                    walletList.add(w);
                }
            }
            return walletList;
        }
    }

    // cree ou modifie, le nom porte a confusion
    public boolean createWallet(Wallet wallet){
        Wallet temp = walletRepository.findWalletByCustomer_IdAndIdcrypto_Id(wallet.getCustomer().getId(), wallet.getIdcrypto().getId());
        if(temp != null){
            // just pour arrondir
            double tempo = Math.round(wallet.getQty()*10000.0)/10000.0;
            temp.setQty(tempo);
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
