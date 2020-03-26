package com.github.nez;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStreamReader;



@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
      SpringApplication.run(MainApplication.class,args);
    }
}

