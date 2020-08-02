package com.example.memu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import android.util.Log;


public class TreeMemory extends AppCompatActivity  {
    public int counter_control_zwei = 0; //global?
    public int clicked = 0;
    public boolean turned_2_over = false;
    public int card_to_compare;
    public int pair_counter = 10;
    public int click_counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory);


        Intent intent = getIntent(); //gets the intent that started this activity

        //meine Programmcode-Beginn

        final ArrayList<Integer> images = new ArrayList<Integer>(10);
        images.add(0, R.drawable.a1_birke);
        images.add (1, R.drawable.a1_birke);
        images.add (2, R.drawable.a1_birke); //weiße
        images.add (3, R.drawable.a1_birke);
        images.add (4, R.drawable.a1_birke);
        images.add (5, R.drawable.a2_birke); //gelbe
        images.add (6, R.drawable.a2_birke);
        images.add (7, R.drawable.a2_birke);
        images.add (8, R.drawable.a2_birke);
        images.add (9, R.drawable.a2_birke);
        images.add(10, R.drawable.a2_birke);
        images.add (11, R.drawable.b2_trauerweide);
        images.add (12, R.drawable.b2_trauerweide);
        images.add (13, R.drawable.b2_trauerweide);
        images.add (14, R.drawable.b2_trauerweide);
        images.add (15, R.drawable.b1_trauerweide);
        images.add (16, R.drawable.b2_trauerweide);
        images.add (17, R.drawable.b1_trauerweide);
        images.add (18, R.drawable.b1_trauerweide);
        images.add (19, R.drawable.b1_trauerweide);

        final Button button1,button2, button3, button4, button5, button6, button7,
                button8,button9, button10, button11, button12, button13, button14,
                button15, button16, button17, button18, button19, button20;

        final TextView pair_counter_textfenster, click_counter_textfenster;
        pair_counter_textfenster = (TextView) findViewById(R.id.textView_pair_counter); //redundant?

        final ImageView image_gameover;
        image_gameover = (ImageView) findViewById(R.id.image_gameover);

        click_counter_textfenster = (TextView) findViewById(R.id.textView_click_counter);

        button1 = (Button) findViewById(R.id.button_ghost1);
        button2 = (Button) findViewById(R.id.button_ghost2);
        button3 = (Button) findViewById(R.id.button_ghost3);
        button4 = (Button) findViewById(R.id.button_ghost4);
        button5 = (Button) findViewById(R.id.button_ghost5);
        button6 = (Button) findViewById(R.id.button_ghost6);
        button7 = (Button) findViewById(R.id.button_ghost7);
        button8 = (Button) findViewById(R.id.button_ghost8);
        button9 = (Button) findViewById(R.id.button_ghost9);
        button10 = (Button) findViewById(R.id.button_ghost10);
        button11 = (Button) findViewById(R.id.button_ghost11);
        button12 = (Button) findViewById(R.id.button_ghost12);
        button13 = (Button) findViewById(R.id.button_ghost13);
        button14 = (Button) findViewById(R.id.button_ghost14);
        button15 = (Button) findViewById(R.id.button_ghost15);
        button16 = (Button) findViewById(R.id.button_ghost16);
        button17 = (Button) findViewById(R.id.button_ghost17);
        button18 = (Button) findViewById(R.id.button_ghost18);
        button19 = (Button) findViewById(R.id.button_ghost19);
        button20 = (Button) findViewById(R.id.button_ghost20);

        final Button[] button_list = {button1, button2, button3, button4, button5, button6, //auch weg?
                button7, button8, button9, button10, button11, button12, button13, button14,
                button15, button16, button17, button18, button19, button20};
        //nachfolgender Absatz kann gelöscht werden, wenn alles soweit funktioniert
        //final Integer[] images_list1 = {R.drawable.a1_birke, R.drawable.a1_birke, R.drawable.a2_birke,
            //    R.drawable.a2_birke,R.drawable.a2_birke,R.drawable.a2_birke, R.drawable.a2_birke,
           //     R.drawable.a2_birke, R.drawable.a2_birke};


        //alle ghosts ersetzen -> durch Bäumchen
        for(int i=0;i<button_list.length;i++) {

            button_list[i].setBackgroundResource(R.drawable.baum_unbekannt); //weiter unten gibt es auch eine stelle
        }

        Collections.shuffle(images); //Bilder werden geshuffelt
        final Integer[] images_list = images.toArray(new Integer[images.size()]); //turn geshuffelte ArrayList into Array

        final int[] counter_front_back = {0}; //final Array, damit diese Variable in der Click-Methode nutzbar ist, Workaround vorschlag von Android Stuiod -> wird nie benutzt, kann also gelöscht werden?
        //genaueers hier: https://stackoverflow.com/questions/14425826/variable-is-accessed-within-inner-class-needs-to-be-declared-final
        //um zu überprüfen, wann Vorder und Rückseite der Karten zu sehen sind, im Tutorial nimmt man unsichtbaren Buttontext


        for(int i=0;i<button_list.length;i++){

            button_list[i].setText("cardBack"); //durch nachfolgende Zeile ersetzt
            //button_list[i].setText(R.string.card_back);
            button_list[i].setTextSize(0,0); //macht den ButtonText unsichtbar

            final int loop_counter = i; //final, damit es noch iin OnClick-Methode genutzt werden kann

            button_list[i].setOnClickListener(new View.OnClickListener() { //beim Anklicken eines Buttons, wird ein Bild aus der Liste dahinter eingefügt
                @Override
                public void onClick(View v) {


                    Button card1 = button_list[loop_counter];

                    if(card1.getText().toString() =="cardBack" && turned_2_over == false) {
                        card1.setBackgroundResource(images_list[loop_counter]);
                        card1.setText(images_list[loop_counter].toString());

                        //um Anzahl der umgedrehten Karten zu zählen
                        click_counter++;
                        String click_counter_string = Integer.toString(click_counter);
                        click_counter_textfenster.setText(click_counter_string);

                        if (counter_control_zwei == 0){ //wenn das erste Karte zum Umdrehen ist
                            //für späteren Pärchen-Vergleich speichern
                            card_to_compare = loop_counter;
                        }
                        counter_control_zwei++;

                    }
                    else if(card1.getText().toString() != "cardBack" && turned_2_over == true && card1.getText().toString() != "pair" ){
                        card1.setBackgroundResource(R.drawable.baum_unbekannt);

                        card1.setText("cardBack"); //resource

                        counter_control_zwei--; //wieder zurück, damit neues Pärchen gedreht werden kann
                    }

                    if (counter_control_zwei ==2 && card1.getText().toString() != "pair"){
                        turned_2_over = true;
                        //Vergleich der Bild-Texte
                        Button card2 = button_list[card_to_compare];

                        //get Texts from Memory-Cards 1 and 2
                        Integer card1_text = Integer.parseInt(card1.getText().toString())- 2131165100;
                        Integer card2_text = Integer.parseInt(card2.getText().toString())- 2131165100;
                        Log.d("Hashcode1:", card1_text.toString()); //nur für entwicklung, nachher löschen
                        Log.d("Hashcode2:", card2_text.toString()); //nur für entwicklung, nachher löschen


                        //if(card1_text.equals(card2_text)){
                        Integer card_summe = card1_text+card2_text;
                        if(card_summe==183 ||  card_summe == 363 ){
                            //Erfolg anzeigen
                            Toast myToast = Toast.makeText(getApplicationContext(),
                                    "Eibe!", Toast.LENGTH_LONG);
                            myToast.show();

                            //gefundenes Pärchen markieren
                            card1.setText("pair"); //durch String-Resource ersetzten
                            card1.setTextColor(Color.WHITE);
                            card1.setTextSize(23);

                            card2.setText("pair");
                            card2.setTextSize(23);
                            card2.setTextColor(Color.WHITE);

                            pair_counter = Integer.parseInt(pair_counter_textfenster.getText().toString());
                            pair_counter--;
                            String counter_string = Integer.toString(pair_counter);
                            pair_counter_textfenster.setText(counter_string);
                            turned_2_over = false;
                            counter_control_zwei=0;
                        }
                    }
                    else if(counter_control_zwei ==0){
                        turned_2_over = false;
                    }
                    if(pair_counter == 0){
                        //Spiel-Ende
                        image_gameover.setVisibility(View.VISIBLE);
                        Toast myToast = Toast.makeText(getApplicationContext(),"Super, alle gefunden!", Toast.LENGTH_LONG);
                        myToast.show();

                    }
                }
            }); //diese Klammer + ; ist wichtig!

        }

        //VideoMinute 40.48 min
        //https://www.youtube.com/watch?v=BGvjScKcW1s


    }
}
