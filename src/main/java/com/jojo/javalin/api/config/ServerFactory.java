package com.jojo.javalin.api.config;

import io.avaje.http.api.WebRoutes;
import io.avaje.inject.Bean;
import io.avaje.inject.Factory;
import io.avaje.jsonb.Jsonb;
import io.javalin.Javalin;
import java.util.List;

@Factory
public class ServerFactory {

  @Bean
  Javalin server(List<WebRoutes> routes, List<ServerCustomizer> customizers) {

    final var app = Javalin.create();
    app.routes(() -> routes.forEach(WebRoutes::registerRoutes));
    customizers.forEach(c -> c.customize(app));

    return app;
  }

  @Bean
  Jsonb jsonB() {
    return Jsonb.builder().failOnUnknown(false).build();
  }
}
