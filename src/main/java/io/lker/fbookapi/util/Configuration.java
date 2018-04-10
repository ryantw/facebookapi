package io.lker.fbookapi.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * Assumes config file located in resources/
 * and formatted accordingly
 * APP_ID=FacebookAppID
 * APP_SECRET=FacebookAppSecret
 * BEARER_TOKEN=FacebookBearerToken
 */
public class Configuration {
    public static String APP_ID;
    public static String APP_SECRET;
    public static String BEARER_TOKEN;
    public static String PROXY_SERVER;
    public static final String CONFIG_FILE = "config.txt";

    public static void init(){
        Properties facebookAppProps = new Properties();
        ClassLoader classLoader = Configuration.class.getClassLoader();
        try {
            File file = new File(classLoader.getResource(CONFIG_FILE).getFile());
            FileInputStream config = new FileInputStream(file);
            facebookAppProps.load(config);
            if(!facebookAppProps.isEmpty()){
                assignProperties(facebookAppProps);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void assignProperties(Properties props){
        if(props.containsKey("APP_ID"))
            APP_ID = props.getProperty("APP_ID");
        if(props.containsKey("APP_SECRET"))
            APP_SECRET = props.getProperty("APP_SECRET");
        if(props.containsKey("BEARER_TOKEN"))
            BEARER_TOKEN = props.getProperty("BEARER_TOKEN");
        if(props.containsKey("PROXY_SERVER"))
            PROXY_SERVER = props.getProperty("PROXY_SERVER");
    }
}
