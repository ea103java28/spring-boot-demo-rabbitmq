## Introduction

Testing RabbitMQ with SpringBoot.

## Environment

1. Java JDK 8
2. Spring Boot: 2.3.7.RELEASE

## Technologies

1. RabbitMQ
2. Lombok


### API：

   |*method*|*url*|*description*|
   |--|--|--|
   |GET|`http://localhost:8888/direct/send`|Direct Mode|
   |GET|`http://localhost:8888/worker/send`|Worker Mode|
   |GET|`http://localhost:8888/subscribe/send`|Publish/Subscribe Mode|
   |GET|`http://localhost:8888/routing/send`|Routing Mode|
   |GET|`http://localhost:8888/topics/send`|Topics Mode|



### Dockerfile：

```
FROM rabbitmq:management

ENV RABBITMQ_DEFAULT_USER=root
ENV RABBITMQ_DEFAULT_PASS=1234

EXPOSE 15672 5672
```


```
$ docker build -t my-rabbitmq .

$ docker run --name my-rabbitmq -d -p 15672:15672 -p 5672:5672 my-rabbitmq
```

