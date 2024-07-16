package com.vt.controller.account;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api")
public class Connect {

    @GetMapping("/")
    public String connect() {
        return "connect";
    }
    
    @PostMapping("/account-info")
    public ResponseEntity<?> getAccountInfo(@RequestParam String publicKey) {
        // Mô phỏng thông tin tài khoản và tên người dùng
        String accountInfo = "Some additional account information";
        String username = "Quan Dai Bang"; // Thay bằng logic thực tế để lấy tên người dùng

        return ResponseEntity.ok(new AccountInfoResponse(accountInfo, username));
    }
    
    // Lớp phản hồi để trả về thông tin tài khoản và tên người dùng
    static class AccountInfoResponse {
        private String accountInfo;
        private String username;

        public AccountInfoResponse(String accountInfo, String username) {
            this.accountInfo = accountInfo;
            this.username = username;
        }

        public String getAccountInfo() {
            return accountInfo;
        }

        public void setAccountInfo(String accountInfo) {
            this.accountInfo = accountInfo;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }
}
