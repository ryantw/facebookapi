package io.lker.fbookapi.util;

import com.google.gson.Gson;
import io.lker.fbookapi.models.FacebookPosts;
import io.lker.fbookapi.models.FacebookUser;
import io.lker.fbookapi.models.post.FacebookPost;
import io.lker.fbookapi.models.post.FacebookPostDetails;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * Handles all API requests to facebook
 */
public class FacebookConnection {
    FacebookUser facebookUser;
    private String proxyAddress;

    public FacebookConnection(FacebookUser facebookUser){
        this.facebookUser = facebookUser;
    }

    /**
     * Fetch the latest posts for a facebook user
     * @return json in a string format, to be formatted by gson
     */
    public String RetrievePosts() {
        HttpURLConnection urlConnection = null;

        try {
            URL queryUrl = new URL(facebookUser.getPostUrl());
            //todo proxy detection;
            urlConnection = (HttpURLConnection) queryUrl.openConnection();
            urlConnection.setRequestProperty("Accept-Charset", "UTF-8");
            urlConnection.setRequestProperty("Authorization", "Bearer " + Configuration.BEARER_TOKEN);
            urlConnection.connect();

            if (urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(urlConnection.getInputStream()));

                StringBuffer buffer = new StringBuffer();
                String inputLine;

                while ((inputLine = in.readLine()) != null) {
                    buffer.append(inputLine);
                }

                return buffer.toString();
            }

        } catch (Exception e) {
            System.err.println(e.getStackTrace());
        } finally {
            if (urlConnection != null)
                urlConnection.disconnect();
        }
        return null;
    }

    /**
     * Sets detailed information about a facebook post
     * @param facebookUser
     */
    public void SetPostDetails(FacebookUser facebookUser){
        if(facebookUser.getFacebookPosts() == null)
            throw new RuntimeException("Post Details not found!");

        facebookUser.getFacebookPosts()
                .getData()
                .forEach(facebookPost -> facebookPost.setFacebookPostDetails(FetchFacebookPostDetails(facebookPost)));
    }

    public FacebookPostDetails FetchFacebookPostDetails(FacebookPost facebookPost){
        //todo make querystring dynamic, passed in or set in postutil
        String queryString = "?fields=id,status_type,picture,message,permalink_url";
        String facebookPostUrl = String.format("https://graph.facebook.com/v2.12/%s%s",
                facebookPost.getId(), queryString);
        Gson gson = new Gson();

        HttpURLConnection urlConnection = null;

        try {
            URL queryUrl = new URL(facebookPostUrl);
            //todo proxy detection;
            urlConnection = (HttpURLConnection) queryUrl.openConnection();
            urlConnection.setRequestProperty("Accept-Charset", "UTF-8");
            urlConnection.setRequestProperty("Authorization", "Bearer " + Configuration.BEARER_TOKEN);
            urlConnection.connect();

            if (urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(urlConnection.getInputStream()));

                StringBuffer buffer = new StringBuffer();
                String inputLine;

                while ((inputLine = in.readLine()) != null) {
                    buffer.append(inputLine);
                }

                return gson.fromJson(buffer.toString(), FacebookPostDetails.class);

            }

        } catch (Exception e) {
            System.err.println(e.toString());
        } finally {
            if (urlConnection != null)
                urlConnection.disconnect();
        }

        return null;
    }
}
