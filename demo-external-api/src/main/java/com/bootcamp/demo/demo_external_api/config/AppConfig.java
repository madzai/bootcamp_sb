package com.bootcamp.demo.demo_external_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.demo.demo_external_api.model.Cat;

// ! @Configuration + @Bean is for creating bean for external libray

@Configuration
public class AppConfig {
  @Bean
  RestTemplate restTemplate() {
    return new RestTemplate();
  }

  // ! If there are more than 1 Bean with the same type,
  @Bean
  Cat supercat() {
    return new Cat("JQK", 99);
  }

  @Bean
  Cat smallcat() {
    return new Cat("123", 100);
  }
}
