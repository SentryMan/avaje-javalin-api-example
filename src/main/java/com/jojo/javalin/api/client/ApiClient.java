package com.jojo.javalin.api.client;

import io.avaje.http.api.Client;
import io.avaje.http.api.Get;
import io.avaje.http.api.Header;
import java.net.http.HttpResponse;

@Client
public interface ApiClient {

  @Get("/wp-content/uploads/2021/08/img08@2x-570x155.png")
  HttpResponse<byte[]> call(@Header("Accept") String accept);
}
