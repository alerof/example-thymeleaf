package com.gmail.yrofeeva.helen.mailtemplate.confg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

import java.nio.charset.StandardCharsets;

@Configuration
public class TemplateConfig {

  @Bean(name = "htmlTemplateEngine")
  public TemplateEngine htmlTemplateEngine() {
    final SpringTemplateEngine templateEngine = new SpringTemplateEngine();
    templateEngine.addTemplateResolver(htmlTemplateResolver());
    return templateEngine;
  }


  @Bean(name = "textTemplateEngine")
  public TemplateEngine textTemplateEngine() {
    final SpringTemplateEngine templateEngine = new SpringTemplateEngine();
    templateEngine.addTemplateResolver(textTemplateResolver());
    return templateEngine;
  }

  @Bean
  public ITemplateResolver htmlTemplateResolver() {
    SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
    templateResolver.setPrefix("classpath:/email/html/");
    templateResolver.setSuffix(".html");
    templateResolver.setOrder(1);
    templateResolver.setTemplateMode(TemplateMode.HTML);
    templateResolver.setCharacterEncoding(StandardCharsets.UTF_8.name());
    templateResolver.setCacheable(false);
    templateResolver.setCheckExistence(true);
    return templateResolver;
  }

  @Bean
  public ITemplateResolver textTemplateResolver() {
    SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
    templateResolver.setPrefix("classpath:/text/");
    templateResolver.setSuffix(".json");
    templateResolver.setOrder(2);
    templateResolver.setTemplateMode(TemplateMode.TEXT);
    templateResolver.setCharacterEncoding(StandardCharsets.UTF_8.name());
    templateResolver.setCacheable(false);
    templateResolver.setCheckExistence(true);
    return templateResolver;
    }
}
