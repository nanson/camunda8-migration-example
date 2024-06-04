package de.telekom.camunda.samples.migration.worker;

import de.telekom.camunda.samples.migration.service.OrderService;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CreateOrderWorker {

    private final OrderService orderService;

    @JobWorker
    public Map<String, Object> createOrder() {
        UUID orderId = orderService.create();
        return Map.of("orderId", orderId);
    }
}
