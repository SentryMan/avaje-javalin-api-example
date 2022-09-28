package com.jojo.javalin.api.exception;

public enum ErrorEnum {

  // TODO add more error scenarios

  INVALID_CHANNEL_TYPE("40001", "Invalid Header", 400),

  INVALID_PATH_VARIABLE("40002", "Invalid variable from path variable", 400),

  INVALID_QUERY_PARAM("40003", "Invalid param from query", 400),

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
