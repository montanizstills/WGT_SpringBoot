package com.github.nez;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public enum OauthConnection {
    TWITTER_REQUEST_TOKEN("OAuth " +
            "oauth_consumer_key="+ System.getenv("TWITTER_CONSUMER_KEY")+","+
            "oauth_token="+ System.getenv("TWITTER_ACCESS_TOKEN")+","+
            "oauth_signature_method=HMAC-SHA1,"+
            "oauth_timestamp=1585509244," +
            "oauth_nonce=xySSnxZQEvi," +
            "oauth_version=1.0,oauth_signature=m4%2BScQYRJsxt2k5DQ9K7Jin6ti8%3D");


     OauthConnection(String body){
         this.body=body;
     }

     private String body;
     public String getAuth(){
         return this.body;
     }
    public String retrieve(String uri){
        String responseString="";
        HttpPost postRequest = new HttpPost(uri);
        postRequest.setHeader("Authorization",OauthConnection.TWITTER_REQUEST_TOKEN.getAuth());
        postRequest.addHeader("Access-Control-Allow-Origin","*");

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpResponse response = null;
        try {
            response = httpClient.execute(postRequest);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        HttpEntity entity = response.getEntity();

        try {
            BufferedReader bf = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            while((responseString=bf.readLine())!=null){
                sb.append(responseString);
            }
            responseString=sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return responseString;
    }



}
