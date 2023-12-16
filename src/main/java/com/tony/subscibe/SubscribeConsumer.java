package com.tony.subscibe;

import com.tony.Student;
import com.tony.common.MyConsumer;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SubscribeConsumer {

    @Autowired
    private MyConsumer myConsumer;

    @RabbitListener(queues = "${queue.name.1}")
    public void consumer1(Student student) {
        myConsumer.msg(1, student);
    }

    @RabbitListener(queues = "${queue.name.2}")
    public void consumer2(Student student) {
        myConsumer.msg(2, student);
    }

    @RabbitListener(queues = "${queue.name.3}")
    public void consumer3(Student student) {
        myConsumer.msg(3, student);
    }
}