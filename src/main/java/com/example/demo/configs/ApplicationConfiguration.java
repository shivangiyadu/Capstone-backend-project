package com.example.demo.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
//when spring will start then it will find  all the configuration classes annoted class @bean Whatever objects these classes will return spring will store the application context
public class ApplicationConfiguration {
    @Bean
    public RestTemplate createRestTemplate()
    {

        return new RestTemplate();
    }
}
