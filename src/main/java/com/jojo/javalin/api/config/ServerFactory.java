package com.jojo.javalin.api.config;

import io.avaje.inject.Bean;
import io.avaje.inject.Factory;
import io.javalin.Javalin;
import io.javalin.plugin.Plugin;
import java.util.List;

@Factory
public class ServerFactory {
  @Bean
  Javalin server(List<Plugin> routes) {

    return Javalin.create(cfg -> routes.forEach(cfg.plugins::register));
  }
}
