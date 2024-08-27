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
public class FoodCategoryId implements Serializable {
    @Column(name = "Food_Id")
    private String foodId;

    @Column(name = "Category_Id")
    private Integer categoryId;

}
