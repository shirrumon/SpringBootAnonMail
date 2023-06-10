package com.mail.anonmail.models;

public class MessageModel {
    private String $mailTo;
    private String $subject;
    private String $content;

    public String get$mailTo() {
        return $mailTo;
    }

    public void set$mailTo(String $mailTo) {
        this.$mailTo = $mailTo;
    }

    public String get$subject() {
        return $subject;
    }

    public void set$subject(String $subject) {
        this.$subject = $subject;
    }

    public String get$content() {
        return $content;
    }

    public void set$content(String $content) {
        this.$content = $content;
    }
}
