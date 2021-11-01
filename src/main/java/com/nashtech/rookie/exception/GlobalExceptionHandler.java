package com.nashtech.rookie.exception;

import com.nashtech.rookie.dto.wrapper.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.ServletException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = TokenRefreshException.class)
    public ResponseEntity<ErrorResponse> handleTokenRefreshException(
            TokenRefreshException exception) {

        ErrorResponse response = new ErrorResponse();
        response.setStatusCode(HttpStatus.FORBIDDEN.value());
        response.setMessage(exception.getMessage());

        return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
    }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorResponse> handleException(Exception exception) {
        ErrorResponse response = new ErrorResponse();

        response.setStatusCode(HttpStatus.BAD_REQUEST.value());
        response.setMessage(exception.getMessage());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationExceptions(
            MethodArgumentNotValidException exception) {
        Map<String, String> errors = new HashMap<>();
        exception
                .getBindingResult()
                .getAllErrors()
                .forEach(
                        (error) -> {
                            String fieldName = ((FieldError) error).getField();
                            String errorMessage = error.getDefaultMessage();
                            errors.put(fieldName, errorMessage);
                        });

        ErrorResponse response = new ErrorResponse();
        response.setStatusCode(HttpStatus.BAD_REQUEST.value());
        response.setMessage("Something were wrong with your query, please check errors and try again.");
        response.setErrors(errors);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ErrorResponse> handleUnauthorizedException(
            AccessDeniedException exception) {
        ErrorResponse response = new ErrorResponse();

        Collection<? extends GrantedAuthority> authorities =
                SecurityContextHolder.getContext().getAuthentication().getAuthorities();

        if (authorities.contains(new SimpleGrantedAuthority("ROLE_ANONYMOUS"))) {
            response.setStatusCode(HttpStatus.UNAUTHORIZED.value());
            response.setMessage("Unauthorized");
            return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
        } else {
            response.setStatusCode(HttpStatus.FORBIDDEN.value());
            response.setMessage(exception.getMessage());
            return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
        }
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundException(
            ResourceNotFoundException exception) {
        ErrorResponse response = new ErrorResponse();

        response.setStatusCode(HttpStatus.NOT_FOUND.value());
        response.setMessage(
                ObjectUtils.isEmpty(exception.getMessage())
                        ? "Resource not found"
                        : exception.getMessage());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ServletException.class)
    public ResponseEntity<ErrorResponse> handleServerException(ServletException exception) {
        ErrorResponse response = new ErrorResponse();

        response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.setMessage(exception.getMessage());

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
