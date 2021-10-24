package com.nashtech.rookie.payload.request;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class LoginRequest {

    @NotBlank
    private String username;
    @NotBlank
    private String password;
}
