package com.jojo.javalin.api.controller;

import com.jojo.javalin.api.controller.ControllerClass;
import com.jojo.javalin.api.service.ServiceClass;
import io.avaje.http.api.Controller;
import io.avaje.inject.spi.Builder;
import io.avaje.inject.spi.Generated;

/**
 * Generated source - dependency injection builder for ControllerClass.
 */
@Generated("io.avaje.inject.generator")
public class ControllerClass$DI  {

  /**
   * Create and register ControllerClass.
   */
  public static void build(Builder builder) {
    if (builder.isAddBeanFor(ControllerClass.class, Controller.class)) {
      ControllerClass bean = new ControllerClass(builder.get(ServiceClass.class,"!service"));
      builder.register(bean);
    }
  }

}
