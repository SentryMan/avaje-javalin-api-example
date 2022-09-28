package com.jojo.javalin.api.config;

import com.jojo.javalin.api.config.ServerCustomizer;
import com.jojo.javalin.api.config.ServerFactory;
import io.avaje.http.api.WebRoutes;
import io.avaje.inject.spi.Builder;
import io.avaje.inject.spi.Generated;
import io.javalin.Javalin;

/**
 * Generated source - dependency injection builder for ServerFactory.
 */
@Generated("io.avaje.inject.generator")
public class ServerFactory$DI  {

  /**
   * Create and register ServerFactory.
   */
  public static void build(Builder builder) {
    if (builder.isAddBeanFor(ServerFactory.class)) {
      ServerFactory bean = new ServerFactory();
      builder.register(bean);
    }
  }

  /**
   * Create and register Javalin via factory bean method ServerFactory#server().
   */
  public static void build_server(Builder builder) {
    if (builder.isAddBeanFor(Javalin.class)) {
      ServerFactory factory = builder.get(ServerFactory.class);
      Javalin bean = factory.server(builder.list(WebRoutes.class), builder.list(ServerCustomizer.class));
      Javalin $bean = builder.register(bean);
      builder.addPreDestroy($bean::close);
    }
  }

}
