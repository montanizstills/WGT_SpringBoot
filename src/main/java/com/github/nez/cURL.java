package com.github.nez;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;


public class cURL {

    URL url;
    URLConnection connection;
    InputStream response;
    String output;

    public cURL(String incomingURL){
       createUrl(incomingURL);
    }

    public void createUrl(String incomingURL){
        try {
            this.url = new URL(incomingURL);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void establishConnection(){
        try {
            this.connection =  this.url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void catchResponse(){
        try {
            this.response=this.connection.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void convertStreamToString(){
        BufferedReader br = new BufferedReader(new InputStreamReader(response));
        StringBuffer sb = new StringBuffer();
        try{
            while(br.readLine()!=null){
                System.out.println(br.readLine());
                sb.append(output);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        this.output=sb.toString();
    }

    public void connect(){
        establishConnection();
        catchResponse();
        convertStreamToString();
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public URLConnection getConnection() {
        return connection;
    }

    public void setConnection(HttpURLConnection connection) {
        this.connection = connection;
    }

    public InputStream getResponse() {
        return response;
    }

    public void setResponse(InputStream response) {
        this.response = response;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }
}
