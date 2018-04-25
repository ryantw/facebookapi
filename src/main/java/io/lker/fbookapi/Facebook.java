package io.lker.fbookapi;

import com.google.gson.Gson;
import io.lker.fbookapi.models.FacebookPosts;
import io.lker.fbookapi.models.FacebookUser;
import io.lker.fbookapi.util.Configuration;
import io.lker.fbookapi.util.FacebookConnection;


public class Facebook {

    public static void main(String args[]){
        Configuration.init();
        Gson gson = new Gson();
        FacebookUser facebookUser = new FacebookUser("goarmy");

        facebookUser.setFacebookPosts(gson.fromJson(
                new FacebookConnection(facebookUser)
                .RetrievePosts(), FacebookPosts.class
        ));

        facebookUser.getFacebookPosts()
                .getData()
                .forEach(post -> System.out.println(post));
    }
}
