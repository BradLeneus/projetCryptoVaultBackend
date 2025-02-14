package com.example.backend.repositories;

import com.example.backend.model.Crypto;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CryptoRepository extends JpaRepository<Crypto, Integer> {
}
