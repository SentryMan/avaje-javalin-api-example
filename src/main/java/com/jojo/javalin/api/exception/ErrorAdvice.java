package com.jojo.javalin.api.exception;

import io.avaje.http.api.Controller;
import io.avaje.http.api.ExceptionHandler;
import io.avaje.http.api.ValidationException;

@Controller
public class ErrorAdvice {

  @ExceptionHandler
  public ErrorResponse handle(ValidationException exception) {

    return new ErrorResponse(ErrorEnum.VALIDATION_FAIL.getId(), exception.getErrors().toString());
  }

  @ExceptionHandler
  void handle(ApplicationException exception) {

    final var errorEnum = exception.getErrorEnum();

    new ErrorResponse(errorEnum.getId(), errorEnum.getText());
  }
}
