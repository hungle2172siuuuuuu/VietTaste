package com.vt.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Food {

    @Id
    private String id;
    private String name;
    private String description;
    private String image; // Image path
    private double price;

    @ManyToOne
    private Stall stall;
}
