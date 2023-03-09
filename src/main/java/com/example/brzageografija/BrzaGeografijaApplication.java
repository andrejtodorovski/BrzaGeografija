package com.example.brzageografija;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class BrzaGeografijaApplication {

    public static void main(String[] args) {
        SpringApplication.run(BrzaGeografijaApplication.class, args);
    }

}
