package com.tss.creational.builder.test;

import com.tss.creational.builder.ENUM.RequestMethod;
import com.tss.creational.builder.model.APIRequest;

public class APIRequestMain {
    public static void main(String[] args) {
        APIRequest apiRequest1 = new APIRequest.Builder("https://api.example.com/data")
                .build();
        System.out.println("APIRequest 1: " + apiRequest1);

        APIRequest apiRequest2 = new APIRequest.Builder("https://api.example.com/user")
                .method(RequestMethod.POST)
                .body("{\"name\": \"Divyarajsinh\",\"email\": \"divyarajsinh.sindhav@java.com\"}")
                .addHeader("X-Auth", "token")
                .addHeader("Content-Type", "application/json")
                .build();
        System.out.println("APIRequest 2: " + apiRequest2);
    }
}
