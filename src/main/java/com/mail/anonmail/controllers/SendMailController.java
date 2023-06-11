package com.mail.anonmail.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mail.anonmail.models.MessageModel;
import com.mail.anonmail.utils.smtp.SmtpSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class SendMailController {
    @PostMapping(value ="/sendMail", consumes = {"application/json"})
    @ResponseBody
    public void sendMail(@RequestBody String message) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            MessageModel messageModel = objectMapper.readValue(message, MessageModel.class);
            (new SmtpSender()).sendMail(messageModel);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
