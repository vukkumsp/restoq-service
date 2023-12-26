package com.blogoid.restoqservice.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter 
//@NoArgsConstructor //this causes lombok @ToString to not work.
@ToString
public class Blog implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5419278769466178796L;
	
	@JsonProperty("id")
	private Long id;
	@JsonProperty("heading")
	private String heading;
	@JsonProperty("content")
	private String content;
	
	public Blog() {}
	
	public Blog(Long id, String heading, String content) {
		this.id = id;
		this.heading = heading;
		this.content = content;
	}
}
