package com.example.millcreekhoa.service;

import com.example.millcreekhoa.data.Mail;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Base64;
import java.util.Properties;


@Service
public class EmailService {
    JavaMailSenderImpl javaMailSender;

    @Value("${javaMailUsername}")
    private String username;

    @Value("${javaMailPassword}")
    private String password;

    @Value("${javaMailHost}")
    private String host;

    @Value("${javaMailPort}")
    private String port;

    public void sendEmail(Mail email) throws MailException, MessagingException {
        // Set up mail sender
        if (this.javaMailSender == null) {
            this.javaMailSender = new JavaMailSenderImpl();
            javaMailSender.setHost(host);
            javaMailSender.setPort(Integer.parseInt(port));
            javaMailSender.setUsername(username);
            javaMailSender.setPassword(password);

            Properties props = javaMailSender.getJavaMailProperties();
            props.put("mail.transport.protocol", "smtp");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.debug", "false");
        }


        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(InternetAddress.parse(email.getEmail()));
        helper.setText(email.getMessage());
        byte[] doc = Base64.getDecoder().decode(email.getBase64());

        helper.addAttachment("Request.pdf", new ByteArrayResource(doc));

        helper.setSubject(email.getSubject());
        javaMailSender.send(message);
    }
}
