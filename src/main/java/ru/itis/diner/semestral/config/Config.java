package ru.itis.diner.semestral.config;

import freemarker.template.TemplateExceptionHandler;
import lombok.Builder;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassRelativeResourceLoader;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.freemarker.SpringTemplateLoader;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;
import ru.itis.diner.semestral.aspects.MyLoggerAspect;
import ru.itis.diner.semestral.services.*;
import ru.itis.diner.semestral.services.AchievementService;
import ru.itis.diner.semestral.services.ShopService;
import ru.itis.diner.semestral.viewresolvers.MyViewResolver;

@Configuration
public class Config {

    @Bean
    public MyLoggerAspect myLoggerAspect() {
        return new MyLoggerAspect();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SignUpService getSignUpService() {
        return new SignUpServiceImpl();
    }

    @Bean
    public UserService getUserService() {
        return new UserServiceImpl();
    }

    @Bean
    public ShopService getShopService() {
        return new ShopServiceImpl();
    }

    @Bean
    public AchievementService getAchievementService() {
        return new AchievementServiceImpl();
    }

    @Bean
    public ProfileService getProfileService(){
        return new ProfileServiceImpl();
    }
}