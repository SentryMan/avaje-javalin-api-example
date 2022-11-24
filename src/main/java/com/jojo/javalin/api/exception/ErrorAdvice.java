package com.jojo.javalin.api.exception;

import com.jojo.javalin.api.config.ServerCustomizer;
import io.avaje.http.api.InvalidPathArgumentException;
import io.avaje.http.api.InvalidTypeArgumentException;
import io.avaje.http.api.ValidationException;
import io.javalin.Javalin;
import io.javalin.http.Context;
import jakarta.inject.Singleton;
import java.util.LinkedHashMap;
import java.util.Map;

@Singleton
public class ErrorAdvice implements ServerCustomizer {
  private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ErrorAdvice.class);

  @Override
  public void customize(Javalin app) {

    app.exception(Exception.class, this::handle);
  }

  void handle(Exception exception, Context ctx) {

    switch (exception) {
      case final ValidationException e -> handle(e, ctx);

      case final InvalidPathArgumentException e -> handle(e, ctx);

      case final InvalidTypeArgumentException e -> handle(e, ctx);

      case final ApplicationException e -> handle(e, ctx);

      default -> {
        final var errorEnum = ErrorEnum.INTERNAL_ERROR;

        log.error("Unhandled Exception: {}", exception);

        ctx.json(new ErrorResponse(errorEnum.getId(), errorEnum.getText()));

        ctx.status(errorEnum.getStatus());
      }
    }
  }

  void handle(ApplicationException exception, Context ctx) {

    final var errorEnum = exception.getErrorEnum();

    ctx.json(new ErrorResponse(errorEnum.getId(), errorEnum.getText()));

    ctx.status(errorEnum.getStatus());
  }

  void handle(ValidationException exception, Context ctx) {

    final Map<String, Object> map = new LinkedHashMap<>();
    map.put("message", exception.getMessage());
    map.put("errors", exception.getErrors());
    ctx.json(map);
    ctx.status(exception.getStatus());
  }

  void handle(InvalidPathArgumentException exception, Context ctx) {

    final Map<String, String> map = new LinkedHashMap<>();
    map.put("path", ctx.path());
    map.put("message", "invalid path argument");
    ctx.json(map);
    ctx.status(404);
  }

  void handle(InvalidTypeArgumentException exception, Context ctx) {

    final Map<String, String> map = new LinkedHashMap<>();

    map.put("path", ctx.path());

    map.put("message", "invalid type argument");

    ctx.json(map);

    ctx.status(400);
  }

  public record ResponseModel(String response) {}
}
