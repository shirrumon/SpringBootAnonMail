package com.mail.anonmail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@SpringBootApplication
@EnableConfigurationProperties(UriConfiguration.class)
@RestController
public class AnonmailApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(AnonmailApplication.class, args);
    }

    @RequestMapping("/fallback")
    public Mono<String> fallback() {
        return Mono.just("fallback");
    }
}

@ConfigurationProperties
class UriConfiguration {

    private String http = "http://localhost:8080";

    public String getHttp() {
        return http;
    }

    public void setHttp(String http) {
        this.http = http;
    }
}