package com.nashtech.rookie.dto.wrapper;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@JsonPropertyOrder({"status_code", "message", "timestamp","errors"})
public final class SuccessResponse<S> extends AbstractResponse{
    private S data;

    public SuccessResponse(int statusCode, String message, S data) {
        super(statusCode, message);
        this.data = data;
    }
}
