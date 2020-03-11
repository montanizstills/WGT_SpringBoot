package models;

import org.json.JSONObject;

public enum Header {

    TWITCH(System.getenv("REACT_APP_TWITCH_CLIENT_ID"),System.getenv("REACT_APP_TWITCH_SECRET")),
    DISCORD(null),
    TWITTER(null),
    FACEBOOK(null),
    MIXER(null);

    private JSONObject body;

    Header(String... body){
        this.body= new JSONObject(body);
    }

    public JSONObject getBody() {
        return body;
    }

    public void setBody(JSONObject body) {
        this.body = body;
    }

    //Client-ID: value
}
