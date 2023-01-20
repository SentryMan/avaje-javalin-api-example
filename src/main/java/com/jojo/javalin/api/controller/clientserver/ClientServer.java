package com.jojo.javalin.api.controller.clientserver;

import io.avaje.http.api.Client;
import io.avaje.http.api.Get;
import io.avaje.http.api.MediaType;
import io.avaje.http.api.Path;
import io.avaje.http.api.Produces;

// double as a client interface
// if in another maven module we'd use @Client.Import
// implementing controllers can define own path annotation to override
@Client
@Path("somePath")
public interface ClientServer {

  /**
   * Standard Get
   *
   * @return a classic reference
   */
  @Get("/snake")
  @Produces(MediaType.TEXT_PLAIN)
  String snake();

  /**
   * Standard Get 2: Electric Boogaloo
   *
   * @return a classic reference
   */
  @Get("/jerma")
  @Produces(MediaType.TEXT_PLAIN)
  String jerma();
}
