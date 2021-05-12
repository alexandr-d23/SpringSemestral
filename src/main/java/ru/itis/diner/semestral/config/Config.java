package ru.itis.diner.semestral.config;

import freemarker.template.TemplateExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassRelativeResourceLoader;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.freemarker.SpringTemplateLoader;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ru.itis.diner.semestral.aspects.MyLoggerAspect;
import ru.itis.diner.semestral.services.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

@Configuration
public class Config  implements WebMvcConfigurer {

    @Bean
    public freemarker.template.Configuration configuration() {
        freemarker.template.Configuration configuration = new freemarker.template.Configuration(freemarker.template.Configuration.VERSION_2_3_30);
        configuration.setDefaultEncoding("UTF-8");
        configuration.setTemplateLoader(
                new SpringTemplateLoader(new ClassRelativeResourceLoader(this.getClass()),
                        "/"));
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        return configuration;
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public Logger getLogger(){
        return Logger.getLogger("Spring semestral logger");
    }

    @Bean
    public ExecutorService executorService() {
        return Executors.newCachedThreadPool();
    }

    @Bean
    public MyLoggerAspect myLoggerAspect() {
        return new MyLoggerAspect();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}