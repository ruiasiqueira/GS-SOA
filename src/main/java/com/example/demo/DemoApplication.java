package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan; // Certifique-se de ter este import

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.demo", "com.example.emergencia", "com.example.usuario"})
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}