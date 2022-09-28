package com.jojo.javalin.api.config;

import com.jojo.javalin.api.config.HttpClientFactory;
import io.avaje.http.client.HttpClientContext;
import io.avaje.inject.spi.Builder;
import io.avaje.inject.spi.Generated;

/**
 * Generated source - dependency injection builder for HttpClientFactory.
 */
@Generated("io.avaje.inject.generator")
public class HttpClientFactory$DI  {

  /**
   * Create and register HttpClientFactory.
   */
  public static void build(Builder builder) {
    if (builder.isAddBeanFor(HttpClientFactory.class)) {
      HttpClientFactory bean = new HttpClientFactory();
      builder.register(bean);
    }
  }

  /**
   * Create and register HttpClientContext via factory bean method HttpClientFactory#client().
   */
  public static void build_client(Builder builder) {
    if (builder.isAddBeanFor(HttpClientContext.class)) {
      HttpClientFactory factory = builder.get(HttpClientFactory.class);
      HttpClientContext bean = factory.client();
      builder.register(bean);
    }
  }

}
