package com.eskdr.eskadar;

import com.eskdr.eskadar.data.Database;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EskadarApplication {
    public static void main(String[] args) {
        SpringApplication.run(EskadarApplication.class, args);

        Database.close();
    }

}