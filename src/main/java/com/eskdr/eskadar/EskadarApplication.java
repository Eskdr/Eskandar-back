package com.eskdr.eskadar;

import com.eskdr.eskadar.data.User;
import com.eskdr.eskadar.data.Voice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EskadarApplication {

    static public User user = null;
    static public Voice voice = null;

    public static void main(String[] args) {
        user = new User();
        voice = new Voice();

        SpringApplication.run(EskadarApplication.class, args);

        user.close();
        voice.close();
    }

}