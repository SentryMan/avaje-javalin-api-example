package com.jojo.javalin.api.client;

import io.avaje.http.api.Client;
import io.avaje.http.api.Get;
import io.avaje.http.api.Header;
import java.net.http.HttpResponse;

@Client
public interface ApiClient {

  @Get("/bcVQzeZ.png")
  HttpResponse<byte[]> call(@Header("Accept") String accept);
}
