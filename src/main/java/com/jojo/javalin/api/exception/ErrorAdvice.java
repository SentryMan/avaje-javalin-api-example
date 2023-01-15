package com.jojo.javalin.api.exception;

import com.jojo.javalin.api.config.ServerCustomizer;

import io.avaje.jsonb.JsonType;
import io.avaje.jsonb.Jsonb;
import io.javalin.Javalin;
import io.javalin.http.Context;
import jakarta.inject.Singleton;

@Singleton
public class ErrorAdvice implements ServerCustomizer {
  private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ErrorAdvice.class);
  private final JsonType<ErrorResponse> errorType;

  ErrorAdvice(Jsonb jsonb) {
    this.errorType = jsonb.type(ErrorResponse.class);
  }

  @Override
  public void customize(Javalin app) {

    app.exception(Exception.class, this::handle);
  }

  void handle(Exception exception, Context ctx) {

    switch (exception) {
      case final ApplicationException e -> handle(e, ctx);

      default -> {
        final var errorEnum = ErrorEnum.INTERNAL_ERROR;
        log.error("Unhandled Exception: {}", exception);
        final var servletResponseStream = ctx.status(errorEnum.getStatus()).outputStream();
        errorType.toJson(
            new ErrorResponse(errorEnum.getId(), errorEnum.getText()), servletResponseStream);
      }
    }
  }

  void handle(ApplicationException exception, Context ctx) {

    final var errorEnum = exception.getErrorEnum();

    final var servletResponseStream = ctx.status(errorEnum.getStatus()).outputStream();
    errorType.toJson(
        new ErrorResponse(errorEnum.getId(), errorEnum.getText()), servletResponseStream);
  }
}
