package com.nashtech.rookie.jwt.advice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@AllArgsConstructor
@Getter
@Setter

public class ErrorMessage {
    private int statusCode;
    private Date timestamp;
    private String message;
    private String description;

}
