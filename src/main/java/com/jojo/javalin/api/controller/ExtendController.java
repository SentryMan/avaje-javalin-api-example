package com.jojo.javalin.api.controller;

import io.avaje.http.api.Get;
import io.avaje.http.api.MediaType;
import io.avaje.http.api.Path;
import io.avaje.http.api.Produces;

@Path("javalin")
public interface ExtendController {
  /**
   * Standard Get
   *
   * @return a health check
   */
  @Get("/health")
  @Produces(MediaType.TEXT_PLAIN)
  String health();
}
