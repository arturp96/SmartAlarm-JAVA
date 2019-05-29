package com.example.artur.smartalarmv1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class alarmOff extends MainActivity {
    private static final long serialVersionUID = -8842540672169455970L;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_off);
    }

    public void alarmOff1(View view){
        innit();
        //this method calls the innit method

    }

    public void innit(){
        Intent alarmSound = new Intent(alarmOff.this, puzzleGame.class);

        startActivity(alarmSound);
        //this method creates a new Intent and when its called in the method above the application goes to to a new class called puzzle game where a used has to complete a puzzle to turn off the alarm
    }
}

// this class is very simple as it only contains functions for one button which when pressed takes the user to the puzzle class.