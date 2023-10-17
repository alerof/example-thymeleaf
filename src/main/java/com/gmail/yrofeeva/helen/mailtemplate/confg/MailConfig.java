package com.gmail.yrofeeva.helen.mailtemplate.confg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

import java.nio.charset.StandardCharsets;

@Configuration
public class MailConfig {

  @Bean
  public TemplateEngine emailTemplateEngine() {
    final SpringTemplateEngine templateEngine = new SpringTemplateEngine();
    templateEngine.addTemplateResolver(htmlTemplateResolver());
    return templateEngine;
  }

  @Bean
  public ITemplateResolver htmlTemplateResolver() {
    SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
    templateResolver.setPrefix("classpath:/email/html/");
    templateResolver.setSuffix(".html");
    templateResolver.setOrder(1);
    templateResolver.setTemplateMode("HTML5");
    templateResolver.setCharacterEncoding(StandardCharsets.UTF_8.name());
    templateResolver.setCacheable(false);
    templateResolver.setCheckExistence(true);
    return templateResolver;
  }

}
