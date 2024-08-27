package com.vt.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartId implements Serializable {
    @Column(name = "User_Id")
    private String userId;

    @Column(name = "Food_Id")
    private String foodId;
}
