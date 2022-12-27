package com.jojo.javalin.api.controller;

import com.jojo.javalin.api.service.ServiceClass;
import io.avaje.http.api.Controller;
import io.avaje.http.api.Get;
import io.avaje.http.api.MediaType;
import io.avaje.http.api.Path;
import io.avaje.http.api.Post;
import io.avaje.http.api.Produces;
import io.javalin.http.Context;
import jakarta.inject.Inject;
import java.util.List;

@Controller
@Path("javalin")
public class ControllerClass {

  private final ServiceClass service;

  @Inject
  public ControllerClass(ServiceClass service) {

    this.service = service;
  }

  @Get("/get")
  // use regular Javalin Context
  void ctxEndpoint(Context ctx) {
    System.out.println("Is Virtual Thread: " + Thread.currentThread().isVirtual());
    ctx.contentType("image/png").result(service.callDownStream());
  }

  @Get("/health")
  // use produces to send only text
  @Produces(MediaType.TEXT_PLAIN)
  String health() {

    return "healthlmao";
  }

  @Post("/post")
  RequestModel testPost(RequestModel m) {
    System.out.println("got " + m);
    return new RequestModel("Hmmm, now that I think about it");
  }

  @Post("/post1")
  RequestModel testPostl(List<RequestModel> m) {

    System.out.println("got " + m);
    return new RequestModel("This Model class isn't named that well");
  }
}
