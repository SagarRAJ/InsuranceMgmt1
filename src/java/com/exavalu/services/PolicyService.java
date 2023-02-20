/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.services;

import com.exavalu.models.Policy;
import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 *
 * @author Win10
 */
public class PolicyService {

    public static Policy doFetchPolicy() throws Exception {
        String result = "SUCCESS";
        HttpRequest postRequest = HttpRequest.newBuilder().uri(new URI("https://mocki.io/v1/3b14a1bf-47e6-470d-9be3-98e791c2ec1f")).build();

        //creating client object to send request
        HttpClient httpClient = HttpClient.newHttpClient();

        HttpResponse<String> postResponse = httpClient.send(postRequest, HttpResponse.BodyHandlers.ofString());
        //to get body of response
        // System.out.println(postResponse.body());
        String textArea = postResponse.body();

        Gson gson = new Gson();
        Policy policy = gson.fromJson(postResponse.body(), Policy.class);
        System.out.println("policyNumber = " + policy.getPolicyNumber());

        return policy;
    }

}
