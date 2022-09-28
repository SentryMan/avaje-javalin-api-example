package com.jojo.javalin.api.controller;

import com.jojo.javalin.api.controller.ControllerClass;
import com.jojo.javalin.api.controller.ControllerClass$Route;
import io.avaje.http.api.WebRoutes;
import io.avaje.inject.spi.Builder;
import io.avaje.inject.spi.Generated;

/**
 * Generated source - dependency injection builder for ControllerClass$Route.
 */
@Generated("io.avaje.inject.generator")
public class ControllerClass$Route$DI  {

  /**
   * Create and register ControllerClass$Route.
   */
  public static void build(Builder builder) {
    if (builder.isAddBeanFor(ControllerClass$Route.class, WebRoutes.class)) {
      ControllerClass$Route bean = new ControllerClass$Route(builder.get(ControllerClass.class,"!controller"));
      builder.register(bean);
    }
  }

}
