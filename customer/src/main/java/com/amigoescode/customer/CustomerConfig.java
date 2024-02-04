package com.amigoescode.customer;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CustomerConfig {

    //Add LoadBalanced annotation to know which service instance to call by eureka server.
    // Otherwise it will give exception as Unknown Host
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
      return new RestTemplate();
    }
}
