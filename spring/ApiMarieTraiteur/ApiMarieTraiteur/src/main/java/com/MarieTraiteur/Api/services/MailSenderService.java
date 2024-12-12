package com.MarieTraiteur.Api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.MarieTraiteur.Api.entity.Contact;

@Service
public class MailSenderService {

    @Autowired
    private JavaMailSender javaMailSender;
    @Value("$(spring.mail.username)")
    private String EmailId;
    public void sendEmail(String recipient,String body,String subject){

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(EmailId);
        simpleMailMessage.setTo(recipient);
        simpleMailMessage.setText(body);
        simpleMailMessage.setSubject(subject);
        javaMailSender.send(simpleMailMessage);

    }
}
