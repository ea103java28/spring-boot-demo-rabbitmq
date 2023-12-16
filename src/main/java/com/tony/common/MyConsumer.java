package com.tony.common;

import com.tony.Student;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MyConsumer {

    StringBuilder sb = new StringBuilder();

    public void msg(int consumerNumber, Student student){
        sb.setLength(0);
        sb.append("Consumer ").append(consumerNumber).append(" received message:\t").append(student);
        System.out.println(sb.toString());
    }
}
