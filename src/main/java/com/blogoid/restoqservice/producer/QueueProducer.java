package com.blogoid.restoqservice.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.blogoid.restoqservice.model.Blog;
//import com.rabbitmq.client.AMQP.Queue;
import org.springframework.amqp.core.Queue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper; 
import com.fasterxml.jackson.databind.ObjectWriter; 



@Service
public class QueueProducer {
	
	@Autowired
    private RabbitTemplate template;

    @Autowired
    private Queue queue;

	@Scheduled(fixedDelay = 1000, initialDelay = 500)
	public boolean sendToQueue(Blog blog) throws JsonProcessingException {
		System.out.println("Started - sendToQueue");
		ObjectMapper ow = new ObjectMapper();
		template.setMessageConverter(new Jackson2JsonMessageConverter());
		
//				.writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(blog);
		template.convertAndSend(queue.getName(), json);
//		this.template.convertAndSend(queue.getName(), json);
        System.out.println(" [x] Sent '" + json + "'");
        System.out.println("End - sendToQueue");
		return true;
	}


//    @Scheduled(fixedDelay = 1000, initialDelay = 500)
//    public void send() {
//        String message = "Hello World!";
//        this.template.convertAndSend(queue.getName(), message+"");
//        System.out.println(" [x] Sent '" + message + "'");
//    }
}
