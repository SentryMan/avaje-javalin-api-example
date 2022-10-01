package com.jojo.javalin.api.controller;

import com.jojo.javalin.api.service.ServiceClass;

import io.avaje.http.api.Controller;
import io.avaje.http.api.Get;
import io.avaje.http.api.Path;
import io.avaje.http.api.Produces;
import io.javalin.http.Context;
import jakarta.inject.Inject;

@Controller
@Path("/javalin")
public class ControllerClass {

  private final ServiceClass service;

  @Inject
  public ControllerClass(ServiceClass service) {

    this.service = service;
  }

  @Produces("image/png")
  @Get("/get")
  void test(Context ctx) {
    ctx.result(service.callDownStream());
  }

  @Get("/health")
  String health() {

    return "healthlmao";
  }
}
