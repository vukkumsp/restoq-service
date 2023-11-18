package com.blogoid.restoqservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.blogoid.restoqservice.model.Blog;
import com.blogoid.restoqservice.producer.QueueProducer;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class MainAPI {
	
	@Autowired
	QueueProducer producer;
	
	@PostMapping("/saveblog")
	boolean saveBlog(@RequestBody Blog blog) throws JsonProcessingException {
		return producer.sendToQueue(blog);
	}
	
}
