package com.example.backend.repositories;

import com.example.backend.model.Crypto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CryptoRepository extends JpaRepository<Crypto, Integer> {

    public List<Crypto> findAllByOrderByPriceDesc();
}
