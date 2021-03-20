# Docker

## Images

You can reuse these images instead of creating and pushing new container images

- Currency Exchange Service 
	- v11 - ayush1608/currency-exchange-service:0.0.11-SNAPSHOT
  - v12 - ayush1608/currency-exchange-service:0.0.12-SNAPSHOT
- Currency Conversion Service
	- ayush1608/currency-conversion-service:0.0.11-SNAPSHOT
    - Uses CURRENCY_EXCHANGE_SERVICE_SERVICE_HOST
  - ayush1608/currency-conversion-service:0.0.12-SNAPSHOT
    - Uses CURRENCY_EXCHANGE_SERVICE_URI

## URLS

#### Currency Exchange Service
- http://localhost:8000/currency-exchange/from/USD/to/INR

#### Currency Conversion Service
- http://localhost:8100/currency-conversion/from/USD/to/INR/quantity/10


#### Commands
```


kubectl create deployment currency-exchange-service --image=ayush1608/currency-exchange-service:0.0.11-SNAPSHOT
kubectl expose deployment currency-exchange-service --type=LoadBalancer --port=8000
kubectl scale deployment currency-exchange-service --replicas=3
kubectl delete pod currency-exchange-service-58ff5dd898-62l9d
kubectl autoscale deployment currency-exchange-service --max=10 --cpu-percent=70
kubectl edit deployment currency-exchange-service #minReadySeconds: 15
kubectl set image deployment currency-exchange-service currency-exchange-service=currency-exchange-service:0.0.12-SNAPSHOT

kubectl get events
kubectl get pods
kubectl get replicaset
kubectl get deployment
kubectl get service

kubectl get pods -o wide

kubectl explain pods
kubectl get pods -o wide

kubectl describe pod currency-exchange-service-58ff5dd898-9trh2

kubectl get replicasets
kubectl get replicaset

kubectl scale deployment currency-exchange-service --replicas=3
kubectl get pods
kubectl get replicaset
kubectl get events
kubectl get events --sort.by=.metadata.creationTimestamp


kubectl create deployment currency-exchange-service --image=ayush1608/currency-exchange-service:0.0.11-SNAPSHOT
kubectl expose deployment currency-exchange-service --type=LoadBalancer --port=8000
kubectl get svc
kubectl get services
kubectl get pods
kubectl get po
kubectl get replicaset
kubectl get rs
kubectl get all

kubectl create deployment currency-conversion-service --image=ayush1608/currency-conversion-service:0.0.11-SNAPSHOT
kubectl expose deployment currency-conversion-service --type=LoadBalancer --port=8100

kubectl get svc --watch

kubectl get deployments

kubectl get deployment currency-exchange -o yaml >> deployment.yaml 
kubectl get service currency-exchange -o yaml >> service.yaml 

kubectl diff -f deployment.yaml
kubectl apply -f deployment.yaml

kubectl delete all -l app=currency-exchange-service
kubectl delete all -l app=currency-conversion-service

kubectl rollout history deployment currency-conversion-service
kubectl rollout history deployment currency-exchange-service
kubectl rollout undo deployment currency-exchange --to-revision=1

kubectl logs currency-exchange-service-9fc6f979b-2gmn8
kubectl logs -f currency-exchange-service-9fc6f979b-2gmn8 

kubectl autoscale deployment currency-exchange-service --min=1 --max=3 --cpu-percent=5 
kubectl get hpa

kubectl top pod
kubectl top nodes
kubectl get hpa
kubectl delete hpa currency-exchange

kubectl create configmap currency-conversion-service --from-literal=CURRENCY_EXCHANGE_SERVICE_URI=http://currency-exchange
kubectl get configmap

kubectl get configmap currency-conversion-service -o yaml >> configmap.yaml

watch -n 0.1 curl http://34.66.241.150:8100/currency-conversion/from/USD/to/INR/quantity/10

```