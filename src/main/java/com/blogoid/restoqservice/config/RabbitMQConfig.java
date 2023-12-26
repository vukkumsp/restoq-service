package com.blogoid.restoqservice.config;

import org.springframework.context.annotation.Configuration;

import com.blogoid.restoqservice.consumer.QueueConsumer;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
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
import org.springframework.context.annotation.Primary;

@Configuration
public class RabbitMQConfig {
	@Bean
    public Queue hello() {
        return new Queue("q.hello");
    }
	
	@Bean
	@Primary
	public ObjectMapper objectMapper() {
//		ObjectMapper objectMapper = new ObjectMapper();
//	    return objectMapper
//	    			.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
//	    
	    return new ObjectMapper();
	}
	
	@Bean
//	@Primary
	public MessageConverter jsonMessageConverter() {
	    return new Jackson2JsonMessageConverter() {
            @Override
            protected Message createMessage(Object object, MessageProperties messageProperties) {
                // Customize message properties if needed
                return super.createMessage(object, messageProperties);
            }
        };
	}

}
