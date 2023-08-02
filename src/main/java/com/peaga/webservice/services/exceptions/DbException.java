package com.peaga.webservice.services.exceptions;

public class DbException extends RuntimeException{
    public DbException(String msg) {
        super(msg);
    }
}
