package com.amigoescode.fraud;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FraudCheckService {

  @Autowired
  FraudCheckHistoryRepository fraudCheckHistoryRepository;
  public Boolean isFraudelantCustomer(Integer customerId) {

    fraudCheckHistoryRepository.save(FraudCheckHistory.builder()
        .customerId(customerId)
        .createdAt(LocalDateTime.now())
        .isFraudster(Boolean.FALSE)
        .build()
    );
    return false;
  }
}
