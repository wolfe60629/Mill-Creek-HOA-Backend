package com.example.millcreekhoa.controller;

import com.example.millcreekhoa.data.DocumentDto;
import com.example.millcreekhoa.data.Mail;
import com.example.millcreekhoa.service.EmailService;
import com.example.millcreekhoa.service.SettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.Date;

@RestController
public class EmailController {

    @Autowired
    EmailService emailService;

    @Autowired
    SettingsService settingsService;

    @PostMapping(value = "/sendEmail/newRequest")
    public void sendEmail(@RequestBody DocumentDto document,
                          @RequestParam(required = false) String name,
                          @RequestParam(required = false) String email) throws MessagingException {
        if (name == null) {
            name = "No Name Was Provided";
        }

        if (email == null) {
            email = "No Email Was Provided";
        }

        this.emailService.sendEmail(new Mail(
                this.settingsService.getSettingBySettingName("requestEmail").getValue(),
                "New ARC Request: " + name,

                "AUTOMATED MESSAGE: DO NOT REPLY \n \n" +
                        "Requester: " + name + "\n" +
                        "Reply Email: " + email + "\n" +
                        "Submitted Time: " + new Date().toLocaleString(),

                document.getItem())
        );
    }
}
