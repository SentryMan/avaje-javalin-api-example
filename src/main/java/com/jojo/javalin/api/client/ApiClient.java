package com.jojo.javalin.api.client;

import java.io.InputStream;
import java.net.http.HttpResponse;

import io.avaje.http.api.Client;
import io.avaje.http.api.Get;
import io.avaje.http.api.Headers;

@Client
public interface ApiClient {

  @Get("/images?q=tbn:ANd9GcTGdTHmcbadka3hCrTy52J0z7Jur5maarnmjZMa0XYnnJjtBBMj")
  @Headers("Accept: image/jpeg")
  HttpResponse<InputStream> call();
}
