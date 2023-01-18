package com.jojo.javalin.api;

import io.avaje.config.Config;
import io.avaje.http.api.Validator;
import io.avaje.inject.BeanScope;
import io.avaje.inject.InjectModule;
import io.javalin.Javalin;

@InjectModule(requires = Validator.class)
public class JavalinAPI {

  private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(JavalinAPI.class);

  public static void main(String[] args) {

    try {
      BeanScope.builder().build().get(Javalin.class).start(Config.getInt("server.port", 8080));

    } catch (final Exception e) {

      log.error("Failed to start: ", e);
    }
  }
}
