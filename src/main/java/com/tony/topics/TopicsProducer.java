package com.tony.topics;

import com.tony.Student;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TopicsProducer {

    @Autowired
    private AmqpTemplate rabbitmqTemplate;

    @Value("${exchange.t.name.1}")
    String exchangeName;

    public void send(Student student) {
        String routingKey = student.getName();
        rabbitmqTemplate.convertAndSend(exchangeName, routingKey, student);
        System.out.println("send message " + student + " to " + exchangeName + "  successfully");
    }

}
