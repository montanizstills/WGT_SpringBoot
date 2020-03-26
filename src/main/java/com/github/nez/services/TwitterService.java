package com.github.nez.services;

import com.github.nez.cURL;
import com.github.nez.models.Header;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.HttpURLConnection;

@Service
public class TwitterService {

    @Autowired
    public TwitterService(){}

    public  String getRequestToken() {
        cURL url = new cURL("https://api.twitter.com/oauth/request_token");
        url.getConnection().setRequestProperty("Authorization",
                "Oauth oauth_consumer_key='\"'"+Header.TWITTER.getHeaderItem("SPRING_TWITTER_CONSUMER_KEY")+"\","+
                "oauth_access_token= '\"'"+Header.TWITTER.getHeaderItem("SPRING_TWITTER_ACCESS_KEY")+'\"');
        url.getConnection().setDoOutput(true);
        url.connect();
        return url.getOutput();
    }


//
//    GET oauth/authorize
//    Params: oauth_token
//
//    POST oauth/access_token
//    Params: oauth_verifier,
//    oauth_consumer_key,
//    oauth_token


}
