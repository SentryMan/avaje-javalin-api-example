package com.jojo.javalin.api.controller.clientserver;

import io.avaje.http.api.Controller;

@Controller("pathymcpathface")
public class ServerImpl2 implements ClientServer {

  @Override
  public String snake() {
    return "What a thrill";
  }

  @Override
  public String jerma() {
    return "psycho streamer";
  }
}
