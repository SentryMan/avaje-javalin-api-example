package com.jojo.javalin.api.controller;

import java.util.List;

import com.jojo.javalin.api.exception.ErrorResponse;
import com.jojo.javalin.api.service.ServiceClass;

import io.avaje.http.api.Controller;
import io.avaje.http.api.Get;
import io.avaje.http.api.MediaType;
import io.avaje.http.api.OpenAPIReturns;
import io.avaje.http.api.Path;
import io.avaje.http.api.Post;
import io.avaje.http.api.Produces;
import io.javalin.http.Context;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;

@OpenAPIDefinition(
    info =
        @Info(
            title = "Example service",
            description = "Example Javalin controllers with Java and Maven"))
@Controller
@Path("javalin")
public class ControllerClass {

  private final ServiceClass service;

  @Inject
  public ControllerClass(ServiceClass service) {

    this.service = service;
  }

  /**
   * bog standard get
   *
   * @param b the body
   * @return from javadoc
   */
  @Get("/get")
  @Produces(MediaType.IMAGE_PNG)
  @OpenAPIResponse(
      responseCode = "200",
      description = "gets something a little sus",
      type = byte[].class)
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
  /**
   * Standard Post
   *
   * @param b the body
   * @return the response body (from javadoc)
   */
  @Deprecated
  @Post("/post")
  @Tag(name = "tag1", description = "it's somethin")
  @OpenAPIResponse(responseCode = "200", description = "from annotaion")
  @OpenAPIResponse(responseCode = "201")
  @OpenAPIResponse(responseCode = "400", description = "User not found")
  @OpenAPIResponse(
      responseCode = "500",
      description = "Some other Error",
      type = ErrorResponse.class)
  RequestModel testPost(RequestModel b) {
    System.out.println("got " + b);
    return new RequestModel("Hmmm, now that I think about it");
  }

  @Post("/post1")
  RequestModel testPostl(List<RequestModel> m) {

    System.out.println("got " + m);
    return new RequestModel("This Model class isn't named that well");
  }

  @Get("/list")
  List<RequestModel> testOpenApiList() {

    return List.of(new RequestModel("it is what it is I guess"));
  }
}
