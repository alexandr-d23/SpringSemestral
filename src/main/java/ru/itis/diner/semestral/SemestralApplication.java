package ru.itis.diner.semestral;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class SemestralApplication {

    public static void main(String[] args) {
        SpringApplication.run(SemestralApplication.class, args);
    }

}