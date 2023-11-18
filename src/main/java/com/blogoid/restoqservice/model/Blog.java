package com.blogoid.restoqservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter 
@NoArgsConstructor
//@ToString(includeFieldNames = false)
public class Blog {
	private Long id;
	private String heading;
	private String content;
	
	public Blog(Long id, String heading, String content) {
		this.id = id;
		this.heading = heading;
		this.content = content;
	}
	
	public String toString() {
		return "Blog (id: "+id+" heading: "+heading+" content: "+content+")";
	}
}
