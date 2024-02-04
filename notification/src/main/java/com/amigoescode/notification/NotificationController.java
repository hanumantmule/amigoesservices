package com.amigoescode.notification;

import com.amigoescode.clients.notification.NotificationRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/notifications")
public class NotificationController {

  @Autowired
  NotificationService notificationService;

  @PostMapping
  public void notifyCustomer(@RequestBody NotificationRequest notificationRequest)
  {
    log.info("Notification request for customer {}", notificationRequest);
     notificationService.send(notificationRequest);
  }

}
