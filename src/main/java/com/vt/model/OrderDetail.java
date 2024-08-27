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
@Table(name = "Order_Detail")
public class OrderDetail {
    @Id
    @Column(name = "Id")
    private String id;

    @Column(name = "Quantity", nullable = false)
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "Food_Id", nullable = false)
    private Food food;

    @ManyToOne
    @JoinColumn(name = "Order_Id", nullable = false)
    private Order order;
}
