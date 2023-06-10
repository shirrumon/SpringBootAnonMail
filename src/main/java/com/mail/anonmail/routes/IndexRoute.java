package com.mail.anonmail.routes;

import com.mail.anonmail.models.MessageModel;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Controller
public class IndexRoute {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        MessageModel message = new MessageModel();
        model.addAttribute("message", message);

        return "index";
    }


    @Bean
    public ViewResolver getViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("templates/");

        return resolver;
    }
}
