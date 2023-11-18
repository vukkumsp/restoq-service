package com.blogoid.restoqservice.model;

import java.io.Serializable;

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
	
	private Long id;
	private String heading;
	private String content;
	
	public Blog(Long id, String heading, String content) {
		this.id = id;
		this.heading = heading;
		this.content = content;
	}
	
//	public String toString() {
//		return "Blog (id: "+id+" heading: "+heading+" content: "+content+")";
//	}
}
