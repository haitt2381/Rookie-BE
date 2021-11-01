package com.nashtech.rookie.controller;

import com.nashtech.rookie.config.jwt.JwtProvider;
import com.nashtech.rookie.constant.ErrorMessage;
import com.nashtech.rookie.dto.request.LoginForm;
import com.nashtech.rookie.dto.wrapper.AbstractResponse;
import com.nashtech.rookie.dto.wrapper.SuccessResponse;
import com.nashtech.rookie.constant.URole;
import com.nashtech.rookie.exception.TokenRefreshException;
import com.nashtech.rookie.entity.RefreshToken;
import com.nashtech.rookie.entity.Role;
import com.nashtech.rookie.entity.User;
import com.nashtech.rookie.dto.request.RegisterRequest;
import com.nashtech.rookie.dto.request.TokenRefreshRequest;
import com.nashtech.rookie.dto.response.JwtResponse;
import com.nashtech.rookie.dto.response.MessageResponse;
import com.nashtech.rookie.dto.response.TokenRefreshResponse;
import com.nashtech.rookie.repository.RoleRepository;
import com.nashtech.rookie.repository.UserRepository;
import com.nashtech.rookie.service.IRefreshTokenService;
import com.nashtech.rookie.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityExistsException;
import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {

  AuthenticationManager authenticationManager;
  IUserService userService;
  UserRepository userRepository;
  RoleRepository roleRepository;
  PasswordEncoder encoder;
  JwtProvider jwtProvider;
  IRefreshTokenService refreshTokenService;

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

    return new SuccessResponse<>(
        new JwtResponse(
            jwt,
            refreshToken.getToken(),
            userDetails.getId(),
            userDetails.getUsername(),
            userDetails.getEmail(),
            roles));
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
              return new SuccessResponse<>(new TokenRefreshResponse(token, requestRefreshToken));
            })
        .orElseThrow(
            () ->
                new TokenRefreshException(
                    "Failed for " + requestRefreshToken + ":Refresh token is not in database!"));
  }

  @PostMapping("/register")
  public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterRequest registerRequest) {

    userService.registerUser(registerRequest);

    if (userRepository.existsByUsername(registerRequest.getUsername())) {
      return  ResponseEntity.badRequest()
          .body(new MessageResponse(ErrorMessage.ERROR_DUPLICATE_USERNAME.name()));
    }

    if (userRepository.existsByEmail(registerRequest.getEmail())) {
      return ResponseEntity.badRequest()
          .body(new MessageResponse("Error: Email is already in use!"));
    }

    // Create new user's account
    User user =
        new User(
                registerRequest.getUsername(),
                registerRequest.getEmail(),
            encoder.encode(registerRequest.getPassword()));

    Set<String> strRoles = registerRequest.getRole();
    Set<Role> roles = new HashSet<>();

    if (strRoles == null) {
      Role userRole =
          roleRepository
              .findByName(URole.ROLE_USER)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
      roles.add(userRole);
    } else {
      strRoles.forEach(
          role -> {
            switch (role) {
              case "admin":
                Role adminRole =
                    roleRepository
                        .findByName(URole.ROLE_ADMIN)
                        .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                roles.add(adminRole);

                break;
              case "user":
                Role modRole =
                    roleRepository
                        .findByName(URole.ROLE_USER)
                        .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                roles.add(modRole);

                break;
              default:
                Role userRole =
                    roleRepository
                        .findByName(URole.ROLE_CUSTOMER)
                        .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                roles.add(userRole);
            }
          });
    }

    user.setRoles(roles);
    userRepository.save(user);

    return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
  }
}
