package com.nashtech.rookie.dto.request;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class LoginForm {

    @NotBlank
    private String username;
    @NotBlank
    private String password;
}
