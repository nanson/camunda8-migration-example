## install camunda cluster

```bash
kind create cluster --name camunda-platform-local
helm repo add camunda https://helm.camunda.io
helm repo update
helm install camunda-platform camunda/camunda-platform -f camunda-platform-core-kind-values.yaml
```

## access to camunda cluster

```bash
kubectl port-forward svc/camunda-platform-zeebe-gateway 26500:26500 -n default
kubectl port-forward svc/camunda-platform-zeebe-gateway 8088:8080 -n default
kubectl port-forward svc/camunda-platform-operate  8081:80
kubectl port-forward svc/camunda-platform-tasklist 8082:80
```

## diagrams migration

  ```bash
java -Dfile.encoding=UTF-8 -jar backend-diagram-converter-cli-0.8.8.jar local src/main/resources/bpmn/camunda-7
  ```
