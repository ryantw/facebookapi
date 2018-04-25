package io.lker.fbookapi.models.post;

public class FacebookPostDetails {
    private String id;
    private String picture;
    private String message;
    private String permalink_url;
    private String status_type;

    public FacebookPostDetails(String id, String picture, String message, String permalink_url, String status_type) {
        this.id = id;
        this.picture = picture;
        this.message = message;
        this.permalink_url = permalink_url;
        this.status_type = status_type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPermalink_url() {
        return permalink_url;
    }

    public void setPermalink_url(String permalink_url) {
        this.permalink_url = permalink_url;
    }

    public String getStatus_type() {
        return status_type;
    }

    public void setStatus_type(String status_type) {
        this.status_type = status_type;
    }

    @Override
    public String toString() {
        return String.format("%s[%s]", this.getId(), this.getStatus_type());
    }
}
