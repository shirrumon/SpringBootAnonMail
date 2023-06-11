package com.mail.anonmail.controllers;

import com.mail.anonmail.models.MessageModel;
import com.mail.anonmail.utils.smtp.SmtpSender;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SendMailController {
    @PostMapping(value ="/sendMail", consumes = {"application/json"})
    @ResponseBody
    public ResponseEntity<MessageModel> sendMail(@RequestBody MessageModel message) {
        (new SmtpSender()).sendMail(message);
        return ResponseEntity.ok(message);
    }
}
