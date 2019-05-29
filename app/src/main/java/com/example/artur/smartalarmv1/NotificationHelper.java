package com.example.artur.smartalarmv1;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;

/**
 * Created by artur on 19/02/2018.
 */

public class NotificationHelper extends ContextWrapper {private static final long serialVersionUID = -8842540672169455970L;
    public static final String channel1ID = "channel1ID";
    public static final String channel1Name = "channel 1";
    private NotificationManager mManager;
    Intent intent1 = new Intent(this.getApplicationContext(), MainActivity.class);
    PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent1, 0);


    public NotificationHelper(Context base) {
        super(base);
        try{
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                createChannels();
            }// the code above checks if the sdk version is greater or equal to the Oreo build version and if it is then it will create the channels
            // this is important because in the oreo update the way you implement notification has been changed to use a new concept called channels
            // this also makes sure that if this application is run on an older android device then the notifications still work.
        }
        catch (Exception e){
            e.printStackTrace();
        }


    }

    @TargetApi(Build.VERSION_CODES.O)
    public void createChannels() {
        NotificationChannel channel1 = new NotificationChannel(channel1ID, channel1Name, NotificationManager.IMPORTANCE_DEFAULT);// creating a new instance of a NotificationChannel
        // and feeding it with previously created variables
        channel1.enableLights(true);// allows the notification to turn on the notification light on a phone
        channel1.enableVibration(true);//turns on vibrations when the notification is deployed
        channel1.setLightColor(R.color.colorPrimary);//sets the notification light to the primary colour of this application
        channel1.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);//makes the notification visible on the lock screen
        getManager().createNotificationChannel(channel1);

    }
    public NotificationManager getManager(){
        if(mManager ==null){
            mManager= (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        }
        return mManager;
    }
    public NotificationCompat.Builder getChannel1Notification(String title, String message){
        return new NotificationCompat.Builder(getApplicationContext(),channel1ID)
                .setContentTitle(title)
                .setContentText(message)
                .setSmallIcon(R.drawable.ic_one)
                .setAutoCancel(true)
                .setContentIntent(pIntent);

        // the code above sets the behaviour and looks of the notification

    }
}
