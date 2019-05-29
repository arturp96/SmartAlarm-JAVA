package com.example.artur.smartalarmv1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Home extends AppCompatActivity implements View.OnClickListener{
    private CardView smartAlarm,dreamJournal,whiteNoise,about;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //defineing cards
        smartAlarm = (CardView) findViewById(R.id.alarmID);
        dreamJournal = (CardView) findViewById(R.id.dreamID);
        whiteNoise = (CardView) findViewById(R.id.whitenoiseID);
        about = (CardView) findViewById(R.id.aboutID);
        //adding onlick listeners to the cards
        smartAlarm.setOnClickListener(this);
        dreamJournal.setOnClickListener(this);
        whiteNoise.setOnClickListener(this);
        about.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent;

        switch (view.getId()){
            case R.id.alarmID : intent = new Intent(this,MainActivity.class);startActivity(intent); break;
            case R.id.dreamID : intent = new Intent(this,DreamJournal.class);startActivity(intent);break;
            case R.id.whitenoiseID : intent = new Intent(this,WhiteNoise.class);startActivity(intent);break;
            case R.id.aboutID: intent = new Intent(this,About.class);startActivity(intent);
            //an on click method for each of the cardview objects on the home screen, each tile takes the user to the respective class and xml layout
        }

    }
}
