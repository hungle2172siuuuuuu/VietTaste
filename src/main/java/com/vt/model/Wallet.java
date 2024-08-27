package com.vt.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Wallet")
public class Wallet {
    @Id
    @Column(name = "Wallet_Id")
    private String walletId;

    @Column(name = "Balance", nullable = false)
    private long balance;

    @ManyToOne
    @JoinColumn(name = "User_Id", nullable = false)
    private Users user;
}
