package com.example.instructorapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.context.ApplicationContext;
@SpringBootApplication
public class InstructorapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(InstructorapiApplication.class, args);
    }
    @Bean
public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
    return args -> {
        System.out.println("--- Senarai Endpoint yang Didaftarkan ---");
        String[] beanNames = ctx.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            if (beanName.contains("Controller")) {
                System.out.println(beanName);
            }
        }
    };
}
}


