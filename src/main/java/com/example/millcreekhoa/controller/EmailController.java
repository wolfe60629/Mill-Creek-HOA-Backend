package com.example.millcreekhoa.controller;

import com.example.millcreekhoa.data.DocumentDto;
import com.example.millcreekhoa.data.Mail;
import com.example.millcreekhoa.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

@RestController
public class EmailController {

    @Autowired
    EmailService emailService;

    @PostMapping(value = "/sendEmail/newRequest")
    public void sendEmail(@RequestBody DocumentDto document) throws MessagingException {
        this.emailService.sendEmail(new Mail(
                "jawolfe125@gmail.com",
                "New Request",
                "",
                document.getItem())
        );
    }
}
