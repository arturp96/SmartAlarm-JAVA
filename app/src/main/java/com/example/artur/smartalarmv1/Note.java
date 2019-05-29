package com.example.artur.smartalarmv1;

import android.content.Context;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by artur on 27/03/2018.
 */

public class Note implements Serializable {
    private static final long serialVersionUID = -8842540672169455970L;// if you have an object which is a class and you want to save the current state of the the object
    // you created  as binary file, serialastion is used which basically saves the current state of an object on your storage which can be used later on.
    //this is how this app saves dreams files everytime the application is closed

    private long mDateTime;// a long variable for date and time
    private String mTitle;//new string variable for the title of the dream
    private String mContent;//new string variable for the content of the dream

    public Note(long dateTime, String title, String content) {
        this.mDateTime = dateTime;
        this.mTitle = title;
        this.mContent = content;
        //creating a constructor which initializes the instances of the variables created above
    }

    public void setDateTime(long dateTime) {
        this.mDateTime = dateTime;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public void setContent(String content) {
        this.mContent = content;
    }

    public long getDateTime() {
        return mDateTime;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getContent() {
        return mContent;
    }
    //The purpose of these getters and setters is to encapsulate the variables mentioned above and let other classes access these variables without changing the values.

    public String getDateTimeFormated(Context context){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"
                , context.getResources().getConfiguration().locale);
         sdf.setTimeZone(TimeZone.getDefault());
         return sdf.format(new Date(mDateTime));
         //setting the dateformat to dd/MM/yyyy HH:mm:ss which is how the date is displayed when a dream is saved
    }
}
