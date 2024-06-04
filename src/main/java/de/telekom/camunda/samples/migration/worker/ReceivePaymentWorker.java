package de.telekom.camunda.samples.migration.worker;

import de.telekom.camunda.samples.migration.service.PaymentService;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import io.camunda.zeebe.spring.client.annotation.Variable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ReceivePaymentWorker {

    private final PaymentService paymentService;

    @JobWorker
    public void receivePayment(@Variable UUID orderId) {
        paymentService.receive(orderId);
    }
}