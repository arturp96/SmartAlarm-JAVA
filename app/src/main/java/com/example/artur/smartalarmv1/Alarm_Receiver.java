package com.example.artur.smartalarmv1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by artur on 17/02/2018.
 */

public class Alarm_Receiver extends BroadcastReceiver {private static final long serialVersionUID = -8842540672169455970L;
    @Override
    public void onReceive(Context context, Intent intent) {


        //fetch extra strings from the intent
        String get_your_string = intent.getExtras().getString("extra");

        //create and intent to the ringtone service
        Intent service_intent = new Intent(context, RingtonePlayingService.class);

        //pass the extra string from Main Activity to the Ringtone Playing Service
        service_intent.putExtra("extra", get_your_string);

        //start the ringtone service
        context.startService(service_intent);

        //This can be referred as a Base class for code that receives and handles broadcast intents sent by sendBroadcast(Intent).
        // This is how the Main Activity class communicates with the ringtone playing service class


    }
}
