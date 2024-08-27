package com.vt.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    @Column(name = "Id")
    private String id;

    @Column(name = "Username", unique = true, nullable = false, length = 50)
    private String username;

    @Column(name = "Password", nullable = false)
    private String password;

    @Column(name = "Email", unique = true, nullable = false)
    private String email;

    @Column(name = "Role", nullable = false, length  = 50)
    private String role;

    @Column(name = "Status", nullable = false, length = 20)
    private String status;

}
