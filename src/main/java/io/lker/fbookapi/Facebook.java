package io.lker.fbookapi;

import io.lker.fbookapi.util.Configuration;

public class Facebook {

    public static void main(String args[]){
        Configuration.init();

        System.out.println(Configuration.CONFIG_FILE);
        System.out.println(Configuration.APP_ID);
        System.out.println(Configuration.APP_SECRET);
        System.out.println(Configuration.BEARER_TOKEN);
    }
}
