package com.vt.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Cart")
public class Cart {

    @EmbeddedId
    private CartId id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "User_Id", nullable = false)
    private Users user;

    @ManyToOne
    @MapsId("foodId")
    @JoinColumn(name = "Food_Id", nullable = false)
    private Food food;
}
