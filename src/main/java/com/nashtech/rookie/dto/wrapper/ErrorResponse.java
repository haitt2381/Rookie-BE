package com.nashtech.rookie.dto.wrapper;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Map;

public final class ErrorResponse extends AbstractResponse{

    @JsonProperty("errors")
    Map<String, String> errors;

    public ErrorResponse(int errorCode, String message) {
        setStatusCode(errorCode);
        setMessage(message);
    }

    public ErrorResponse(
            int responseCode,
            String message,
            Map<String, String> errors
    ) {
        setStatusCode(responseCode);
        setMessage(message);
        this.errors = errors;
    }
}
