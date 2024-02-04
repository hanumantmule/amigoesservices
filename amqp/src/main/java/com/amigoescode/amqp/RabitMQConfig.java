package com.amigoescode.amqp;

import lombok.AllArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class RabitMQConfig {

  private final ConnectionFactory connectionFactory;

  // Allow us to send the messages to the queue
  @Bean
  public AmqpTemplate amqpTemplate()
  {
    RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
    rabbitTemplate.setMessageConverter(jacksonConvertor());
    return rabbitTemplate;
  }


  // Allow us to receive the messages from the queue using jackson converter
  @Bean
  public SimpleRabbitListenerContainerFactory simpleRabbitListenerContainerFactory()
  {
    SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
    factory.setConnectionFactory(connectionFactory);
    factory.setMessageConverter(jacksonConvertor());
    return factory;
  }

  @Bean
  public MessageConverter jacksonConvertor()
  {
    MessageConverter jackson2JsonMessageConverter = new Jackson2JsonMessageConverter();
    return jackson2JsonMessageConverter;
  }
}
