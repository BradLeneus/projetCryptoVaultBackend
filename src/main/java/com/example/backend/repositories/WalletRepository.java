package com.example.backend.repositories;


import com.example.backend.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WalletRepository extends JpaRepository<Wallet, Integer> {

    public List<Wallet> findAllByCustomer_Id(int id);
}

