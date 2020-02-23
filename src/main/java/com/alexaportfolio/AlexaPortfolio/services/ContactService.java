package com.alexaportfolio.AlexaPortfolio.services;

import com.alexaportfolio.AlexaPortfolio.models.EmailForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    private JavaMailSender javaMailSender;

    @Autowired
    public ContactService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendEmail(EmailForm emailForm) throws MailException {
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo("crodfranco@gmail.com");
        email.setFrom(emailForm.getEmail());
        email.setSubject(emailForm.getName());
        email.setText(emailForm.getMessage());
        javaMailSender.send(email);
    }
}
