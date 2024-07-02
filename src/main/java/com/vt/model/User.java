package com.vt.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "User_Id")
    private int userId;

    @NotBlank(message = "Tên người dùng không được để trống")
    @Size(max = 50, message = "Tên người dùng không được vượt quá 50 ký tự")
    @Column(name = "Username", unique = true)
    private String username;

    @NotBlank(message = "Mật khẩu không được để trống")
    @Size(max = 30, message = "Mật khẩu không được vượt quá 30 ký tự")
    @Column(name = "Password")
    private String password;

    @NotBlank(message = "Email không được để trống")
    @Email(message = "Email không hợp lệ")
    @Column(name = "Email")
    private String email;

    @NotBlank(message = "Vai trò không được để trống")
    @Column(name = "Role")
    private String role;
    
    @Transient // Trường này không được lưu vào database
    private String confirmPassword;
}