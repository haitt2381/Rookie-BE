package com.nashtech.rookie.controller;

import com.nashtech.rookie.dto.wrapper.ErrorResponse;
import com.nashtech.rookie.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ErrorController {

    public ResponseEntity<ErrorResponse> handleNotFoundException(
        ResourceNotFoundException exception
    ){
        ErrorResponse error = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                exception.getMessage()
        );

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

}
