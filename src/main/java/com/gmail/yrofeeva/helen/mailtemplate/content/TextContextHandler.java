package com.gmail.yrofeeva.helen.mailtemplate.content;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Component
public class TextContextHandler {
    @Autowired
    private TemplateEngine textTemplateEngine;

    public String getContent() {
        final Context context = new Context();
        context.setVariable("intake_title", "Demo Intake");
        context.setVariable("intake_subtitle", "Demo Subtitle");
        context.setVariable("intake_description", "Demo Description");
        context.setVariable("intake_id", "Demo Id");
        return textTemplateEngine.process("template", context);
    }
}
