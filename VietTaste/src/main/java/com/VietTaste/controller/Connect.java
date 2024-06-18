package com.VietTaste.controller;

import org.bouncycastle.jcajce.BCFKSLoadStoreParameter.SignatureAlgorithm;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class Connect {

    @GetMapping("/")
    public String connect() {
        return "connect";
    }

    private static final String SECRET_KEY = "your-secret-key";

    @PostMapping("/connect")
    public ResponseEntity<String> connectWallet(@RequestBody WalletRequest request) {
        // Xác thực ví bằng cách kiểm tra chữ ký
        boolean isValid = validateSignature(request.getPublicKey(), request.getSignature(), request.getMessage());

        if (isValid) {
            String token = Jwts.builder()
                    .setSubject(request.getPublicKey())
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 1 day
                    .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                    .compact();

            return ResponseEntity.ok(token);
        } else {
            return ResponseEntity.status(401).body("Invalid Signature");
        }
    }

    private boolean validateSignature(String publicKey, String signature, String message) {
        // Thực hiện việc kiểm tra chữ ký của ví Phantom
        // Đây là phần mã cần được triển khai cụ thể
        return true; // Chỉ là ví dụ, cần kiểm tra chữ ký thực tế
    }
}
