package com.mail.anonmail.services.email;

import com.mail.anonmail.models.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}") private String sender;

    public Boolean sendSimpleMail(MessageModel messageModel)
    {
        try {
            SimpleMailMessage mailMessage
                    = new SimpleMailMessage();
            mailMessage.setFrom(sender);
            mailMessage.setTo(messageModel.get$mailTo());
            mailMessage.setText(messageModel.get$content());
            mailMessage.setSubject(messageModel.get$subject());

            javaMailSender.send(mailMessage);
            return true;
        }

        catch (Exception e) {
            return false;
        }
    }
}