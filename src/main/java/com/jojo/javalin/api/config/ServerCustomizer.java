package com.jojo.javalin.api.config;

import io.javalin.Javalin;

@FunctionalInterface
public interface ServerCustomizer {

  void customize(Javalin app);
}
