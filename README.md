# Winter Wonder Hack - Arbor Networks Demo

## Prerequisites

1. Install minikube (https://kubernetes.io/docs/tasks/tools/install-minikube/)
2. Install scala (from your friendly neighborhood package manager)
3. Install sbt (https://www.scala-sbt.org/1.0/docs/Setup.html)


### Starting the Cluster

1. Run the following commands to setup minikube:
```
$ minikube start --memory 4096
$ kubectl create configmap env-config --from-literal=env.cloud=local
```
2. Run `eval $(minikube docker-env)` to use the minikube docker environment
3. Run the following commands to setup the kafka service:
```
$ kubectl apply -f kubernetes-kafka/configure/minikube-storageclass-broker.yml
$ kubectl apply -f kubernetes-kafka/configure/minikube-storageclass-zookeeper.yml
$ kubectl apply -f kubernetes-kafka/zookeeper
$ kubectl apply -f kubernetes-kafka/kafka
$ kubectl exec --namespace=kafka kafka-0 -- bash -c "export JMX_PORT=9998; ./bin/kafka-topics.sh --create --topic indicators --zookeeper zookeeper.kafka.svc.cluster.local:2181 --partitions 1 --replication-factor 1"
```
4. Run the following commands to setup the API endpoint:
```
$ cd api/sbt/
$ sbt assembly
$ cd ../
$ docker build -t demo-api:demo .
$ kubectl create -f api-rc.yaml
$ cd ../
```
5. Run the following commands to setup the Kafka Producers:
```
$ cd producer/sbt/
$ sbt assembly
$ cd ../
$ docker build -t demo-producer:demo producer/
$ kubectl create -f producer/producer-rc.yaml
$ cd ../
```
