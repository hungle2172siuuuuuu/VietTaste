package com.vt.model;

import java.time.LocalDate;

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
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Orders")
public class Order {
    @Column(name = "Create_Date", nullable = false)
    private LocalDate createDate;

    @Id
    @Column(name = "Id")
    private String id;

    @Column(name = "Status", nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "User_Id", nullable = false)
    private Users user; 

}