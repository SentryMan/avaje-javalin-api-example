package com.jojo.javalin.api.client.httpclient;


import com.jojo.javalin.api.client.ApiClient;
import io.avaje.http.api.*;
import io.avaje.http.client.HttpApiProvider;
import io.avaje.http.client.HttpClientContext;
import java.net.http.HttpResponse;

@Generated("avaje-http-client-generator")
public class ApiClientHttpClient implements ApiClient {

  private final HttpClientContext clientContext;

  public ApiClientHttpClient(HttpClientContext ctx) {
    this.clientContext = ctx;
  }

  // GET /wp-content/uploads/2021/08/img08@2x-570x155.png
  @Override
  public HttpResponse<byte[]> call(String accept) {
    return clientContext.request()
      .header("Accept", accept)
      .path("wp-content").path("uploads").path("2021").path("08").path("img08@2x-570x155.png")
      .GET()
      .asByteArray();
  }

  public static class Provider implements HttpApiProvider<ApiClient> {
    @Override
    public Class<ApiClient> type() {
      return ApiClient.class;
    }
    @Override
    public ApiClient provide(HttpClientContext client) {
      return new ApiClientHttpClient(client);
    }
  }
}
