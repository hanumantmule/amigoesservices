package com.amigoescode.customer;

import com.amigoescode.amqp.RabitMQMessageProducer;
import com.amigoescode.clients.fraud.FraudClient;
import com.amigoescode.clients.notification.NotificationClient;
import com.amigoescode.clients.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class CustomerService {

@Autowired
CustomerRepository customerRepository;

  //private final RestTemplate restTemplate;
  private final FraudClient fraudClient;
  private final NotificationClient notificationClient;

  private final RabitMQMessageProducer producer;

//  public CustomerService(RestTemplate restTemplate) {
//    this.restTemplate = restTemplate;
//  }



  public void register(CustomerRegistrationRequest customerRegistrationRequest) {
    Customer customer = Customer.builder()
        .firstName(customerRegistrationRequest.getFirstName())
        .lastName(customerRegistrationRequest.getLastName())
        .email(customerRegistrationRequest.getEmail())
        .build();

    customerRepository.saveAndFlush(customer);

//     Call the Microservice Using RestTemplate
//
//    Boolean isFraudster = restTemplate.getForObject(
//        "http://localhost:8081/api/v1/frauds/{customerId}",
//        Boolean.class,
//        customer.getId()
//        );
//
//     Call the Microservice using Eureka Service discovery
//     Just give the application Name which is present in the Eureka dashbaord
//
//    Boolean isFraudster = restTemplate.getForObject(
//        "http://FRAUD/api/v1/frauds/{customerId}",
//        Boolean.class,
//        customer.getId()
//    );

    // Instead of using RestTemplate we can use OpenFeign
    // Feign is a Java to HTTP client binder inspired by Retrofit, JAXRS-2.0, and WebSocket. Feign's first goal was reducing the complexity of binding Denominator uniformly to HTTP APIs regardless of ReSTfulness.

    Boolean isFraudster =  fraudClient.isFraudelantCustomer(customer.getId());


    if(isFraudster)
      throw new IllegalStateException("Fraudelent Customer");
    else {
      // Notify Customer here in notification microservice

//      notificationClient.notifyCustomer(NotificationRequest.builder()
//          .customerId(customer.getId())
//          .customerEmail(customer.getEmail())
//          .message("Welcome to AmigosCode")
//          .sender("Amigos Code")
//          .build());


      // publish the notification to RabitMQ queue
      NotificationRequest notificationRequest = NotificationRequest.builder()
          .customerId(customer.getId())
          .customerEmail(customer.getEmail())
          .message("Welcome to AmigosCode")
          .sender("Amigos Code")
          .build();

      producer.publish(notificationRequest, "internal.exchange","internal.notification.routing-key");



    }

  }
}
