package com.nashtech.rookie.dto.wrapper;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@Data
@EqualsAndHashCode(callSuper = true)
@JsonPropertyOrder({"status_code", "message", "timestamp","errors"})
public final class SuccessResponse<S> extends AbstractResponse{
    private S data;

    public SuccessResponse(S data, String message){
        super(HttpStatus.OK.value(), message);
        this.data = data;
    }

    public SuccessResponse(String message){
        super(HttpStatus.OK.value(), message);
    }

    public SuccessResponse(int statusCode, S data){
        super(statusCode);
        this.data = data;
    }
}
