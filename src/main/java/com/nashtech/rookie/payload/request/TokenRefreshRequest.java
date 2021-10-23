package com.nashtech.rookie.payload.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class TokenRefreshRequest {

    @NotBlank
    private String refreshToken;

}
