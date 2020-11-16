package model;

public class SearchVO {
    private String id;
    private String voice;
    private float lat, lng;
    private boolean secret; // 0=public, 1=private

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVoice() {
        return voice;
    }

    public void setVoice(String voice) {
        this.voice = voice;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLng() {
        return lng;
    }

    public void setLng(float lng) {
        this.lng = lng;
    }

    public boolean isSecret() { return secret; }

    public void setSecret(boolean secret) {
        this.secret = secret;
    }
}
