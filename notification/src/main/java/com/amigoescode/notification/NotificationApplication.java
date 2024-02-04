package com.amigoescode.notification;

import com.amigoescode.amqp.RabitMQMessageProducer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(
    scanBasePackages = {"com.amigoescode.amqp","com.amigoescode.notification"}
)
@EnableEurekaClient
public class NotificationApplication {

  public static void main(String[] args) {
    SpringApplication.run(NotificationApplication.class, args);
  }

  // To run the RabitMQ producer. use the below code. This is for testing purpose.
//  @Bean
//  CommandLineRunner commandLineRunner(RabitMQMessageProducer producer, NotificationConfig notificationConfig)
//  {
//    return args -> {
//      producer.publish("foo", notificationConfig.getInternalExchange(),
//          notificationConfig.getInternalNotificationRoutingKey());
//    };
//  }
}
