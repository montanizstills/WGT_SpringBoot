package com.github.nez.controllers;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.github.nez.services.TwitchService;

@Controller
@CrossOrigin("http://localhost:3000")
public class TwitchController {

    private TwitchService twitchService;

    @Autowired
    public TwitchController(TwitchService twitchService){
        this.twitchService=twitchService;
    }

    @RequestMapping(value = "/twitch/header", method = RequestMethod.GET)
    public ResponseEntity<?> getHeader(){
        JSONObject header = twitchService.getHeader();
        System.out.println(header);
        ResponseEntity responseEntity = new ResponseEntity(header, HttpStatus.OK);
        return responseEntity;
    }

}
