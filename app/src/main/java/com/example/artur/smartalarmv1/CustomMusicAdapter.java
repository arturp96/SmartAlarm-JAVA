package com.example.artur.smartalarmv1;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by artur on 19/04/2018.
 */

public class CustomMusicAdapter extends BaseAdapter{

    private Context context; //create a new context variable
    private int layout;// creating a new int variable called layout
    private ArrayList<Music> arrayList;// using the music array list from the white noise class
    private MediaPlayer mediaPlayer;//crating a new Media player
    private Boolean running = true; //creating a new bool variable and setting its original state as true;




    public CustomMusicAdapter(Context context, int layout, ArrayList<Music> arrayList) {
        this.context = context;
        this.layout = layout;
        this.arrayList = arrayList;
        //making the following variables public so they can be accessed somewhere else


    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class ViewHolder{
        TextView txtName,txtArtist;//creating new instances of TextView
        ImageView ivPlay,ivStop;//creating new instances of ImageView

    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;// creating a new viewHolder variable
        //a view holder is used to help speed up the rendering of the list view used
        if(convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //the LayoutInflater class is used to instantiate layout XML file into its corresponding View objects.
            //In other words, it takes as input an XML file and builds the View objects from it.
            convertView = layoutInflater.inflate(layout, null);
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.txtName);
            viewHolder.txtArtist = (TextView) convertView.findViewById(R.id.txtArtist);
            viewHolder.ivPlay =  convertView.findViewById(R.id.ivPlay);
            //viewHolder.ivStop =  convertView.findViewById(R.id.ivStop);
            //the code above passes the corresponding object from the xml file into the correct variables created in this class

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }


        final Music music = arrayList.get(position);// this gets the specific position of each of the object inside the array
        // objects in the array list. without this code the program would play one sound file for all the object inside the array list
        viewHolder.txtName.setText(music.getName());
        viewHolder.txtArtist.setText(music.getArtist());
        //put the name and artist from teh music class inot the viewHolder object


        //play music
        final View ConvertView = convertView;
        viewHolder.ivPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (running){mediaPlayer = MediaPlayer.create(context,music.getSong());// if the running bool value is true then create a new instance of a mediaplayer
                running = false;// set the running bool value to false
                }
                if (mediaPlayer.isPlaying()){

                    viewHolder.ivPlay.setImageResource(R.drawable.ic_play2);
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    running = true;
                    // if the media player is currently running the following code when called with stop the media player

                }else{
                    viewHolder.ivPlay.setImageResource(R.drawable.ic_stop2);
                    mediaPlayer.setLooping(true);
                    mediaPlayer.start();
                    // if media player is not playing the the code above will start the media player.
                }

            }
        });


            return convertView;
    }
}
