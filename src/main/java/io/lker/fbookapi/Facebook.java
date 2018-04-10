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

        System.out.println(Configuration.CONFIG_FILE);
        System.out.println(Configuration.APP_ID);
        System.out.println(Configuration.APP_SECRET);
        System.out.println(Configuration.BEARER_TOKEN);

        FacebookPosts facebookPosts = gson.fromJson(
                new FacebookConnection(
                    new FacebookUser("goarmy")).RetrievePosts(), FacebookPosts.class);

        facebookPosts.getData().forEach(post -> System.out.println(post));
    }
}
