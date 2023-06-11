package com.mail.anonmail.controllers;

import com.mail.anonmail.models.MessageModel;
import com.mail.anonmail.services.email.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SendMailController {
    @Autowired
    private EmailService emailService;

    @PostMapping(value ="/sendMail", consumes = {"application/json"})
    @ResponseBody
    public ResponseEntity<MessageModel> sendMail(@RequestBody MessageModel message) {
        Boolean status = emailService.sendSimpleMail(message);
        if(status) {
            return ResponseEntity.ok(message);
        }

        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }
}
