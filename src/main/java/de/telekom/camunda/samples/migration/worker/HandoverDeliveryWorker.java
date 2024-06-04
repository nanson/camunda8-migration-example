package de.telekom.camunda.samples.migration.worker;

import de.telekom.camunda.samples.migration.service.DeliveryService;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import io.camunda.zeebe.spring.client.annotation.Variable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class HandoverDeliveryWorker {

    private final DeliveryService deliveryService;

    @JobWorker
    public void handoverDelivery(@Variable UUID orderId) {
        deliveryService.start(orderId);
    }
}
