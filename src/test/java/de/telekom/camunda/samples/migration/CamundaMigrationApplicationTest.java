package de.telekom.camunda.samples.migration;

import io.camunda.zeebe.client.ZeebeClient;
import io.camunda.zeebe.client.api.response.ProcessInstanceEvent;
import io.camunda.zeebe.process.test.assertions.BpmnAssert;
import io.camunda.zeebe.spring.test.ZeebeSpringTest;
import io.camunda.zeebe.spring.test.ZeebeTestThreadSupport;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;

@SpringBootTest
@ZeebeSpringTest
class CamundaMigrationApplicationTest {

    private static final String PROCESS_ID = "OrderPizzaProcess";
    private static final String TASK_ID_CREATE_ORDER = "CreateOrderTask";
    private static final String TASK_ID_RECEIVE_PAYMENT = "ReceivePaymentTask";
    private static final String TASK_ID_MAKE_PIZZA = "MakePizzaTask";
    private static final String TASK_ID_HANDOVER_DELIVERY = "HandoverDeliveryTask";

    private static final Duration TIMEOUT = Duration.ofMinutes(5);

    @Autowired
    private ZeebeClient zeebeClient;

    @Test
    void shouldStartProcess() {
        ProcessInstanceEvent processInstance = zeebeClient.newCreateInstanceCommand()
                .bpmnProcessId(PROCESS_ID)
                .latestVersion()
                .send()
                .join();

        ZeebeTestThreadSupport.waitForProcessInstanceCompleted(processInstance, TIMEOUT);

        BpmnAssert.assertThat(processInstance)
                .hasPassedElement(TASK_ID_CREATE_ORDER)
                .hasPassedElement(TASK_ID_RECEIVE_PAYMENT)
                .hasPassedElement(TASK_ID_MAKE_PIZZA)
                .hasPassedElement(TASK_ID_HANDOVER_DELIVERY)
                .isCompleted();
    }
}