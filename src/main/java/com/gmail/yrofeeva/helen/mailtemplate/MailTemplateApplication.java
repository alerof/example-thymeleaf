package com.gmail.yrofeeva.helen.mailtemplate;

import com.gmail.yrofeeva.helen.mailtemplate.content.MailContextHandler;
import com.gmail.yrofeeva.helen.mailtemplate.email.MailServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MailTemplateApplication implements CommandLineRunner {
    @Autowired
    MailContextHandler contextHandler;
    @Autowired
    MailServiceImpl emailService;

    private static Logger log = LoggerFactory
            .getLogger(MailTemplateApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MailTemplateApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("hi");
        var str = contextHandler.getContentProjectNotificationEmail();
        emailService.sendSimpleMessage("from@org.com", "any@mail.com", "java test", str);
        log.info("content: {}", str);
    }
}
