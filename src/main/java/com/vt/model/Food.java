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
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Food")
public class Food {
    @Id
    @Column(name = "Id")
    private String id;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Description", nullable = false)
    private String description;


    @Column(name = "Image", nullable = false)
    private String image;

    @Column(name = "Price", nullable = false)
    private double price;

    @ManyToOne
    @JoinColumn(name = "Stall_Id")
    private Stall stall;
}
