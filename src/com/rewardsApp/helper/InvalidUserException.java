package com.rewardsApp.helper;

public class InvalidUserException extends RuntimeException{

    InvalidUserException(String msg){
        super(msg);
    }
}
