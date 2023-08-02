package com.peaga.webservice.resources.exceptions;

import com.peaga.webservice.services.exceptions.DbException;
import com.peaga.webservice.services.exceptions.ResourceNotfoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice //intercepta as exceptions
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotfoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotfoundException e, HttpServletRequest req){
        String error = "Resource Not Found";
        HttpStatusCode status = HttpStatus.NOT_FOUND;
        StandardError standardError = new StandardError(Instant.now(), status.value(),error,e.getMessage(),req.getRequestURI());
        return ResponseEntity.status(status).body(standardError);
    }
    @ExceptionHandler(DbException.class)
    public ResponseEntity<StandardError> dbException(DbException e, HttpServletRequest req){
        String error = "DB Integrity Violated!";
        HttpStatusCode status = HttpStatus.BAD_REQUEST;
        StandardError standardError = new StandardError(Instant.now(), status.value(),error,e.getMessage(),req.getRequestURI());
        return ResponseEntity.status(status).body(standardError);
    }
}
