package de.telekom.camunda.samples.migration.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class PizzaService {

    public void create(UUID orderId) {
        log.info("Pizza created, orderId: {}", orderId);
    }
}
