package com.vt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;

    public void sendResetCode(String to, String code) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("quinaps31917@fpt.edu.vn"); // Thay đổi địa chỉ email gửi
        message.setTo(to);
        message.setSubject("Mã khôi phục mật khẩu");
        message.setText("Mã khôi phục của bạn là: " + code);
        emailSender.send(message);
    }
}
