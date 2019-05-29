package com.example.artur.smartalarmv1;

import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;


public class WhiteNoise extends AppCompatActivity {

    private ArrayList<Music> arrayList;// creating a new arrayList
    private CustomMusicAdapter adapter ;//creating a new custom adapter
    private ListView songList;//creating a new Listview variable
    RelativeLayout myLayout;//creating a new relativeLayout variable
    AnimationDrawable animationDrawable;//creating a new animationDrawable variable





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_white_noise);
        myLayout = (RelativeLayout) findViewById(R.id.myLayout);// parsing the myLayout object from the activity_white_noise.xml file into the myLayout variable in this class
        animationDrawable = (AnimationDrawable) myLayout.getBackground();//gets background from the myLayout.getbackground
        animationDrawable.setEnterFadeDuration(4500);//how long the entrance duration lasts
        animationDrawable.setExitFadeDuration(4500);//how lond the exit duration lasts
        animationDrawable.start();//that the animation
        //the code above takes free previous backgrounds and plays them one by one in a specific order giving the fade effect. this is purely done for cosmetics


        songList = (ListView) findViewById(R.id.songList);//inputs the listView object called songList from the xml file and parses it into the songList variable of this class
        arrayList = new ArrayList<>();// initialize an array list
        arrayList.add(new Music("White Noise","Static",R.raw.whitenoise));
        arrayList.add(new Music("Brown Noise","Static",R.raw.brownnoise));
        arrayList.add(new Music("Violet Noise","Static",R.raw.violetnoise));
        arrayList.add(new Music("Rain","Nature",R.raw.rain));
        arrayList.add(new Music("Jungle","Nature",R.raw.jungle));
        arrayList.add(new Music("Camp Fire","Nature",R.raw.campfire));
        arrayList.add(new Music("Lake","Nature",R.raw.lake));
        arrayList.add(new Music("Ice Cracking","Nature",R.raw.icecracking));
        arrayList.add(new Music("River","Nature",R.raw.river));
        arrayList.add(new Music("Water Drop","Nature",R.raw.waterdripping));
        arrayList.add(new Music("Wind Howl","Nature",R.raw.windhowl));
        arrayList.add(new Music("Singing Birds","Nature",R.raw.birds));
        // this array list takes 3 objects from the Music class and creates a new instance of it. This process is repeated for every sound file in the white noise feature

        //arrayList





        adapter = new CustomMusicAdapter(this, R.layout.custom_music_item, arrayList);// the adapter variable is fed the white noise activity the custom_music_layout and array list of this class
        songList.setAdapter(adapter);//the adapter is given into the songList listView variable. Essentially this puts all the functionality of the adapter into the ListView for a user to interact with.

    }
}
