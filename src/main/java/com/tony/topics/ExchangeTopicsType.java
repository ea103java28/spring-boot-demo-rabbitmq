package com.tony.topics;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ExchangeTopicsType {

    @Value("${exchange.t.name.1}")
    private String topicsExchangeName;

    @Value("${queue.name.7}")
    private String queueName7;

    @Value("${queue.name.8}")
    private String queueName8;

    @Value("${queue.name.9}")
    private String queueName9;

    @Value("${queue.name.88}")
    private String queueName88;

    @Autowired
    private AmqpTemplate rabbitmqTemplate;

    @Bean
    public Queue queue7() {
        return new Queue(queueName7);
    }

    @Bean
    public Queue queue8() {
        return new Queue(queueName8);
    }

    @Bean
    public Queue queue9() {
        return new Queue(queueName9);
    }

    @Bean
    public Queue queue88() {
        return new Queue(queueName88);
    }

    @Bean
    public TopicExchange topicsExchange() {
        return new TopicExchange(topicsExchangeName);
    }

    @Bean
    public Binding binding7(TopicExchange topicsExchange, Queue queue7) {
        return BindingBuilder.bind(queue7).to(topicsExchange).with("*.John.*");
    }

    @Bean
    public Binding binding8(TopicExchange topicsExchange, Queue queue8) {
        return BindingBuilder.bind(queue8).to(topicsExchange).with("*.Amy.*");
    }

    @Bean
    public Binding binding9(TopicExchange topicsExchange, Queue queue9) {
        return BindingBuilder.bind(queue9).to(topicsExchange).with("*.Bob.*");
    }

    @Bean
    public Binding binding88Amy(TopicExchange topicsExchange, Queue queue88) {
        return BindingBuilder.bind(queue88).to(topicsExchange).with("#.Amy.#");
    }

    @Bean
    public Binding binding88John(TopicExchange topicsExchange, Queue queue88) {
        return BindingBuilder.bind(queue88).to(topicsExchange).with("#.John.#");
    }

    @Bean
    public Binding binding88Bob(TopicExchange topicsExchange, Queue queue88) {
        return BindingBuilder.bind(queue88).to(topicsExchange).with("#.Bob.#");
    }


}
/*
        在 RabbitMQ 中，* 和 # 是用於定義主題類型交換機的通配符。這兩個符號的使用方式有一些區別：

        *（星號）：單詞通配符

        用於主題中的單詞通配符。
        可以代表一個單詞。
        例如，路由鍵 topic.*.example 可以匹配 topic.first.example，但不匹配 topic.first.second.example。
        #（井號）：多詞通配符

        用於主題中的多詞通配符。
        可以代表零個或多個單詞。
        例如，路由鍵 topic.# 可以匹配 topic.first.example，topic.first.second.example，甚至是 topic。
        總的來說，* 是單詞級別的通配符，而 # 是多詞（或零詞）級別的通配符。這使得 * 主要用於匹配單個單詞，
        而 # 用於匹配多個單詞或更廣泛的模式。在使用主題類型的交換機時，你可以根據需要結合使用這兩個符號，以構建靈活且強大的路由機制。
 */