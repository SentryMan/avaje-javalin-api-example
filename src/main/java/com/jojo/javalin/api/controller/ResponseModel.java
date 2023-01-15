package com.jojo.javalin.api.controller;

import io.avaje.jsonb.Json;

@Json
public record ResponseModel(String response) {}
