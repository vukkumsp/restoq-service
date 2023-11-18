package com.blogoid.restoqservice.config;

import org.springframework.context.annotation.Configuration;

import com.blogoid.restoqservice.consumer.QueueConsumer;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.DefaultJackson2JavaTypeMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
//import com.rabbitmq.client.AMQP.Queue;
import org.springframework.context.annotation.Bean;

@Configuration
public class RabbitMQConfig {
	@Bean
    public Queue hello() {
        return new Queue("q.hello");
    }
	
	@Bean
	public MessageConverter jsonMessageConverter() {
	    return new Jackson2JsonMessageConverter();
	}

}
