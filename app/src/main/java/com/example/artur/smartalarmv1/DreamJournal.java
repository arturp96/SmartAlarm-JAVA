package com.example.artur.smartalarmv1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class DreamJournal extends AppCompatActivity {
    private ListView mListViewNotes;
    private static final long serialVersionUID = -8842540672169455970L;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dream_journal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mListViewNotes =(ListView) findViewById(R.id.listview_notes);//create a new instance of listView and parse the listview_notes object from the xml file into it
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_dream, menu);
        return true;// this creates an object from xml resources in this case its the add dream button
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
         switch (item.getItemId()){
             case R.id.action_dream_new_note:
                 Intent newDreamActivity = new Intent(this, DreamActivity.class);
                 startActivity(newDreamActivity);
                 break;
                 //the code above essentially gives the button created above a function
                 //when action_dream_new_note which is a button on the toolbar gets pressed it will get you to the dream activity class where you can add a dream.


         }
         return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        mListViewNotes.setAdapter(null);//setting the adapter to null by default

        ArrayList<Note> dreams = Utilities.getAllSavedNotes(this);

        if(dreams == null || dreams.size() == 0){
            Toast.makeText(this,"You have no dreams saved!",Toast.LENGTH_SHORT).show();// if the dream is opened and there are no dreams then the
                                                                                                    // application will display a toast saying that there are not dreams saved.
            return;
        }else{// if there are notes in the array list
            DreamAdapter da = new DreamAdapter(this, R.layout.item_dream, dreams);// filles out the covert view with notes from the array list
            mListViewNotes.setAdapter(da);

            mListViewNotes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long ld) {
                    String fileName = ((Note)mListViewNotes.getItemAtPosition(position)).getDateTime()
                            + Utilities.FILE_EXTENSION;

                    Intent viewDreamIntent = new Intent(getApplicationContext(), DreamActivity.class);
                    viewDreamIntent.putExtra("DREAM_FILE", fileName);
                    startActivity(viewDreamIntent);
                    // the code above creates an event handler for the notes which allows the user to click any note so they can then either update it or delete it
                }
            });
        }


    }
}
