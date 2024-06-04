package de.telekom.camunda.samples.migration.worker;

import de.telekom.camunda.samples.migration.service.PizzaService;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import io.camunda.zeebe.spring.client.annotation.Variable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class MakePizzaWorker {

    private final PizzaService pizzaService;

    @JobWorker
    public void makePizza(@Variable UUID orderId) {
        pizzaService.create(orderId);
    }
}
