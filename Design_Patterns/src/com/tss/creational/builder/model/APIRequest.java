package com.tss.creational.builder.model;

import com.tss.creational.builder.ENUM.RequestMethod;

import java.util.HashMap;
import java.util.Map;

public class APIRequest {
    private final String url;

    private final RequestMethod method;
    private final Map<String, String> headers;
    private final String body;
    private final int timeout;

    public APIRequest(Builder builder) {
        this.url = builder.url;
        this.method = builder.method;
        this.headers = builder.headers;
        this.body = builder.body;
        this.timeout = builder.timeout;
    }

    public String getUrl() {
        return url;
    }

    public RequestMethod getMethod() {
        return method;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public String getBody() {
        return body;
    }

    public int getTimeout() {
        return timeout;
    }

    @Override
    public String toString() {
        return "APIRequest{" +
                "url='" + url + '\'' +
                ", method='" + method + '\'' +
                ", headers=" + headers +
                ", body='" + body + '\'' +
                ", timeout=" + timeout +
                '}';
    }

    public static class Builder {
        private final String url;
        private RequestMethod method = RequestMethod.GET;
        private Map<String, String> headers = new HashMap<>();
        private String body;
        private int timeout = 30000;

        public Builder(String url) {
            this.url = url;
        }

        public Builder method(RequestMethod method) {
            this.method = method;
            return this;
        }

        public Builder addHeader(String key, String value) {
            this.headers.put(key, value);
            return this;
        }

        public Builder body(String body) {
            this.body = body;
            return this;
        }

        public Builder timeout(int timeout) {
            this.timeout = timeout;
            return this;
        }

        public APIRequest build() {
            return new APIRequest(this);
        }
    }
}
