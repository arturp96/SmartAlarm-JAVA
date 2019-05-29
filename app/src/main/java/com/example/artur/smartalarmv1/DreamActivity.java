package com.example.artur.smartalarmv1;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class DreamActivity extends AppCompatActivity {
    private static final long serialVersionUID = -8842540672169455970L;//

    private EditText mEtTitle;//creating a new Edit text variable for a title
    private EditText mEtContent;//creating a new edit text variable for the content

    private String mFileName;
    private Note mLoadedNote = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dream);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



    mEtTitle = (EditText) findViewById(R.id.dream_et_title);//casting mEtTtile variable to to an object from the xml file
    mEtContent =(EditText) findViewById(R.id.dream_et_content);//casting the mEtContent variable to an object from the xml file

    mFileName = getIntent().getStringExtra("DREAM_FILE");
    if(mFileName != null && !mFileName.isEmpty()){
        mLoadedNote= Utilities.getDreamByName(this, mFileName);

        if(mLoadedNote != null){
            mEtTitle.setText(mLoadedNote.getTitle());
            mEtContent.setText(mLoadedNote.getContent());
        }
    }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_dream1_new, menu);
        return true;
        // this creates an object from xml resources in this case its the add dream button
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.action_dream_save:
                saveDream();

            case R.id.action_dream_delete:
                deleteDream();

                break;
            //the code above essentially gives the buttons created above a function
            //when the action_dream_save button gets pressed the currently dream file open is saved
            // when the action_dream_delete gets pressed the selected dream is deleted

        }

        return true;
    }



    private void saveDream(){
        Note note;
        if(mLoadedNote == null) {
             note = new Note(System.currentTimeMillis(), mEtTitle.getText().toString()
                    , mEtContent.getText().toString());//calling the note object from the note class and taking the time of when the note was saved as well as the text from the user and casting it to a string
        }else{
             note = new Note(mLoadedNote.getDateTime(), mEtTitle.getText().toString()
                    , mEtContent.getText().toString());//this else statement is executed when a user presses on a note that was previously created.

        }
            if(Utilities.saveDream(this, note)){
                Toast.makeText(this, "Dream is saved",Toast.LENGTH_SHORT).show();
                //calling the saveDream method in the Utilities class so that the note object can be saved.

        }else{
            Toast.makeText(this, "Cannot save the dream, please make sure you have enough spave on your device", Toast.LENGTH_SHORT).show();
        }
        finish();// if the dream cannot be saved this message will be executed

    }

    private void deleteDream() {
        if(mLoadedNote ==null){
            finish();//if there is no note then the deleteDream method gets closed

        }else{
            AlertDialog.Builder dialog = new AlertDialog.Builder(this)
                    .setTitle("Are you sure you want to remove this dream?")
                    .setMessage("You are about to delete " + mEtTitle.getText().toString() + "Are you sure?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Utilities.deleteDream(getApplicationContext()
                                    ,mLoadedNote.getDateTime()+ Utilities.FILE_EXTENSION);
                            Toast.makeText(getApplicationContext(), mEtTitle.getText().toString()+ "is deleted!",Toast.LENGTH_SHORT).show();
                            finish();
                            //if the user does load a note and presses the delete button they will get an alert dialog asking if they want to remove it
                            //the alert dialog has two buttons one for yes which when pressed deletes the dream and one for no which goes back to the previously loaded dream
                        }
                    })
                    .setNegativeButton("No", null)
                    .setCancelable(false);

            dialog.show();// shows the dialog ig the else statement is run


        }
    }
}
