package com.jojo.javalin.api.exception;

import com.jojo.javalin.api.config.ServerCustomizer;
import com.jojo.javalin.api.exception.ErrorAdvice;
import io.avaje.inject.spi.Builder;
import io.avaje.inject.spi.Generated;

/**
 * Generated source - dependency injection builder for ErrorAdvice.
 */
@Generated("io.avaje.inject.generator")
public class ErrorAdvice$DI  {

  /**
   * Create and register ErrorAdvice.
   */
  public static void build(Builder builder) {
    if (builder.isAddBeanFor(ErrorAdvice.class, ServerCustomizer.class)) {
      ErrorAdvice bean = new ErrorAdvice();
      builder.register(bean);
    }
  }

}
