package com.amigoescode.notification;

import com.amigoescode.clients.notification.NotificationRequest;
import java.time.LocalDateTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NotificationService {

  @Autowired
  NotificationRepository notificationRepository;
  public void send(NotificationRequest notificationRequest) {

    Notification notification = Notification.builder()
        .customerId(notificationRequest.getCustomerId())
        .customerEmail(notificationRequest.getCustomerEmail())
        .message(notificationRequest.getMessage())
        .sender(notificationRequest.getSender())
        .sentAt(LocalDateTime.now())
        .build();

    notificationRepository.save(notification);

  }
}
