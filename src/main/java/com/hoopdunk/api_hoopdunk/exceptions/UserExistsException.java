package com.hoopdunk.api_hoopdunk.exceptions;


public class UserExistsException extends RuntimeException {
    public UserExistsException(String message) {
        super(message);
    }

}
