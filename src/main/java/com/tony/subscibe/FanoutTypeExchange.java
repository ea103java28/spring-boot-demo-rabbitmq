package com.tony.subscibe;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class FanoutTypeExchange {

    @Value("${exchange.f.name.1}")
    private String exchangeName1;

    @Value("${queue.name.1}")
    private String queueName1;

    @Value("${queue.name.2}")
    private String queueName2;

    @Value("${queue.name.3}")
    private String queueName3;

    @Autowired
    private AmqpTemplate rabbitmqTemplate;

    @Bean
    public Queue queue1() {
        return new Queue(queueName1);
    }

    @Bean
    public Queue queue2() {
        return new Queue(queueName2);
    }

    @Bean
    public Queue queue3() {
        return new Queue(queueName3);
    }

    // fanout type: 當 Producer 把 message 丟給 Exchange 時，Exchange 會把這個 message 丟到他綁定的所有 Queue 上
    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(exchangeName1);
    }


    @Bean
    public Binding binding1(FanoutExchange fanoutExchange, Queue queue1) {
        return BindingBuilder.bind(queue1).to(fanoutExchange);
    }

    @Bean
    public Binding binding2(FanoutExchange fanoutExchange, Queue queue2) {
        return BindingBuilder.bind(queue2).to(fanoutExchange);
    }


    @Bean
    public Binding binding3(FanoutExchange fanoutExchange, Queue queue3) {
        return BindingBuilder.bind(queue3).to(fanoutExchange);
    }


}
