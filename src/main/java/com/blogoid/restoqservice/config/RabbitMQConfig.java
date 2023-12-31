package com.blogoid.restoqservice.config;

import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
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
		return new ObjectMapper();
	}
	
	@Bean
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
