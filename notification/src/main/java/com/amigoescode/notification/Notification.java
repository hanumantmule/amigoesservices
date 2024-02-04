package com.amigoescode.notification;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Notification {

  @Id
  @SequenceGenerator(
      name = "notification_id_seqeuce",
      sequenceName = "notification_id_seqeuce"
  )
  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "notification_id_seqeuce"
  )
  private Integer id;
  private String message;
  private String sender;
  private String customerEmail;
  private Integer customerId;
  private LocalDateTime sentAt;

}
