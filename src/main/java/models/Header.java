package models;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public enum Header {

    TWITCH(System.getenv("REACT_APP_TWITCH_CLIENT_ID"),System.getenv("REACT_APP_TWITCH_SECRET")),
    DISCORD(null),
    TWITTER(null),
    FACEBOOK(null),
    MIXER(null);

    private Map<Integer,String> body;

    Header(String... headerElements){
        this.body = new HashMap<>();
        System.out.println(headerElements.length);
        for (int index=0; index<=headerElements.length; index++){
            System.out.println(headerElements[index]);
            //            this.body.put(index,headerElements[index]);
        }
    }

    public JSONObject getBody() {
        return new JSONObject(body);
    }

    public void addHeaderItem(String item){
        int index = this.body.size()+1;
        this.body.put(index,item);
    }

}


