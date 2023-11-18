package com.blogoid.restoqservice.producer;

import org.springframework.stereotype.Service;

import com.blogoid.restoqservice.model.Blog;

@Service
public class QueueProducer {

	public boolean sendToQueue(Blog blog) {
		System.out.println(blog);
		return true;
	}
}
