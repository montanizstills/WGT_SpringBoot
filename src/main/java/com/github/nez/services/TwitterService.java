package com.github.nez.services;

import com.github.nez.OauthConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


@Service
public class TwitterService {

    @Autowired
    public TwitterService() {
    }

    public String getRequestToken() {
        String response = OauthConnection.TWITTER_REQUEST_TOKEN.retrieve("https://api.twitter.com/oauth/request_token");
//        return response.split("=|&")[1];
        return response;
    }

    public void authenticate(String token) {
        URL url = null;
        String response = "";
        try {
            url = new URL("https://api.twitter.com/oauth/authorize?oauth_token=" + token);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }

//public String getAccessToken(){
////        cURL url = new cURL("https://api.twitter/oauth/access_token");
//    //    POST oauth/access_token
//    //    Params: oauth_verifier,
//    //    oauth_consumer_key,
//    //    oauth_token
//        return null;
//}


    }
}
