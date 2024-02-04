package com.amigoescode.clients.notification;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.scheduling.annotation.Async;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class NotificationRequest {

  private String message;
  private String sender;
  private String customerEmail;
  private Integer customerId;
}
