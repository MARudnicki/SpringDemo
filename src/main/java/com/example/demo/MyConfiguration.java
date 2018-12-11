package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(value = "my-super-configuration")
public class MyConfiguration {

    @Bean("Bajki Robotow")
    public Book robotFairies() {
        return new Book("Bajki Robotow");
    }

    @Bean("Wiedzmin")
    public Book witcher() {
        return new Book("Wiedzmin");
    }

}
