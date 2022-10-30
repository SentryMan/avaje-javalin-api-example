package com.jojo.javalin.api.exception;

import io.avaje.jsonb.Json;

@Json
public record ErrorResponse(String id, String text) {}
