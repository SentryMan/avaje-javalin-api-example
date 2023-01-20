package com.jojo.javalin.api.controller.clientserver;

import io.avaje.http.api.Get;
import io.avaje.http.api.MediaType;
import io.avaje.http.api.Path;
import io.avaje.http.api.Produces;

// path is inherited by all implementing classes
@Path("javalin")
public interface ExtendController {

  /**
   * Standard Health Check
   *
   * @return a health check
   */
  @Get("/health")
  @Produces(MediaType.TEXT_PLAIN)
  String health();
}
