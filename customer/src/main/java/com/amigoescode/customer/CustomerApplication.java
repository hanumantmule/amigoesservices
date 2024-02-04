package com.amigoescode.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(
    scanBasePackages = {
        "com.amigoescode.amqp",
        "com.amigoescode.customer"
    }
)
@EnableEurekaClient
@EnableFeignClients(
    basePackages = "com.amigoescode.clients"
)
public class CustomerApplication {

  public static void main(String[] args) {
    SpringApplication.run(CustomerApplication.class,args);
  }
}
