package com.jojo.javalin.api;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import io.avaje.inject.test.InjectTest;
import io.javalin.Javalin;
import jakarta.inject.Inject;

@InjectTest
class JavalinAPITest {
  @Inject Javalin server;

  @Test
  void test() {
    assertNotNull(server);
  }
}
