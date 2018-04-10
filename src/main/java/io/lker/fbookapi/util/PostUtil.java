package io.lker.fbookapi.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PostUtil {

    public static String convertPostDate(String FacebookPostDate) {
        if(FacebookPostDate == null)
            return null;

        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'H:mm:ssZ");
        LocalDateTime convertedDateTime = LocalDateTime.parse(FacebookPostDate, inputFormatter);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy kk:mm");


        return convertedDateTime.format(outputFormatter);
    }
}
