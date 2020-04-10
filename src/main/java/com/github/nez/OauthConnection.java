package com.github.nez;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Instant;

public enum OauthConnection {
    TWITTER_REQUEST_TOKEN("OAuth " +
            "oauth_consumer_key="+System.getenv("TWITTER_CONSUMER_KEY")+","+
            "oauth_token="+System.getenv("TWITTER_ACCESS_TOKEN")+","+
            "oauth_signature_method=HMAC-SHA1,"+
            "oauth_timestamp="+Instant.now().getEpochSecond()+","+
            "oauth_nonce="+RandomStringUtils.randomAlphabetic(11)+","+
            "oauth_version=1.0,"+
            "oauth_signature="+new HmacSha1Signature(System.getenv("TWITTER_CONSUMER_KEY")).getSignature());

     OauthConnection(String body){
         this.body=body;
     }

     private String body;

     public String getHeaders(){
         return this.body;
     }


     public HttpResponse getHttpResponse(HttpPost postRequest){
         CloseableHttpClient httpClient = HttpClients.createDefault();
         try {
          return httpClient.execute(postRequest);
         }
         catch (IOException e) {
             e.printStackTrace();
         }
         return null;
     }

     public String convertResponseToString(HttpResponse response){
         HttpEntity entity = response.getEntity();
         String responseString="";
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

     public String executeRequest(HttpPost postRequest){
         HttpResponse response = getHttpResponse(postRequest);
         return convertResponseToString(response);
     }

     public String retrieve(String uri){
        HttpPost postRequest = new HttpPost(uri);
        postRequest.setHeader("Authorization",OauthConnection.TWITTER_REQUEST_TOKEN.getHeaders());
        postRequest.addHeader("Access-Control-Allow-Origin","*");
           return executeRequest(postRequest);
    }

}
