package com.github.nez.controllers;

import com.github.nez.services.TwitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@CrossOrigin("*")
public class TwitterController {

    private TwitterService twitterService;

    @Autowired
    public TwitterController(TwitterService twitterService){
        this.twitterService=twitterService;
    }


//    request token
//    authorize
//    access token

    @RequestMapping(value = "/twitter/request", method = RequestMethod.GET)
    ResponseEntity<?> getRequestToken(){
        String token = twitterService.getRequestToken();
        twitterService.authenticate(token);
        ResponseEntity responseEntity = new ResponseEntity(token, HttpStatus.OK);
        return responseEntity;
    }
}
