package com.example.artur.smartalarmv1;


import android.os.SystemClock;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Chronometer;


public class Stopwatch extends AppCompatActivity {

    private Chronometer chronometer;//create a new Chronometer variable
    private long pause;//create a new long variable called pause
    private boolean running; //create a new bool variable called running


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);

        chronometer = findViewById(R.id.chronometer);
        //pass the chronomter object into the chronometer variable
       // chronometer.setBase(SystemClock.elapsedRealtime());
        //


    }

    public void startStopwatch(View view) {
        if (!running) {
            chronometer.setBase(SystemClock.elapsedRealtime() - pause);// this makes sure that the time doesn't start from when the app was first opened instead it starts from when we press start
            chronometer.start();
            running = true;
        }
    }


    public void resetStopwatch(View view) {
        chronometer.setBase(SystemClock.elapsedRealtime());
        pause = 0;// setting the pause variable to 0 makes sure that when the alarm is started again that it doesn't add the time its been paused.
    }

    public void pauseStopwatch(View view) {
        if (running) {
            chronometer.stop();
            pause = SystemClock.elapsedRealtime()- chronometer.getBase();
            //pause is calculated by checking the current SystemClock.elapsedRealTime minus how long its been running
            running = false;
            //this checks if the chronometer is running and if it is and this method is run through the button press then
            //the chronometer gets stopped
            //the running bool value is set to false
        }
    }

}
