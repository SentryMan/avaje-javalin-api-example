package com.jojo.javalin.api.models;

import io.avaje.jsonb.Json;
import jakarta.validation.constraints.NotBlank;

@Json
public record RequestModel(@NotBlank String value) {}
