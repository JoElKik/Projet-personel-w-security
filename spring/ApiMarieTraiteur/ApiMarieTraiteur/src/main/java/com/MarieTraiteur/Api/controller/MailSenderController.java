package com.MarieTraiteur.Api.controller;

import org.springframework.web.bind.annotation.RestController;

import com.MarieTraiteur.Api.entity.Contact;
import com.MarieTraiteur.Api.services.MailSenderService;

import static org.springframework.http.HttpMethod.valueOf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class MailSenderController {
    @Autowired
    private MailSenderService mailSenderService;

   @PostMapping(path = "contact")
    public String sendEmail(@RequestBody Contact contact) {
        
      
       mailSenderService.sendEmail("joklfr647@gmail.com",contact.getMessage(),contact.getObjet());
       return "Sent successfully";
    }
    

}
