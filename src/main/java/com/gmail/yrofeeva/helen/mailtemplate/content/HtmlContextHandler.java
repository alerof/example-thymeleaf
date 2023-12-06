package com.gmail.yrofeeva.helen.mailtemplate.content;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.Arrays;
import java.util.Date;

@Component
public class HtmlContextHandler {
    @Autowired
    private TemplateEngine htmlTemplateEngine;

    public String getContent(){
        final Context context = new Context();
        context.setVariable("name", "Name");
        context.setVariable("subscriptionDate", new Date());
        context.setVariable("hobbies", Arrays.asList("Cinema", "Sports", "Music"));
        context.setVariable("imageResourceName", "images.jpg");
        return htmlTemplateEngine.process("template", context);
    }
}
