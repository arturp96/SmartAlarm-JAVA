package com.example.artur.smartalarmv1;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;

public class puzzleGame extends MainActivity {

    private static final long serialVersionUID = -8842540672169455970L;
    ImageView iv_11, iv_12,  iv_13, iv_14, iv_21, iv_22, iv_23, iv_24,  iv_31, iv_32, iv_33, iv_34, iv_41, iv_42, iv_43, iv_44;
    //creating new imageView variables


    Integer[] cardsArray = {101, 102, 103, 104, 105, 106,107,108, 201, 202, 203, 204, 205, 206,207,208};
    //creating a new array list for the images


    int image101, image102, image103, image104, image105, image106, image107, image108, image201, image202, image203, image204, image205, image206, image207, image208;
    //importing the actual images used in the memory game

    int firstCard, secondCard;
    //creating two new variables, since this is a memory game two of the same card need to be flipped and compared
    int clickedFirst, clickedSecond;
    //creating new variables for when the two cards have actually been clicked
    int cardNumber = 1;
    //creating a variable called card Number and setting its default value to 1
//    int turn = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle_game);




        iv_11 = (ImageView) findViewById(R.id.iv_11);
        iv_12 = (ImageView) findViewById(R.id.iv_12);
        iv_13 = (ImageView) findViewById(R.id.iv_13);
        iv_14 = (ImageView) findViewById(R.id.iv_14);
        iv_21 = (ImageView) findViewById(R.id.iv_21);
        iv_22 = (ImageView) findViewById(R.id.iv_22);
        iv_23 = (ImageView) findViewById(R.id.iv_23);
        iv_24 = (ImageView) findViewById(R.id.iv_24);
        iv_31 = (ImageView) findViewById(R.id.iv_31);
        iv_32 = (ImageView) findViewById(R.id.iv_32);
        iv_33 = (ImageView) findViewById(R.id.iv_33);
        iv_34 = (ImageView) findViewById(R.id.iv_34);
        iv_41 = (ImageView) findViewById(R.id.iv_41);
        iv_42 = (ImageView) findViewById(R.id.iv_42);
        iv_43 = (ImageView) findViewById(R.id.iv_43);
        iv_44 = (ImageView) findViewById(R.id.iv_44);
        //initializing all of the imagesViews and passing the corresponding images to it

        iv_11.setClickable(true);
        iv_12.setClickable(true);
        iv_13.setClickable(true);
        iv_14.setClickable(true);
        iv_21.setClickable(true);
        iv_22.setClickable(true);
        iv_23.setClickable(true);
        iv_24.setClickable(true);
        iv_31.setClickable(true);
        iv_32.setClickable(true);
        iv_33.setClickable(true);
        iv_34.setClickable(true);
        iv_41.setClickable(true);
        iv_42.setClickable(true);
        iv_43.setClickable(true);
        iv_44.setClickable(true);
        //setting all of the image views as true which is how the program will detect whether an image has been pressed by the user
        iv_11.setTag("0");
        iv_12.setTag("1");
        iv_13.setTag("2");
        iv_14.setTag("3");
        iv_21.setTag("4");
        iv_22.setTag("5");
        iv_23.setTag("6");
        iv_24.setTag("7");
        iv_31.setTag("8");
        iv_32.setTag("9");
        iv_33.setTag("10");
        iv_34.setTag("11");
        iv_41.setTag("12");
        iv_42.setTag("13");
        iv_43.setTag("14");
        iv_44.setTag("15");
        //giving each of the imagesViews a a tag.




        frontOfCardsResources();
        //load the card images

        //shuffle the images
        Collections.shuffle(Arrays.asList(cardsArray));
        //this shuffles the array of images randomly every time the puzzleGame class is run, so that a user cant just remember the positions of the cards.



        iv_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                //creating a new int variable called theCard and parsing it as a String as well as passing in the get getTag variable so i could then create a separate onclick listener for each of the cards
                doStuff(iv_11, theCard);
                //imports the logic of the do Stuff method bellow into the correct image and theCard Variable


            }
        });

        iv_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_12, theCard);

            }
        });

        iv_13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_13, theCard);

            }
        });

        iv_14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_14, theCard);

            }
        });

        iv_21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_21, theCard);

            }
        });

        iv_22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_22, theCard);

            }
        });

        iv_23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_23, theCard);

            }
        });

        iv_24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_24, theCard);

            }
        });
        iv_31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_31, theCard);

            }
        });
        iv_32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_32, theCard);

            }
        });
        iv_33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_33, theCard);

            }
        });
        iv_34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_34, theCard);

            }
        });
        iv_41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_41, theCard);

            }
        });
        iv_42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_42, theCard);

            }
        });
        iv_43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_43, theCard);

            }
        });
        iv_44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_44, theCard);

            }
        });


    }
    private void doStuff(ImageView iv, int card){
        //setting the correct image to the correct imageView
        if (cardsArray[card] == 101){
            iv.setImageResource(image101);
        }else if (cardsArray[card] == 102){
            iv.setImageResource(image102);
        }else if (cardsArray[card] == 103){
            iv.setImageResource(image103);
        }else if (cardsArray[card] == 104){
            iv.setImageResource(image104);
        }else if (cardsArray[card] == 105){
            iv.setImageResource(image105);
        }else if (cardsArray[card] == 106){
            iv.setImageResource(image106);
        }else if (cardsArray[card] == 107){
            iv.setImageResource(image107);
        }else if (cardsArray[card] == 108){
            iv.setImageResource(image108);
        }else if (cardsArray[card] == 201){
            iv.setImageResource(image201);
        }else if (cardsArray[card] == 202){
            iv.setImageResource(image202);
        }else if (cardsArray[card] == 203){
            iv.setImageResource(image203);
        }else if (cardsArray[card] == 204){
            iv.setImageResource(image204);
        }else if (cardsArray[card] == 205){
            iv.setImageResource(image205);
        }
        else if (cardsArray[card] == 206){
            iv.setImageResource(image206);
        }
        else if (cardsArray[card] == 207){
            iv.setImageResource(image207);
        }
        else if (cardsArray[card] == 208){
            iv.setImageResource(image208);
        }

        if (cardNumber == 1){//checking if the cardNumber variable is equal to 1
            firstCard = cardsArray[card];// the first card a user clicked is taken from the array of cards and assigned to the first card variable
            if(firstCard > 200){// this if statement checks if the firsCard variable is greater then 200. Half of the cards in the array are greater and half are less then that
                firstCard = firstCard - 100;// if its true take away a 100 from the value of the first Card
            }
            cardNumber = 2;// set cardnumber to 2
            clickedFirst = card;// assign the card from the array list to the clicked first variable which lets the program know that the first card has been clicked.

            iv.setEnabled(false);

            }else if(cardNumber == 2){//checking if the cardNumber variable is equal to 2
            secondCard = cardsArray[card];// the second card a user clicked is taken from the array of cards and assigned to the first card variable
            if(secondCard > 200){// this if statement checks if the firsCard variable is greater then 200.
                secondCard = secondCard - 100;// if its true take away a 100 from the value of the first Card
            }
            cardNumber = 1;
            clickedSecond = card;
            //check which image is selected and save it to temporary variable for the second card which is clicked

            iv_11.setEnabled(false);
            iv_12.setEnabled(false);
            iv_13.setEnabled(false);
            iv_14.setEnabled(false);
            iv_21.setEnabled(false);
            iv_22.setEnabled(false);
            iv_23.setEnabled(false);
            iv_24.setEnabled(false);
            iv_31.setEnabled(false);
            iv_32.setEnabled(false);
            iv_33.setEnabled(false);
            iv_34.setEnabled(false);
            iv_41.setEnabled(false);
            iv_42.setEnabled(false);
            iv_43.setEnabled(false);
            iv_44.setEnabled(false);

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    calculate();
                }
            }, 1000);
            //the code above checks if the two cards selected are equal

        }
    }

    private void calculate(){

        if (firstCard == secondCard){
            if(clickedFirst == 0){
                iv_11.setVisibility(View.INVISIBLE);
            }else if(clickedFirst == 1){
                iv_12.setVisibility(View.INVISIBLE);
            }
            else if(clickedFirst == 2){
                iv_13.setVisibility(View.INVISIBLE);
            }
            else if(clickedFirst == 3){
                iv_14.setVisibility(View.INVISIBLE);
            }
            else if(clickedFirst == 4){
                iv_21.setVisibility(View.INVISIBLE);
            }
            else if(clickedFirst == 5){
                iv_22.setVisibility(View.INVISIBLE);
            }
            else if(clickedFirst == 6){
                iv_23.setVisibility(View.INVISIBLE);
            }
            else if(clickedFirst == 7){
                iv_24.setVisibility(View.INVISIBLE);
            }
            else if(clickedFirst == 8){
                iv_31.setVisibility(View.INVISIBLE);
            }
            else if(clickedFirst == 9){
                iv_32.setVisibility(View.INVISIBLE);
            }
            else if(clickedFirst == 10){
                iv_33.setVisibility(View.INVISIBLE);
            }
            else if(clickedFirst == 11){
                iv_34.setVisibility(View.INVISIBLE);
            }
            else if(clickedFirst == 12){
                iv_41.setVisibility(View.INVISIBLE);
            }
            else if(clickedFirst == 13){
                iv_42.setVisibility(View.INVISIBLE);
            }
            else if(clickedFirst == 14){
                iv_43.setVisibility(View.INVISIBLE);
            }
            else if(clickedFirst == 15){
                iv_44.setVisibility(View.INVISIBLE);
            }

            if(clickedSecond == 0){
                iv_11.setVisibility(View.INVISIBLE);
            }else if(clickedSecond == 1){
                iv_12.setVisibility(View.INVISIBLE);
            }
            else if(clickedSecond == 2){
                iv_13.setVisibility(View.INVISIBLE);
            }
            else if(clickedSecond == 3){
                iv_14.setVisibility(View.INVISIBLE);
            }
            else if(clickedSecond == 4){
                iv_21.setVisibility(View.INVISIBLE);
            }
            else if(clickedSecond == 5){
                iv_22.setVisibility(View.INVISIBLE);
            }
            else if(clickedSecond == 6){
                iv_23.setVisibility(View.INVISIBLE);
            }
            else if(clickedSecond == 7){
                iv_24.setVisibility(View.INVISIBLE);
            }
            else if(clickedSecond == 8){
                iv_31.setVisibility(View.INVISIBLE);
            }
            else if(clickedSecond == 9){
                iv_32.setVisibility(View.INVISIBLE);
            }
            else if(clickedSecond == 10){
                iv_33.setVisibility(View.INVISIBLE);
            }
            else if(clickedSecond == 11){
                iv_34.setVisibility(View.INVISIBLE);
            }
            else if(clickedSecond == 12){
                iv_41.setVisibility(View.INVISIBLE);
            }
            else if(clickedSecond == 13){
                iv_42.setVisibility(View.INVISIBLE);
            }
            else if(clickedSecond == 14){
                iv_43.setVisibility(View.INVISIBLE);
            }
            else if(clickedSecond == 15){
                iv_44.setVisibility(View.INVISIBLE);
            }
            //if the two images inside the first and second card are equal then they become invisible, essentially when a user matches a card then they diseapear if they do it with all the cards the game ends.



            }else{
            iv_11.setImageResource(R.drawable.id_back);
            iv_12.setImageResource(R.drawable.id_back);
            iv_13.setImageResource(R.drawable.id_back);
            iv_14.setImageResource(R.drawable.id_back);
            iv_21.setImageResource(R.drawable.id_back);
            iv_22.setImageResource(R.drawable.id_back);
            iv_23.setImageResource(R.drawable.id_back);
            iv_24.setImageResource(R.drawable.id_back);
            iv_31.setImageResource(R.drawable.id_back);
            iv_32.setImageResource(R.drawable.id_back);
            iv_33.setImageResource(R.drawable.id_back);
            iv_34.setImageResource(R.drawable.id_back);
            iv_41.setImageResource(R.drawable.id_back);
            iv_42.setImageResource(R.drawable.id_back);
            iv_43.setImageResource(R.drawable.id_back);
            iv_44.setImageResource(R.drawable.id_back);

            //if the two cards chosen were not equal then the two cards have their image resource changed to a backcard, as if they were flipped

        }
        iv_11.setEnabled(true);
        iv_12.setEnabled(true);
        iv_13.setEnabled(true);
        iv_14.setEnabled(true);
        iv_21.setEnabled(true);
        iv_22.setEnabled(true);
        iv_23.setEnabled(true);
        iv_24.setEnabled(true);
        iv_31.setEnabled(true);
        iv_32.setEnabled(true);
        iv_33.setEnabled(true);
        iv_34.setEnabled(true);
        iv_41.setEnabled(true);
        iv_42.setEnabled(true);
        iv_43.setEnabled(true);
        iv_44.setEnabled(true);


        checkEnd();
        //check if the game is over
    }
    private void checkEnd(){
        if(iv_11.getVisibility() == View.INVISIBLE &&
                iv_12.getVisibility() == View.INVISIBLE &&
                iv_13.getVisibility() == View.INVISIBLE &&
                iv_14.getVisibility() == View.INVISIBLE &&
                iv_21.getVisibility() == View.INVISIBLE &&
                iv_22.getVisibility() == View.INVISIBLE &&
                iv_23.getVisibility() == View.INVISIBLE &&
                iv_24.getVisibility() == View.INVISIBLE &&
                iv_31.getVisibility() == View.INVISIBLE &&
                iv_32.getVisibility() == View.INVISIBLE &&
                iv_33.getVisibility() == View.INVISIBLE &&
                iv_34.getVisibility() == View.INVISIBLE &&
                iv_41.getVisibility() == View.INVISIBLE &&
                iv_42.getVisibility() == View.INVISIBLE &&
                iv_43.getVisibility() == View.INVISIBLE &&
                iv_44.getVisibility() == View.INVISIBLE ){

                //method that updates text on the timepicker interface informing the user that the alarm has been turned off
                set_alarm_text("alarm off!");

                try{
                alarm_manager.cancel(pending_intent);
                }catch(Exception e){
                e.printStackTrace();
                }
                //cancels the pending intent which turns off the sound of the alarm

            //put extra string into my _intent
            //tells the clock that you pressed the "alarm off"
            my_intent.putExtra("extra", "Alarm off");

            //stops the ringtone
            sendBroadcast(my_intent);
            innit();




        }
    }

    private void frontOfCardsResources(){

        image101 = R.drawable.id_image101;
        image102 = R.drawable.id_image102;
        image103 = R.drawable.id_image103;
        image104 = R.drawable.id_image104;
        image105 = R.drawable.id_image105;
        image106 = R.drawable.id_image106;
        image107 = R.drawable.id_image107;
        image108 = R.drawable.id_image108;
        image201 = R.drawable.id_image201;
        image202 = R.drawable.id_image202;
        image203 = R.drawable.id_image203;
        image204 = R.drawable.id_image204;
        image205 = R.drawable.id_image205;
        image206 = R.drawable.id_image206;
        image207 = R.drawable.id_image207;
        image208 = R.drawable.id_image208;
        // puts the correct image file into a variable which is used in the code


    }
    public void innit(){
        Intent alarmOff1 = new Intent(puzzleGame.this, MainActivity.class);
        startActivity(alarmOff1);
        //this method creates a new Intent and when its called in the method above the application goes back to the Main activity class which contains the time picker
    }


}
