package com.jojo.javalin.api.models;

import io.avaje.jsonb.Json;

@Json
public record ServerPingResponse(long connectTime, long protocolTime, String rawPingResponse) {}
