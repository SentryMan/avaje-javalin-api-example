package com.jojo.javalin.api;

import io.avaje.inject.BeanScope;
import io.avaje.inject.InjectModule;
import io.avaje.inject.spi.Builder;
import io.avaje.inject.spi.DependencyMeta;
import io.avaje.inject.spi.Generated;
import io.avaje.inject.spi.Module;
import com.jojo.javalin.api.config.HttpClientFactory$DI;
import com.jojo.javalin.api.config.ServerFactory$DI;
import com.jojo.javalin.api.controller.ControllerClass$DI;
import com.jojo.javalin.api.controller.ControllerClass$Route$DI;
import com.jojo.javalin.api.exception.ErrorAdvice$DI;
import com.jojo.javalin.api.service.ServiceClass$DI;

/**
 * Generated source - avaje inject module for Api.
 * 
 * With Java module system this generated class should be explicitly
 * registered in module-info via a <code>provides</code> clause like:
 * 
 * <pre>{@code
 * 
 *   module example {
 *     requires io.avaje.inject;
 *     
 *     provides io.avaje.inject.spi.Module with com.jojo.javalin.api.ApiModule;
 *     
 *   }
 * 
 * }</pre>
 */
@Generated("io.avaje.inject.generator")
@InjectModule()
public class ApiModule implements Module {

  private final Class<?>[] provides = new Class<?>[]{};
  private final Class<?>[] requires = new Class<?>[]{};
  private final Class<?>[] requiresPackages = new Class<?>[]{};
  private Builder builder;

  @Override
  public Class<?>[] provides() {
    return provides;
  }

  @Override
  public Class<?>[] requires() {
    return requires;
  }

  @Override
  public Class<?>[] requiresPackages() {
    return requiresPackages;
  }

  @Override
  public Class<?>[] classes() {
    return new Class<?>[]{
      com.jojo.javalin.api.config.HttpClientFactory.class,
      com.jojo.javalin.api.config.ServerFactory.class,
      com.jojo.javalin.api.exception.ErrorAdvice.class,
      io.avaje.http.client.HttpClientContext.class,
      com.jojo.javalin.api.service.ServiceClass.class,
      com.jojo.javalin.api.controller.ControllerClass.class,
      com.jojo.javalin.api.controller.ControllerClass$Route.class,
      io.javalin.Javalin.class,
    };
  }

  /**
   * Create the beans.
   * <p>
   * Creates all the beans in order based on constructor dependencies.
   * The beans are registered into the builder along with callbacks for
   * field injection, method injection and lifecycle support.
   */
  @Override
  public void build(Builder builder) {
    this.builder = builder;
    // create beans in order based on constructor dependencies
    // i.e. "provides" followed by "dependsOn"
    build_config_HttpClientFactory();
    build_config_ServerFactory();
    build_exception_ErrorAdvice();
    build_client_HttpClientContext();
    build_service_ServiceClass();
    build_controller_ControllerClass();
    build_controller_ControllerClass$Route();
    build_javalin_Javalin();
  }

  @DependencyMeta(type="com.jojo.javalin.api.config.HttpClientFactory")
  protected void build_config_HttpClientFactory() {
    HttpClientFactory$DI.build(builder);
  }

  @DependencyMeta(type="com.jojo.javalin.api.config.ServerFactory")
  protected void build_config_ServerFactory() {
    ServerFactory$DI.build(builder);
  }

  @DependencyMeta(type="com.jojo.javalin.api.exception.ErrorAdvice", provides={"com.jojo.javalin.api.config.ServerCustomizer"})
  protected void build_exception_ErrorAdvice() {
    ErrorAdvice$DI.build(builder);
  }

  @DependencyMeta(type="io.avaje.http.client.HttpClientContext", method="com.jojo.javalin.api.config.HttpClientFactory$DI.build_client", dependsOn={"com.jojo.javalin.api.config.HttpClientFactory"})
  protected void build_client_HttpClientContext() {
    HttpClientFactory$DI.build_client(builder);
  }

  @DependencyMeta(type="com.jojo.javalin.api.service.ServiceClass", dependsOn={"io.avaje.http.client.HttpClientContext"})
  protected void build_service_ServiceClass() {
    ServiceClass$DI.build(builder);
  }

  @DependencyMeta(type="com.jojo.javalin.api.controller.ControllerClass", dependsOn={"com.jojo.javalin.api.service.ServiceClass"})
  protected void build_controller_ControllerClass() {
    ControllerClass$DI.build(builder);
  }

  @DependencyMeta(type="com.jojo.javalin.api.controller.ControllerClass$Route", provides={"io.avaje.http.api.WebRoutes"}, dependsOn={"com.jojo.javalin.api.controller.ControllerClass"})
  protected void build_controller_ControllerClass$Route() {
    ControllerClass$Route$DI.build(builder);
  }

  @DependencyMeta(type="io.javalin.Javalin", method="com.jojo.javalin.api.config.ServerFactory$DI.build_server", dependsOn={"com.jojo.javalin.api.config.ServerFactory","io.avaje.http.api.WebRoutes","com.jojo.javalin.api.config.ServerCustomizer"})
  protected void build_javalin_Javalin() {
    ServerFactory$DI.build_server(builder);
  }

}
