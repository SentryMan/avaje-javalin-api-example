package com.jojo.javalin.api.controller;

import com.jojo.javalin.api.exception.ErrorResponse;
import com.jojo.javalin.api.models.RequestModel;
import com.jojo.javalin.api.models.ResponseModel;
import com.jojo.javalin.api.service.ServiceClass;
import io.avaje.http.api.Controller;
import io.avaje.http.api.Get;
import io.avaje.http.api.MediaType;
import io.avaje.http.api.OpenAPIResponse;
import io.avaje.http.api.Post;
import io.avaje.http.api.Produces;
import io.avaje.http.api.Valid;
import io.javalin.http.Context;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;
import java.io.InputStream;
import java.util.List;

@Valid
@OpenAPIDefinition(
    info =
        @Info(
            title = "Example service",
            description = "Example Javalin controllers with Java and Maven"))
@Controller("javalin")
public class BasicController {

  private final ServiceClass service;

  @Inject
  public BasicController(ServiceClass service) {

    this.service = service;
  }

  /**
   * bog standard get (This Javadoc is used to generate the OpenAPI)
   *
   * @return gets something a little sus
   */
  @Get("/get")
  @Produces(MediaType.IMAGE_PNG)
  @OpenAPIResponse(responseCode = 200, type = byte[].class)
  InputStream ctxEndpoint(Context ctx) {
    return service.callDownStream();
  }

  /**
   * Standard Post
   *
   * @param b the body
   * @return the response body
   */
  @Post("/post")
  @Tag(name = "tag1", description = "it's somethin")
  @OpenAPIResponse(responseCode = 422, description = "Failed Validation")
  @OpenAPIResponse(responseCode = 500, description = "Some other Error", type = ErrorResponse.class)
  ResponseModel testPost(RequestModel b) {
    return new ResponseModel("got " + b);
  }

  @Post("/post1")
  ResponseModel testPostl(List<RequestModel> m) {

    System.out.println("got " + m);
    return new ResponseModel("Got List of stuff");
  }

  @Get("/list")
  List<ResponseModel> testOpenApiList() {

    return List.of(new ResponseModel("Can you really call this a list with only a single element"));
  }

  /**
   * Standard Health Check
   *
   * @return a health check
   */
  @Get("/health")
  @Produces(MediaType.TEXT_PLAIN)
  public String health() {
    return "healthlmao";
  }
}
