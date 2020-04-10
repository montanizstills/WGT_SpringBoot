package com.github.nez;

//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.github.nez.services.TwitterService;

import java.util.Collections;

//com.github.nez.controllers
//@SpringBootApplication
public class MainApplication implements RequestHandler<Object,GatewayResponse> {

//    public static void main(String[] args) {
//        SpringApplication.run(MainApplication.class,args);
//    }

    @Override
    public GatewayResponse handleRequest(Object o, Context context) {
        return new GatewayResponse(new TwitterService().getRequestToken(), Collections.singletonMap("SomeHeader","itsValue"),false,200);
    }
}

