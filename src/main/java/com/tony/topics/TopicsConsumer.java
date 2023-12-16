package com.tony.topics;

import com.tony.Student;
import com.tony.common.MyConsumer;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicsConsumer {

   @Autowired
    private MyConsumer myConsumer;

    @RabbitListener(queues = "${queue.name.7}")
    public void consumer7(Student student) {
        myConsumer.msg(7, student);
    }

    @RabbitListener(queues = "${queue.name.8}")
    public void consumer8(Student student) {
        myConsumer.msg(8, student);
    }

    @RabbitListener(queues = "${queue.name.9}")
    public void consumer9(Student student) {
        myConsumer.msg(9, student);
    }

    @RabbitListener(queues = "${queue.name.88}")
    public void consumer10(Student student) {
        myConsumer.msg(88, student);
    }

}
