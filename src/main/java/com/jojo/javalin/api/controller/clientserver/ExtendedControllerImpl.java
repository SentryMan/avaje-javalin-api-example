package com.jojo.javalin.api.controller.clientserver;

import io.avaje.http.api.Controller;

@Controller
public class ExtendedControllerImpl implements ExtendController {

  @Override
  public String health() {

    return "healthlmao";
  }
}
