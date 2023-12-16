package com.tony.direct;

import com.tony.Student;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class DirectConsumer {

    @RabbitListener(queues = "DIRECT_QUEUE")
    public void listen(Student student) {
        System.out.println("receive message from DIRECT_QUEUE: " + student);
    }
}