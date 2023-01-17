package com.jojo.javalin.api.models;

import io.avaje.jsonb.Json;

@Json
public record RequestModel(String value) {}
