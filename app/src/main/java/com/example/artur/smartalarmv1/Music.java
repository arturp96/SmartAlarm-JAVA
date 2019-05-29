package com.example.artur.smartalarmv1;

/**
 * Created by artur on 19/04/2018.
 */

public class Music {
    private String name;// new String variable which will be used to show the name of the sound being played
    private String artist;//new String variable which will be used to show the type of sound being played
    private int song;//creating a new song variable which will hold the sound file inside the array list.

    //private int wallpaper;

    public Music(String name, String artist, int song)  {
        this.name = name;
        this.artist = artist;
        this.song = song;
        //making all the previous variables public so it can be used by the White noise class inside the array.

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getSong() {
        return song;
    }

    public void setSong(int song) {
        this.song = song;
    }

    //Getters and setters are used to encapsulate the fields in the Music class so that they are accessible for other classes to be used while keeping the values it self private so they cant be changed.



}
