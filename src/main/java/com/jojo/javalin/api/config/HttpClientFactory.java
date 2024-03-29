package com.jojo.javalin.api.config;

import com.jojo.javalin.api.client.ApiClient;
import com.jojo.javalin.api.client.HTTPListeners;
import com.jojo.javalin.api.client.Retry;
import io.avaje.config.Config;
import io.avaje.http.client.HttpClient;
import io.avaje.http.client.HttpClient.Builder;
import io.avaje.http.client.JsonbBodyAdapter;
import io.avaje.inject.Bean;
import io.avaje.inject.Factory;
import io.avaje.jsonb.Jsonb;
import java.net.http.HttpClient.Version;
import java.time.Duration;
import java.util.concurrent.Executors;

@Factory
public class HttpClientFactory {

  @Bean
  Builder builder(
      // AuthProvider provider,
      Jsonb jsonb) {

    return HttpClient.builder()
        .executor(Executors.newVirtualThreadPerTaskExecutor())
        .bodyAdapter(new JsonbBodyAdapter(jsonb))
        //     .authTokenProvider(provider)
        .requestTimeout(Duration.ofMillis(Config.getLong("timeout", 5000)))
        .retryHandler(new Retry())
        .version(Version.HTTP_1_1)
        // disable native requestlogging in favor of custom one
        .requestLogging(false)
        .requestListener(HTTPListeners::logRequest);
  }

  @Bean
  ApiClient client(Builder b) {

    return b.baseUrl(Config.get("base.url")).build().create(ApiClient.class);
  }
}
