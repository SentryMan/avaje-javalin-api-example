package com.jojo.javalin.api.config;

import java.time.Instant;

import io.avaje.config.Config;
import io.avaje.http.client.AuthToken;
import io.avaje.http.client.AuthTokenProvider;
import io.avaje.http.client.HttpClientRequest;
import io.avaje.jsonb.Json;
import io.avaje.jsonb.Json.Property;

// @Singleton

public class AuthProvider implements AuthTokenProvider {

  private static final String ID = Config.get("client.id");

  private static final String SECRET = Config.get("client.secret");

  private static final String BASE_URL = Config.get("token.base.url");

  @Override
  public AuthToken obtainToken(HttpClientRequest tokenRequest) {

    final var token =
        tokenRequest
            .url(BASE_URL + "/oauth2/token")
            .header("Content-Type", "application/x-www-form-urlencoded")
            .formParam("grant_type", "client_credentials")
            .formParam("client_id", ID)
            .formParam("client_secret", SECRET)
            .POST()
            .bean(Oauth2Token.class);

    final var validUntil = Instant.now().plusSeconds(token.expiresIn()).minusSeconds(60);

    return AuthToken.of(token.value(), validUntil);
  }

  @Json
  public record Oauth2Token(
      @Property("expires_in") int expiresIn,
      @Property("access_token") String value,
      @Property("token_type") String tokenType) {}
}
