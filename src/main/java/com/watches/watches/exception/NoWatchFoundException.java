package com.watches.watches.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoWatchFoundException extends Exception{

    public NoWatchFoundException(String msg){
        super(msg);
    }

}
