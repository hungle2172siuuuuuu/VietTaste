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
@Table(name = "Restaurant")
public class Restaurant {
    @Id
    @Column(name = "Id")
    private String id;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Registration_Number", unique = true, nullable = false)
    private String registrationNumber;

    @Column(name = "Address", nullable = false)
    private String address;

    @Column(name = "Phone_Number", length = 20)
    private String phoneNumber;

    @Column(name = "Email")
    private String email;


    @Column(name = "Business_License", unique = true, nullable = false)
    private String businessLicense;

    @Column(name = "Food_Safety_License", unique = true, nullable = false)
    private String foodSafetyLicense;

    @ManyToOne
    @JoinColumn(name = "User_Id", nullable = false)
    private Users user;

    @Column(name = "Status", nullable = false)
    private String status;

}

