package com.jojo.javalin.api.exception;

public enum ErrorEnum {

  // TODO add more error scenarios

  VALIDATION_FAIL("40001", "Invalid Body", 422),

  ERROR_4XX("40005", "4xx from backend", 400),

  INTERNAL_ERROR("50001", "Internal Server Error", 500);

  String id;

  String text;

  int httpStatus;

  ErrorEnum(String id, String text, int httpStatus) {

    this.id = id;

    this.text = text;

    this.httpStatus = httpStatus;
  }

  public String getId() {

    return id;
  }

  public String getText() {

    return text;
  }

  public int getStatus() {

    return httpStatus;
  }
}
