package com.jojo.javalin.api.controller;

import java.util.List;

import com.jojo.javalin.api.service.ServiceClass;

import io.avaje.http.api.Controller;
import io.avaje.http.api.Get;
import io.avaje.http.api.Path;
import io.avaje.http.api.Post;
import io.avaje.http.api.Produces;
import io.javalin.http.Context;
import jakarta.inject.Inject;

@Controller
@Path("javalin")
public class ControllerClass {

  private final ServiceClass service;

  @Inject
  public ControllerClass(ServiceClass service) {

    this.service = service;
  }

  @Get("/get")
  @Produces("image/png")
  void test(Context ctx) {
    System.out.println("Is Virtual Thread: " + Thread.currentThread().isVirtual());
    ctx.contentType("image/png").result(service.callDownStream());
  }

  @Get("/health")
  String health() {

    return "healthlmao";
  }

  @Post("/post")
  RequestModel testPost(RequestModel m) {

    return new RequestModel("dfdf");
  }

  @Post("/post2")
  RequestModel testPostl(List<RequestModel> m) {
    System.out.println();
    return new RequestModel("erer");
  }
}
