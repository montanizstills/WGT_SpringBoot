package com.github.nez;

//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.github.nez.services.TwitterService;

//com.github.nez.controllers
//@SpringBootApplication
public class MainApplication implements RequestHandler<Object,String> {

//    public static void main(String[] args) {
//        SpringApplication.run(MainApplication.class,args);
//
//    }

    @Override
    public String handleRequest(Object o, Context context) {
        return new TwitterService().getRequestToken();
    }
}

