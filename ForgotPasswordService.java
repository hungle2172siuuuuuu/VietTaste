package com.vt.service;

import org.springframework.stereotype.Service;

@Service
public class ForgotPasswordService {

    // Các phương thức để xử lý mã reset password
    public String generateResetCode() {
        // Generate and return a unique reset code
        return "123456"; // Placeholder code
    }

    public boolean validateResetCode(String code) {
        // Validate the reset code
        return "123456".equals(code); // Placeholder validation
    }
}
