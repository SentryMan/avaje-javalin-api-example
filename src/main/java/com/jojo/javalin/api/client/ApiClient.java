package com.jojo.javalin.api.client;

import io.avaje.http.api.Client;
import io.avaje.http.api.Get;
import io.avaje.http.api.Header;
import java.io.InputStream;
import java.net.http.HttpResponse;

@Client
public interface ApiClient {

  @Get("/bcVQzeZ.png")
  HttpResponse<InputStream> call(@Header("Accept") String accept);
}
