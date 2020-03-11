package controllers;

import models.Header;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import services.TwitchService;

@Controller
@CrossOrigin(value="localhost:4200/twitch")
public class TwitchController {
    private TwitchService twitchService;

    @Autowired
    public TwitchController(TwitchService twitchService){
        this.twitchService=twitchService;
    }

    public ResponseEntity<?> getHeaders(){
        Header header = twitchService.getHeader();
        ResponseEntity responseEntity = new ResponseEntity(header, HttpStatus.OK);
        return responseEntity;
    }

}
