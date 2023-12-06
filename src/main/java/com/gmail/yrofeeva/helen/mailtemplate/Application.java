package com.gmail.yrofeeva.helen.mailtemplate;

import com.gmail.yrofeeva.helen.mailtemplate.content.HtmlContextHandler;
import com.gmail.yrofeeva.helen.mailtemplate.content.TextContextHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {
    @Autowired
    HtmlContextHandler htmlContextHandler;
    @Autowired
    TextContextHandler textContextHandler;

    private static final Logger log = LoggerFactory
            .getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("hi");

        var content = htmlContextHandler.getContent();
        log.info("html content: \n{}\n", content);

        content = textContextHandler.getContent();
        log.info("text content: \n{}\n", content);
    }
}
