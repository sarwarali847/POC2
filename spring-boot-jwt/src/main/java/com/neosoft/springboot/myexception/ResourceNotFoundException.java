package com.neosoft.springboot.myexception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;

//custom exception class
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

	
	private static final long serialVersionUID = 1L;
	
	private @Getter String resourceName;
	private @Getter String fieldName;
	private @Getter Object fieldValue;
	
	
	public ResourceNotFoundException(String resourceName, String fieldName, Object postId) {
		super(resourceName+" Not Found With "+fieldName+" : "+postId);
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = postId;
	}
	
	
	
	
	
	
	
}
