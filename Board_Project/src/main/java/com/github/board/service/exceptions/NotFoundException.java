package com.github.board.service.exceptions;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String m){
        super(m);
    }
}
