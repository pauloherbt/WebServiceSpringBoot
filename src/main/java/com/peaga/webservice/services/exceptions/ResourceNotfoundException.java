package com.peaga.webservice.services.exceptions;

public class ResourceNotfoundException extends RuntimeException{
    public ResourceNotfoundException(Object id) {
        super("Resource Not Found by Id:"+ id);
    }

}
