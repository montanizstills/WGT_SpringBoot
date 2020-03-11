package com.github.nez.services;

import com.github.nez.models.Header;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TwitchService {

    @Autowired
    public TwitchService(){}

    public JSONObject getHeader() {
        return Header.TWITCH.getBody();
    }
}
