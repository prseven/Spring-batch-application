package com.techprimers.springbatchexample1.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;


@Component
public class MailUtil {

    @Autowired
    private JavaMailSender sender;

    public String  sendEmail(String toEmail, String body, String subject) {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);
        message.setFrom("1dt17is059praveenv@gmail.com");
        sender.send(message);
        System.out.println("mail sent succesfully");

        return null;
    }
}
