package de.telekom.camunda.samples.migration.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class DeliveryService {

    public void start(UUID orderId) {
        log.info("Order has been hanover to delivery service, orderId: {}", orderId);
    }
}
