package io.lker.fbookapi.util;

import io.lker.fbookapi.models.FacebookUser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class FacebookConnection {
    FacebookUser facebookUser;
    private String proxyAddress;

    public FacebookConnection(FacebookUser facebookUser){
        this.facebookUser = facebookUser;
    }

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

                System.out.println(buffer.toString());
                return buffer.toString();

            }

        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        } finally {
            if (urlConnection != null)
                urlConnection.disconnect();
        }

        return null;
    }
}
