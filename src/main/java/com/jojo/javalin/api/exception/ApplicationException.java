package com.jojo.javalin.api.exception;

public class ApplicationException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  private final ErrorEnum errorEnum;

  public ApplicationException(ErrorEnum errorEnum, Throwable throwable) {

    super(errorEnum.getText(), throwable);

    this.errorEnum = errorEnum;
  }

  public ErrorEnum getErrorEnum() {

    return errorEnum;
  }
}
