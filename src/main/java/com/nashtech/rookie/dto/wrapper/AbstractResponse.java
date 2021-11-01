package com.nashtech.rookie.dto.wrapper;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public abstract class AbstractResponse {

    @JsonProperty("status_code")
    private int statusCode;

    private String message;

    private final Date timestamp = new Date();

    public AbstractResponse(int statusCode) {
        this.statusCode = statusCode;
    }
}
