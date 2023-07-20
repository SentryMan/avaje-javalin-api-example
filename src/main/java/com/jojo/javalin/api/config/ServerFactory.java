package com.jojo.javalin.api.config;

import io.avaje.http.api.WebRoutes;
import io.avaje.inject.Bean;
import io.avaje.inject.Factory;
import io.javalin.Javalin;
import java.util.List;

@Factory
public class ServerFactory {
  @Bean
  Javalin server(List<WebRoutes> routes) {

    final var app = Javalin.create();
    app.routes(() -> routes.forEach(WebRoutes::registerRoutes));

    return app;
  }
}
