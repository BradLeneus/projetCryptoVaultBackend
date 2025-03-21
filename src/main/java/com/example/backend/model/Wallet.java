package com.example.backend.model;

import com.example.backend.repositories.CryptoRepository;
import jakarta.persistence.*;

@Entity
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double qty;
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Crypto idcrypto;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Crypto getIdcrypto() {
        return idcrypto;
    }

    public void setIdcrypto(Crypto idcrypto) {
        this.idcrypto = idcrypto;
    }
}
