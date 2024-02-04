package com.amigoescode.fraud;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@RequestMapping("api/v1/frauds")
public class FraudController {

  @Autowired
  FraudCheckService fraudService;

  @GetMapping(path = "{customerId}")
  public Boolean isFraudelantCustomer(@PathVariable("customerId") Integer customerId)
  {
    log.info("Fraud check request for customer {}", customerId);
    return fraudService.isFraudelantCustomer(customerId);
  }

}
