package com.jojo.javalin.api.client;

import java.io.IOException;
import java.net.http.HttpResponse;

import io.avaje.config.Config;
import io.avaje.http.client.HttpException;
import io.avaje.http.client.RetryHandler;

public final class Retry implements RetryHandler {
  private static final int MAX_RETRIES = Config.getInt("retry.max", 2);

  private static final int BACKOFF = Config.getInt("retry.backoff", 300);

  @Override
  public boolean isRetry(int retryCount, HttpResponse<?> response) {

    final var code = response.statusCode();

    if (retryCount >= MAX_RETRIES || code < 429) {

      return false;
    }

    return retrybackoff();
  }

  @Override
  public boolean isExceptionRetry(int retryCount, HttpException response) {

    final var cause = response.getCause();

    if (retryCount >= MAX_RETRIES || !(cause instanceof IOException)) {
      return false;
    }

    return retrybackoff();
  }

  private static boolean retrybackoff() {
    try {

      Thread.sleep(BACKOFF);

    } catch (final InterruptedException e) {

      Thread.currentThread().interrupt();

      return false;
    }

    return true;
  }
}
