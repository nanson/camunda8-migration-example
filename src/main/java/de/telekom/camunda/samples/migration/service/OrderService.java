package de.telekom.camunda.samples.migration.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class OrderService {

    public UUID create() {
        var orderId = UUID.randomUUID();
        log.info("Order created, orderId: {}", orderId);
        return orderId;
    }

}
