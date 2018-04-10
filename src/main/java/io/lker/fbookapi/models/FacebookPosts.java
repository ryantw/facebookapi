package io.lker.fbookapi.models;

import io.lker.fbookapi.models.post.FacebookPost;

import java.util.ArrayList;
import java.util.List;

public class FacebookPosts {
    private List<FacebookPost> data = new ArrayList<FacebookPost>();

    public FacebookPosts(List<FacebookPost> data) {
        this.data = data;
    }

    public List<FacebookPost> getData() {
        return data;
    }

    public void setData(List<FacebookPost> data) {
        this.data = data;
    }
}
