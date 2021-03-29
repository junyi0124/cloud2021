package com.atguigu.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {
//applicationContext.xml
    //@Configuration和@Bean 不能省略

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
