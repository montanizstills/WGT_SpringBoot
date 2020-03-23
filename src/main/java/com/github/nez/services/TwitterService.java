package com.github.nez.services;

import com.github.nez.cURL;

public class TwitterService {

    public static String getRequestToken() {
        cURL url = new cURL("https://api.twitter.com/oauth2/token","POST");
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
