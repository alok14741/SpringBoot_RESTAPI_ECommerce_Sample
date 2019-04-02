package com.ecommerce.api.exceptions;

@SuppressWarnings("serial")
public class ItemNotFoundException extends RuntimeException {
	
	public ItemNotFoundException(String exception) {
	    super(exception);
	  }
}
