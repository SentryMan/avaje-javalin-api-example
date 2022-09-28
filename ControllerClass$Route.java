package com.jojo.javalin.api.controller;

import static io.avaje.http.api.PathTypeConversion.*;

import com.jojo.javalin.api.controller.ControllerClass;
import com.jojo.javalin.api.exception.ErrorAdvice.RequestModel;
import io.avaje.http.api.*;
import io.avaje.inject.Component;
import io.javalin.apibuilder.ApiBuilder;

@Generated("avaje-javalin-generator")
@Component
public class ControllerClass$Route implements WebRoutes {

  private final ControllerClass controller;

  public ControllerClass$Route(ControllerClass controller) {
    this.controller = controller;
  }

  @Override
  public void registerRoutes() {

    ApiBuilder.get("/javalin/get", ctx -> {
      ctx.status(200);
      ctx.contentType("image/png").result(controller.test());
    });

    ApiBuilder.get("/javalin/get2", ctx -> {
      ctx.status(200);
      ctx.json(controller.testList());
    });

    ApiBuilder.get("/javalin/get2", ctx -> {
      ctx.status(200);
      ctx.json(controller.testarr());
    });

    ApiBuilder.post("/javalin/post", ctx -> {
      ctx.status(201);
      RequestModel model = ctx.bodyAsClass(RequestModel.class);
      ctx.json(controller.testPost(model));
    });

    ApiBuilder.get("/javalin/health", ctx -> {
      ctx.status(200);
      ctx.json(controller.health());
    });

  }

}
