package com.mail.anonmail.services.email;

import com.mail.anonmail.models.MessageModel;

public interface EmailService {
    Boolean sendSimpleMail(MessageModel messageModel);
}
