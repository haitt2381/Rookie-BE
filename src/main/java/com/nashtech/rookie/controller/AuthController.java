package com.nashtech.rookie.controller;

import com.nashtech.rookie.config.jwt.JwtProvider;
import com.nashtech.rookie.constant.SuccessMessage;
import com.nashtech.rookie.dto.request.LoginForm;
import com.nashtech.rookie.dto.wrapper.AbstractResponse;
import com.nashtech.rookie.dto.wrapper.SuccessResponse;
import com.nashtech.rookie.exception.TokenRefreshException;
import com.nashtech.rookie.entity.RefreshToken;
import com.nashtech.rookie.entity.User;
import com.nashtech.rookie.dto.request.RegisterRequest;
import com.nashtech.rookie.dto.request.TokenRefreshRequest;
import com.nashtech.rookie.dto.response.JwtResponse;
import com.nashtech.rookie.dto.response.TokenRefreshResponse;
import com.nashtech.rookie.service.IRefreshTokenService;
import com.nashtech.rookie.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {

  private final PasswordEncoder encoder;
  private final AuthenticationManager authenticationManager;
  private final IUserService userService;
  private final JwtProvider jwtProvider;
  private final IRefreshTokenService refreshTokenService;

  @PostMapping("/login")
  AbstractResponse authenticateUser(@Valid @RequestBody LoginForm loginForm) {
    Authentication authentication =
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                loginForm.getUsername(), loginForm.getPassword()));

    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = jwtProvider.generateJwtToken(authentication);

    User userDetails = (User) authentication.getPrincipal();
    List<String> roles =
        userDetails.getAuthorities().stream()
            .map(item -> item.getAuthority())
            .collect(Collectors.toList());

    RefreshToken refreshToken = refreshTokenService.createRefreshToken(userDetails.getId());

    JwtResponse jwtResponse =
        new JwtResponse(
            jwt,
            refreshToken.getToken(),
            userDetails.getId(),
            userDetails.getUsername(),
            userDetails.getEmail(),
            roles);

    return new SuccessResponse(jwtResponse, SuccessMessage.SUCCESS_LOGIN_USER.name());
  }

  @PostMapping("/refreshToken")
  AbstractResponse refreshToken(@Valid @RequestBody TokenRefreshRequest request) {
    String requestRefreshToken = request.getRefreshToken();
    return refreshTokenService
        .findByToken(requestRefreshToken)
        .map(refreshTokenService::verifyExpiration)
        .map(RefreshToken::getUser)
        .map(
            user -> {
              String token = jwtProvider.generateTokenFromUsername(user.getUsername());
              return new SuccessResponse(
                  new TokenRefreshResponse(token, requestRefreshToken),
                  SuccessMessage.SUCCESS_GET_REFRESH_TOKEN.name());
            })
        .orElseThrow(
            () ->
                new TokenRefreshException(
                    "Failed for " + requestRefreshToken + ":Refresh token is not in database!"));
  }

  @PostMapping("/register")
  AbstractResponse registerUser(@Valid @RequestBody RegisterRequest registerRequest) {
    registerRequest.setPassword(encoder.encode(registerRequest.getPassword()));
    userService.registerUser(registerRequest);
    return new SuccessResponse(SuccessMessage.SUCCESS_REGISTER_USER.name());
  }
}
