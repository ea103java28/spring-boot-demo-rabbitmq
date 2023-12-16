package com.tony.subscibe;

import com.tony.Student;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SubscribeProducer {

    @Autowired
    private AmqpTemplate rabbitmqTemplate;

    @Value("${exchange.f.name.1}")
    private String exchangeName;

    public void send(Student student) {
        rabbitmqTemplate.convertAndSend(exchangeName, "", student);
        System.out.println("send message " + student + " to " + exchangeName + "  successfully");
    }
}
