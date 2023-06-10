package com.mail.anonmail.routes;

import com.mail.anonmail.models.MessageModel;
import com.mail.anonmail.utils.smtp.SmtpSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Properties;

@Controller
public class SendMailRoute {
    @PostMapping("/sendMail")
    public String sendMail(@ModelAttribute("message") MessageModel message) {
        (new SmtpSender()).sendMail(message);
        return "index";
    }
}
