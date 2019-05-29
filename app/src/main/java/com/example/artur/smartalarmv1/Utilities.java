package com.example.artur.smartalarmv1;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Created by artur on 27/03/2018.
 */

public class Utilities {

    public static final String FILE_EXTENSION = ".bin";// making file_extension as a constant so it can be modified later on
    private static final long serialVersionUID = -8842540672169455970L;
    //the dream are stored in the ".bin" folder which is a binary folder

    public static boolean saveDream(Context context, Note note){
        String fileName = String.valueOf(note.getDateTime())+ FILE_EXTENSION;//this is a unique identifier for each of the notes, it uses the date object from the note class as no two dreams can be created at the same time
        //this is the save mode method, this method need a reference to context, as this talks to the api of the device
        // telling it what to do with the dream file. this class also uses note as an argument since that holds the constructor od the note object which is what the dream is made of.


        FileOutputStream fos;//Creating a FileOutputStream which is a bytes stream class that handles binary data. the FileOutputStream is being assigned to the fos string
        ObjectOutputStream oos;// this converts the serialisation to binary

        try{
            fos=context.openFileOutput(fileName,context.MODE_PRIVATE );//giving the fileOutputstream a filename and context which is stored in private mode, which is a private storage are of the application
            oos = new ObjectOutputStream(fos);// make a new Object output stream and passing the fos variable into it
            oos.writeObject(note);// this is the object we want to write to the note which is the note object as this is the dream that a user creates
            oos.close();//closes the oos
           // fos.close();
        }catch (IOException e){
        e.printStackTrace();
        return false;//false will only be returned if there is no more space on the phone
        }

        return true;
    }

    public static ArrayList<Note> getAllSavedNotes(Context context){//this method return a list of notes
        ArrayList<Note> dreams = new ArrayList<>();// creating a new array list and calling it dreams

        File filesDir = context.getFilesDir();//gets the position of where the notes are bing saved
        ArrayList<String> dreamFiles = new ArrayList<>();//creating a new array list for files that have been saved

        for (String file: filesDir.list()){//for loop to loop through all the files in the files share
            if (file.endsWith(FILE_EXTENSION)){// if the file ends with a file_extension which is .bin then we know that those are the note files that we saved
                dreamFiles.add(file);//if they files do end with the file_extension then they get added to the dreamFiles array list
            }
        }

        FileInputStream fis;
        ObjectInputStream ois;
        //FileInputStream and Object outputstream are used to do the opposite of what the fos and oos variables do which is to deserialize the message from binary into readable note

        for(int i = 0; i< dreamFiles.size(); i++){// this for loop goes through the dreamFiles array
            try{
                fis = context.openFileInput(dreamFiles.get(i));
                ois = new ObjectInputStream(fis);
                dreams.add((Note)ois.readObject());

                fis.close();
                ois.close();
                //makes the note from binary into readable text and then closes the fis and ois

            }catch(IOException | ClassNotFoundException e){
                e.printStackTrace();
                return null;
            }

        }
        return dreams;

    }
    public static Note getDreamByName(Context context, String fileName){
        File file = new File(context.getFilesDir(), fileName);
        Note note;

        if(file.exists()){
           FileInputStream fis;
           ObjectInputStream ois;

           try{
                fis = context.openFileInput(fileName);
                ois = new ObjectInputStream(fis);

                note = (Note) ois.readObject();

                fis.close();
                ois.close();

           }catch(IOException | ClassNotFoundException e){
               e.printStackTrace();
               return null;

           }
           return note;
           //the method above gets a specific note file from the .bin folder so that it can be either updates or deleted by the user.
        }
        return null;
    }

    public static void deleteDream(Context context, String fileName) {
        File dir = context.getFilesDir();// gets the context of a specific note/dream
        File file  = new File(dir, fileName);
        if (file.exists()){
            file.delete();
            //the code above deletes the note object from the devices memory
        }
    }
}
