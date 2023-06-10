package com.mail.anonmail.utils.smtp;

import com.mail.anonmail.models.MessageModel;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

import java.util.Properties;

public class SmtpSender {
    public void sendMail(MessageModel model) {
        Properties prop = new Properties();

        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("dsfsf@gmail.com", "");
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("dsds@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO, InternetAddress.parse(model.get$mailTo()));
            message.setSubject(model.get$subject());

            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(model.get$content(), "text/html; charset=utf-8");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);

            message.setContent(multipart);

            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
