package com.jojo.javalin.api;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import io.avaje.inject.test.InjectTest;
import io.javalin.Javalin;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

@InjectTest
class JavalinAPITest {
  @Inject Javalin server;

  @Test
  void test() {
    assertNotNull(server);
  }
}
