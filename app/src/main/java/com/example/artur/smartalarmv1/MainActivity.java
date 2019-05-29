package com.example.artur.smartalarmv1;

import android.app.ActionBar;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {
    private static final long serialVersionUID = -8842540672169455970L;

    AlarmManager alarm_manager;// create a new alarm manager variable
    TimePicker alarm_timepicker;//create a new timepicker variable
    TextView update_text;//create a  new textview variable
    Context context;// create a new context variable
    PendingIntent pending_intent;//create a new pendingintent variable
    Intent my_intent;//create a new intent variable

    //boolean isHomeButtonTriggered = false;

    public void goStopwatch(View v){
        Intent stopWatch = new Intent(MainActivity.this, Stopwatch.class);
        startActivity(stopWatch);// this goStopwatch method is is run when the stop watch button is clicked on the alarm interface.
        //the on click listener is implemented by android in the xml file and is used here as an intent.
    }
    public void goHome(View v){
        Intent home = new Intent(MainActivity.this, Home.class);
        startActivity(home);
        // this goHome method is is run when the stop watch button is clicked on the alarm interface.
        //the on click listener is implemented by android in the xml file and is used here as an intent.
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        //getSupportActionBar().hide();
        if(getSupportActionBar() != null){
          getSupportActionBar().setDisplayHomeAsUpEnabled(true);
          getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        super.onCreate(savedInstanceState);
        puzzleGame game = new puzzleGame();
        setContentView(R.layout.activity_main);

        this.context = this;
        //the code above takes the current state of the Main activity through this.context and passes it into the main activity.

        alarm_manager = (AlarmManager) getSystemService(ALARM_SERVICE);
        //initialize alarm manger
        //this code allows the class to retrieve an AlarmManager to receive intents at any time.


        alarm_timepicker = (TimePicker) findViewById(R.id.timePicker);
        alarm_timepicker.setIs24HourView(true);
        //initialize our timemepicker by passing the time picker object into the alarm_timepicker variable.

        update_text = (TextView) findViewById(R.id.update_text);
        //initialize our textView by passing the textview object into the update_text variable
        //this specific text view is used to show what time the alarm will be set to.


        my_intent = new Intent(this.context, Alarm_Receiver.class);
        //create an intent to the Alarm Receiver class













    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    public void alarmOn(View view){
        final Calendar calendar = Calendar.getInstance();
        //create an instance of a calendar, it uses final so the values of the calendar cannot be changed

        at.markushi.ui.CircleButton alarm_on = (at.markushi.ui.CircleButton) findViewById(R.id.alarm_on);
        //this is a special design button which impelemts the alarm_on onclick method from the xml file

        calendar.set(Calendar.HOUR_OF_DAY, alarm_timepicker.getHour());
        calendar.set(Calendar.MINUTE, alarm_timepicker.getMinute());
        //setting calendar instance with the hour and minute that i picked on the timepicker


        int hour = alarm_timepicker.getHour();
        int minute = alarm_timepicker.getMinute();


        //getting the string values of hour and minute so they can be used somewhere else




        String hour_string = String.valueOf(hour);
        String minute_string = String.valueOf(minute);
        //convert the int values to string so they can be put in the the update_text textview







        if(minute < 10){
            minute_string = "0" + String.valueOf(minute);
        }//this if statement checks if minute variable is less then 10 and if it is it adds a 0 as a stirng value so that the time displayed look more atheistically pleasing

        set_alarm_text("Alarm set to: " + hour_string + ":" + minute_string);
        Toast.makeText(this,"Alarm set to: " + hour_string + ":" + minute_string,Toast.LENGTH_SHORT).show();
        //method that changes the update text
        //set_alarm_text is a method that outputs the update_text into the time that has been set on the timepicker for the users to read.



        my_intent.putExtra("extra", "Alarm on");
        //put in extra string into my_intent
        //tells the clock that you pressed the "alarm on button"


        pending_intent = PendingIntent.getBroadcast(MainActivity.this, 0,
                my_intent, PendingIntent.FLAG_UPDATE_CURRENT);
        //create a pending intent that delays the intent. Without the pending intent the alarm clock would ring as soon as the button is pressed regardless of what time it was set to.
        //until the specified calendar time


       // do {
            alarm_manager.setExact(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pending_intent);
            // AlarmManager.RTC_WAKEUP will trigger the alarm according to the time of the clock which gets activated by the pending intent

        //}while(Calendar.HOUR_OF_DAY == hour && Calendar.MINUTE == minute);

    }



    public void set_alarm_text(String output) {
        update_text.setText(output);
    }
    //this method contains the output which is the hour and minute in strings and saved is as output and inputs this output string into the update_text textView




}
