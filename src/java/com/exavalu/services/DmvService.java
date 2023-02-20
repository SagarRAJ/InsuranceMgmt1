/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.services;

import com.exavalu.models.Dmv;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.Serializable;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import org.apache.struts2.dispatcher.ApplicationMap;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Win10
 */
public class DmvService {

    public static Dmv doFetchDmv() throws Exception {
        String result = "SUCCESS";
        HttpRequest postRequest = HttpRequest.newBuilder().uri(new URI("https://mocki.io/v1/fec5f0ce-2f89-4193-acc7-1d47c1889037")).build();

        //creating client object to send request
        HttpClient httpClient = HttpClient.newHttpClient();

        HttpResponse<String> postResponse = httpClient.send(postRequest, HttpResponse.BodyHandlers.ofString());
        //to get body of response
        // System.out.println(postResponse.body());
        String textArea = postResponse.body();

        Gson gson = new Gson();
        Dmv driverInfo = gson.fromJson(postResponse.body(), Dmv.class);
        System.out.println("Vehicle Number = " + driverInfo.getVehicleNumber());

        return driverInfo;
    }
}
