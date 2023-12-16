package com.tony.routing;

import com.tony.Student;
import com.tony.common.MyConsumer;
import com.tony.common.MyConsumer;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoutingConsumer {

    @Autowired
    private MyConsumer myConsumer;

    @RabbitListener(queues = "${queue.name.4}")
    public void consumer4(Student student) {
        myConsumer.msg(4, student);
    }

    @RabbitListener(queues = "${queue.name.5}")
    public void consumer5(Student student) {
        myConsumer.msg(5, student);
    }

    @RabbitListener(queues = "${queue.name.6}")
    public void consumer6(Student student) {
        myConsumer.msg(6, student);
    }

    @RabbitListener(queues = "${queue.name.66}")
    public void consumer66(Student student) {
        myConsumer.msg(66, student);
    }

}