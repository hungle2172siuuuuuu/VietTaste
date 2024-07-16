package com.vt.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Users") // Ánh xạ tới bảng "Users" trong cơ sở dữ liệu
public class Users {
    @Id
    @Column(name = "User_Id")
    private String userId;

    @Column(name = "Username")
    private String username;

    @Column(name = "Password")
    private String password;

    @Column(name = "Email")
    private String email;

    @Column(name = "Role")
    private String role;

    // Constructors, getters, and setters
}
