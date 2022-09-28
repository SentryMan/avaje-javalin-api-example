package com.jojo.javalin.api.service;

import com.jojo.javalin.api.service.ServiceClass;
import io.avaje.http.client.HttpClientContext;
import io.avaje.inject.spi.Builder;
import io.avaje.inject.spi.Generated;

/**
 * Generated source - dependency injection builder for ServiceClass.
 */
@Generated("io.avaje.inject.generator")
public class ServiceClass$DI  {

  /**
   * Create and register ServiceClass.
   */
  public static void build(Builder builder) {
    if (builder.isAddBeanFor(ServiceClass.class)) {
      ServiceClass bean = new ServiceClass(builder.get(HttpClientContext.class,"!ctx"));
      builder.register(bean);
    }
  }

}
