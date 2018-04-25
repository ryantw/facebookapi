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
        FacebookConnection facebookConnection = new FacebookConnection(facebookUser);

        facebookUser.setFacebookPosts(gson.fromJson(
                facebookConnection
                .RetrievePosts(), FacebookPosts.class
        ));

        facebookConnection.SetPostDetails(facebookUser);

        facebookUser.getFacebookPosts()
                .getData()
                .forEach(post -> System.out.println(post.getFacebookPostDetails()));


    }
}
