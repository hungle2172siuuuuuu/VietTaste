package com.vt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vt.model.Wallet;

@Repository
public interface WalletDAO extends JpaRepository<Wallet, String> {
    
}
