package com.tony.routing;

import com.tony.Student;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RoutingProducer {

    @Autowired
    private AmqpTemplate rabbitmqTemplate;

    @Value("${exchange.d.name.1}")
    String exchangeName;

    public void send(Student student) {
        String routingKey = student.getName();
        rabbitmqTemplate.convertAndSend(exchangeName, routingKey, student);
        System.out.println("send message  to " + exchangeName + " successfully");
    }
}
