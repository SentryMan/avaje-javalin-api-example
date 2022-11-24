package com.jojo.javalin.api;

import io.avaje.inject.test.InjectTest;
import io.javalin.Javalin;
import io.javalin.testtools.JavalinTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@InjectTest
class JavalinAPITest {

  @Inject Javalin server;

  @Test
  void test() {

    JavalinTest.test(
        server,
        (server, client) -> {
          final var response = client.get("/javalin/health");
          Assertions.assertEquals("healthlmao", response.body().string());
        });
  }
}
