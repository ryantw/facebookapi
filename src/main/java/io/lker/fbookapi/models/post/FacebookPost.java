package io.lker.fbookapi.models.post;

import io.lker.fbookapi.util.PostUtil;

public class FacebookPost {
    private String story;
    private String created_time;
    private String id;
    private String message;

    public FacebookPost(String story, String created_time, String id, String message) {
        this.story = story;
        this.created_time = created_time;
        this.id = id;
        this.message = message;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public String getCreated_time() {
        return created_time;
    }

    public void setCreated_time(String created_time) {
        this.created_time = created_time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString(){
        return String.format("%s - %s [%s] (%s)", this.getId(), this.getStory(), this.getMessage(), PostUtil.convertPostDate(this.getCreated_time()));
    }
}
