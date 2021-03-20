package com.jbcode.restapibnb.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The type Resource not found exception.
 */
@ResponseStatus(value = HttpStatus.FOUND)
public class ResourceNotFoundException extends RuntimeException {
    private static final long serialVersionUID =1L;

    /**
     * Instantiates a new Resource not found exception.
     *
     * @param message the message
     */
    public ResourceNotFoundException(String message){
        super(message);
    }

}
