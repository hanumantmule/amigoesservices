package com.amigoescode.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CustomerRegistrationRequest {
  private String firstName;
  private String lastName;
  private String email;
}
