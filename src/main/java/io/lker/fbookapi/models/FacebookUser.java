package io.lker.fbookapi.models;

public class FacebookUser {
    private String username;
    private String postUrl;

    public FacebookUser(){
        this.username = "goarmy";
    }

    public FacebookUser(String username){
        this.username = username;
        this.postUrl = String.format("https://graph.facebook.com/%s/posts", this.getUsername());
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPostUrl() {
        return postUrl;
    }

    public void setPostUrl(String postUrl) {
        this.postUrl = postUrl;
    }
}
