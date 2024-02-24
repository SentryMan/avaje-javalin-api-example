package com.jojo.javalin.api.config;

import io.avaje.http.api.AvajeJavalinPlugin;
import io.avaje.inject.Bean;
import io.avaje.inject.Factory;
import io.javalin.Javalin;
import java.util.List;

@Factory
public class ServerFactory {
  @Bean
  Javalin server(List<AvajeJavalinPlugin> routes) {

    return Javalin.create(cfg -> routes.forEach(cfg::registerPlugin));
  }
}
