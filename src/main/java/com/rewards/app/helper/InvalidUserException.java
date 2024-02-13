package com.rewards.app.helper;

public class InvalidUserException extends RuntimeException{

    InvalidUserException(String msg){
        super(msg);
    }
}
