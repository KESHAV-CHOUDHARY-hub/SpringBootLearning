package com.practice.hackathon.exception;

import com.practice.hackathon.entity.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(PlansNotAddedException.class)
  public ResponseEntity<ErrorMessage> planNotAddedException(
      PlansNotAddedException exception, WebRequest request) {
    ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
  }

  @ExceptionHandler(MobileNumbersNotAddedException.class)
  public ResponseEntity<ErrorMessage> MobileNUmberNotAddedException(
      MobileNumbersNotAddedException exception, WebRequest request) {
    ErrorMessage errorMessage  = new ErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
  }
}
