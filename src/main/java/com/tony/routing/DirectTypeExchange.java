package com.tony.routing;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DirectTypeExchange {

    @Value("${exchange.d.name.1}")
    private String exchangeName;

    @Value("${queue.name.4}")
    private String queueName4;

    @Value("${queue.name.5}")
    private String queueName5;

    @Value("${queue.name.6}")
    private String queueName6;

    @Value("${queue.name.66}")
    private String queueName66;

    @Autowired
    private AmqpTemplate rabbitmqTemplate;

    @Bean
    public Queue queue4() {
        return new Queue(queueName4);
    }

    @Bean
    public Queue queue5() {
        return new Queue(queueName5);
    }


    @Bean
    public Queue queue6() {
        return new Queue(queueName6);
    }

    @Bean
    public Queue queue66() {
        return new Queue(queueName66);
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(exchangeName);
    }

    @Bean
    public Binding binding4(DirectExchange directExchange, Queue queue4) {
        return BindingBuilder.bind(queue4).to(directExchange).with("John");
    }

    @Bean
    public Binding binding5(DirectExchange directExchange, Queue queue5) {
        return BindingBuilder.bind(queue5).to(directExchange).with("Amy");
    }

    @Bean
    public Binding binding6(DirectExchange directExchange, Queue queue6) {
        return BindingBuilder.bind(queue6).to(directExchange).with("Bob");
    }

    @Bean
    public Binding binding66Amy(DirectExchange directExchange, Queue queue66) {
        return BindingBuilder.bind(queue66).to(directExchange).with("Amy");
    }

    @Bean
    public Binding binding66John(DirectExchange directExchange, Queue queue66) {
        return BindingBuilder.bind(queue66).to(directExchange).with("John");
    }

    @Bean
    public Binding binding66Bob(DirectExchange directExchange, Queue queue66) {
        return BindingBuilder.bind(queue66).to(directExchange).with("Bob");
    }


}
