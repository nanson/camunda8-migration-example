package de.telekom.camunda.samples.migration;

import io.camunda.zeebe.spring.client.annotation.Deployment;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Deployment(resources = "classpath:/bpmn/camunda-8/order-pizza.bpmn")
public class CamundaMigrationApplication {

    public static void main(String[] args) {
        SpringApplication.run(CamundaMigrationApplication.class, args);
    }

}
