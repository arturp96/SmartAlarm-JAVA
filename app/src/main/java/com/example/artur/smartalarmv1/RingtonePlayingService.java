package com.example.artur.smartalarmv1;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by artur on 17/02/2018.
 */

public class RingtonePlayingService extends Service {

    private static final long serialVersionUID = -8842540672169455970L;
    MediaPlayer media_song;// create a new MediaPlayer variable
    int startId;//create a start id Variable
    boolean isRunning;// create a boolean variable which will be used to check if the ringtone is being played
    private NotificationHelper mNotificationHelper;//create a  new Notification helper variable

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public int onStartCommand(Intent intent, int flags, int startId){


        Log.i("LocalService", "Receive start id " + startId + ": " + intent);
        //fetch the extra string values
        String state= intent.getExtras().getString("extra");


        assert state != null;
        switch (state) {
            case "Alarm on":
                startId = 1;
                break;
            case "Alarm off":
                startId = 0;

                break;
            default:
                startId = 0;
                break;
        }
        ///this converts the extra strings from the intent
        //to start IDs, values 0 and 1
        //switch statements have the exact same functionality as if statements which are unique to android studio

        mNotificationHelper = new NotificationHelper(this);
        //initialize the notificationHelper

        if(!this.isRunning && startId == 1){
            Log.e("there is no music ", "and you want on");
            //create an instance of the media player
            media_song = MediaPlayer.create(this, R.raw.alarmsound1);
            //loops the sound
            media_song.setLooping(true);
            //loop the sound file after its duration ends
            media_song.start();
            innit();
            sendOnChannel1("Hey its time to wake up", "Click me!");
            //if this conditions is true the user gets the above notification

            this.isRunning = true;
            //set the boolean variable to true, stating that the ringtone is playing
            this.startId = 0;
            //if else statements
            //if there is no music playing, and the user pressed "alarm on"
            //music should start playing



        }

        else if(this.isRunning && startId == 0){
            Log.e("there is music ", "and you want end");
            media_song.stop();
            media_song.reset();
            this.isRunning = false;
            this.startId= 0;
            //if there is music playing, and the user pressed "alarm off"
            //music should stop playing

        }

        else if(!this.isRunning && startId == 0){
            Log.e("there is no music ", "and you want end");
            this.isRunning = false;
            this.startId = 0;
            //the following if else statements are the to prevent bugs
            //if there is no music playing and the users presses alarm off
            //do nothing
        }

        else if(this.isRunning && startId ==1){
            Log.e("there is  music ", "and you want on");
            this.isRunning = true;
            this.startId = 1;
            //if there is music playing and the users presses alarm on
            //do nothing

        }

        else {
            Log.e("else ", "and you want on");
            //Logs are used as a way of troubleshooting to easily spot what condition has be deployed, this allows for quick bug spotting
        }

        return START_NOT_STICKY;
    }
    public void sendOnChannel1(String title, String message){
        NotificationCompat.Builder nb = mNotificationHelper.getChannel1Notification(title, message);
        mNotificationHelper.getManager().notify(1, nb.build());
        //this method implements the notifications and is called in the first switch statements above for when the alarm goes off.

    }
    public void innit(){
       Intent alarmSound = new Intent(RingtonePlayingService.this, alarmOff.class);
       alarmSound.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
       startActivity(alarmSound);
       //this method creates a new Intent and when its called in the first switch statement the application goes to to a new class called alarm_off
    }



    @Override
    public void onDestroy(){
        //tell the user we stopped
        Toast.makeText(this, "on Destroy called",  Toast.LENGTH_SHORT).show();
    }





}
