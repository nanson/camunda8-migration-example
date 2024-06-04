Generate job worker for every service task in bpmn with spring-boot-starter-camunda-sdk.

Use separate class for each worker.
Use lombok annotation @RequiredArgsConstructor and final fields for dependencies injection.

Annotate worker method with @JobWorker annotation without additional attributes.
For method name use task id from bpmn, starting with lowercase letter and without ending "Task" if exists.
As method body use value from tag "zeebe:header" expression.
Get required process variables as method arguments with annotation @Variable without additional attributes.
If task doesn't contain tag "zeebe:header" resultVariable, then method should return void.
If task contains tag  "zeebe:header" resultVariable, then store result of method body in Map with key equals attribute value from the header and return this Map from the method.

Provide each worker in separate code snippet

Example of worker:

```java
import com.tsystems.tm.l2bsa.activation.model.enums.Variables;
import com.tsystems.tm.l2bsa.activation.service.SoService;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import io.camunda.zeebe.spring.client.annotation.Variable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

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
```
