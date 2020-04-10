package com.github.nez;

import java.util.Map;

public class GatewayResponse {
    private String body;
    private Map<String,String> headers;
    private boolean isBaseEncoded;
    private Integer statusCode;

    public GatewayResponse(String body, Map<String, String> headers, boolean isBaseEncoded, Integer statusCode) {
        this.body = body;
        this.headers = headers;
        this.isBaseEncoded = isBaseEncoded;
        this.statusCode = statusCode;
    }
}
