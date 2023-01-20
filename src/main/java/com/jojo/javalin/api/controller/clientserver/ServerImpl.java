package com.jojo.javalin.api.controller.clientserver;

import io.avaje.http.api.Controller;
import io.avaje.http.api.Path;

@Controller
@Path("differentPath")
public class ServerImpl implements ClientServer {

  @Override
  public String snake() {
    return "snake? SNAAAAAKE!!";
  }

  @Override
  public String jerma() {
    return "It's time to peep the horror";
  }
}
