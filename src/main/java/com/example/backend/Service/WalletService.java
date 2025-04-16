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
    /*public List<Wallet> getByUserIdFilter(int id){
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
    } */
    public List<Wallet> getByUserId(int id){
        List<Wallet> listTempo = walletRepository.findAllByCustomer_Id(id);
        if(listTempo != null){
            return  listTempo;
        }
        else {
            return null;
        }

    }
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
    public boolean createWallet(Wallet wallet){
        Wallet temp = walletRepository.findWalletByCustomer_IdAndIdcrypto_Id(wallet.getCustomer().getId(), wallet.getIdcrypto().getId());
        if(temp != null){


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
