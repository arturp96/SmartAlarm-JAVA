package com.example.artur.smartalarmv1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by artur on 27/03/2018.
 */

public class DreamAdapter extends ArrayAdapter <Note>{//the array will store the note object
    private static final long serialVersionUID = -8842540672169455970L;
    public DreamAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Note> dreams) {
        super(context, resource, dreams);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        if (convertView == null){//checking if convertview is null
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.item_dream, null);// if it is then a new convert view is built
        }

        Note note = getItem(position);//getting the position of the note object from the note class and allocating a position for a note in the list view
        if(note != null){
            TextView title = (TextView) convertView.findViewById(R.id.list_dream_title);
            TextView date = (TextView) convertView.findViewById(R.id.list_dream_date);
            TextView content = (TextView) convertView.findViewById(R.id.list_dream_content);
            //if the note is not null then the note object gets created and put into the respective textview

            title.setText(note.getTitle());//getting the title from the note object and casting it into title.setText
            date.setText(note.getDateTimeFormated(getContext()));

            if(note.getContent().length() > 50){
                content.setText(note.getContent().substring(0,50));//if the content of the note is more then 50 then show only the first 50 characters
            }else{
                content.setText(note.getContent());//if there is less then 50 then just show the whole message in the listview
            }
        }
        return convertView;
    }
}
