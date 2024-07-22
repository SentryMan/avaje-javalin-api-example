package com.jojo.javalin.api.service;

import com.jojo.javalin.api.aspect.Timed;
import com.jojo.javalin.api.client.ApiClient;
import com.jojo.javalin.api.exception.ApplicationException;
import com.jojo.javalin.api.exception.ErrorEnum;
import io.avaje.http.client.HttpException;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.io.InputStream;
import java.util.Optional;

@Singleton
public class ServiceClass {

  private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ServiceClass.class);

  private final ApiClient api;

  @Inject
  public ServiceClass(ApiClient api) {
    this.api = api;
  }

  @Timed
  public InputStream callDownStream() {
    try {

      return api.call().body();
    } catch (final HttpException e) {
      final var body = Optional.ofNullable(e.bodyAsString()).orElseGet(e::toString);
      log.info("Failed call because: " + body);
      throw new ApplicationException(ErrorEnum.INTERNAL_ERROR, e);
    }
  }
}
