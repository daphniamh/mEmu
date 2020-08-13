package com.example.memu;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
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
        images.add (1, R.drawable.a2_birke);
        images.add (2, R.drawable.c1_trauerweide);
        images.add (3, R.drawable.c2_trauerweide);
        images.add (4, R.drawable.b1_buche);
        images.add (5, R.drawable.b2_buche);
        images.add (6, R.drawable.d1_eibe);
        images.add (7, R.drawable.d2_eibe);
        images.add (8, R.drawable.e1_rosskastanie);
        images.add (9, R.drawable.e2_rosskastanie);
        images.add(10, R.drawable.f1_eberesche);
        images.add (11, R.drawable.f2_eberesche);
        images.add (12, R.drawable.g1_eiche);
        images.add (13, R.drawable.g2_eiche);
        images.add (14, R.drawable.h1_kiefer);
        images.add (15, R.drawable.h2_kiefer);
        images.add (16, R.drawable.i1_kirschbaum);
        images.add (17, R.drawable.i2_kirschbaum);
        images.add (18, R.drawable.j1_pappel);
        images.add (19, R.drawable.j2_pappel);

        final Button button1,button2, button3, button4, button5, button6, button7,
                button8,button9, button10, button11, button12, button13, button14,
                button15, button16, button17, button18, button19, button20;

        final TextView pair_counter_textfenster, click_counter_textfenster;
        pair_counter_textfenster = (TextView) findViewById(R.id.textView_pair_counter);

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

        final Button[] button_list = {button1, button2, button3, button4, button5, button6,
                button7, button8, button9, button10, button11, button12, button13, button14,
                button15, button16, button17, button18, button19, button20};

        //alle ghosts ersetzen -> durch unbekanntes Bäumchen
        for(int i=0;i<button_list.length;i++) {
            button_list[i].setBackgroundResource(R.drawable.baum_unbekannt);
        }

        Collections.shuffle(images); //Bäume-Bilder werden geshuffelt
        final Integer[] images_list = images.toArray(new Integer[images.size()]); //turn geshuffelte ArrayList into Array

        final String cardback_text = "cardback"; //Karten-Rückseite beschriften
        final String cardback_found_pair = "pair"; //um Pärchen zu markieren

        //final int[] counter_front_back = {0}; //final Array, damit diese Variable in der Click-Methode nutzbar ist, Workaround vorschlag von Android Stuiod -> wird nie benutzt, kann also gelöscht werden?

        //genaueers hier: https://stackoverflow.com/questions/14425826/variable-is-accessed-within-inner-class-needs-to-be-declared-final

        //um zu überprüfen, wann Vorder und Rückseite der Karten zu sehen sind, im Tutorial nimmt man unsichtbaren Buttontext
        for(int i=0;i<button_list.length;i++){
            button_list[i].setText(cardback_text);
            button_list[i].setTextSize(0,0); //macht den ButtonText unsichtbar

            final int loop_counter = i; //final, damit es noch in OnClick-Methode genutzt werden kann

            button_list[i].setOnClickListener(new View.OnClickListener() { //beim Anklicken eines Buttons, wird ein Bild aus der Liste dahinter eingefügt
                @RequiresApi(api = Build.VERSION_CODES.P)
                @Override
                public void onClick(View v) {
                    Button card1 = button_list[loop_counter];

                    if (card1.getText().toString().equals(cardback_text) && turned_2_over == false) {
                        card1.setBackgroundResource(images_list[loop_counter]);
                        card1.setText(images_list[loop_counter].toString());

                        //um Anzahl der umgedrehten Karten zu zählen
                        click_counter++;
                        String click_counter_string = Integer.toString(click_counter);
                        click_counter_textfenster.setText(click_counter_string);

                        if (counter_control_zwei == 0) { //wenn das erste Karte zum Umdrehen ist
                            //für späteren Pärchen-Vergleich speichern
                            card_to_compare = loop_counter;
                        }
                        counter_control_zwei++;
                    } else if (card1.getText().toString() != cardback_text && turned_2_over == true && card1.getText().toString() != cardback_found_pair) {
                        card1.setBackgroundResource(R.drawable.baum_unbekannt);
                        card1.setText(cardback_text); //resource
                        counter_control_zwei--; //wieder zurück, damit neues Pärchen gedreht werden kann
                    }

                    if (counter_control_zwei == 2 && card1.getText().toString() != cardback_found_pair) {
                        turned_2_over = true;
                        //Vergleich der Bild-Texte
                        Button card2 = button_list[card_to_compare];

                        //get Texts from Memory-Cards 1 and 2
                        String card1_text = card1.getText().toString();
                        String card2_text = card2.getText().toString();
                        //Integer card1_text_int =1;
                        //if(card1_text!=cardback_found_pair && card1_text !=cardback_text) {        //wichtig?
                        //    //damit es nicht zum Overflow kommt, wenn die Karte gerade auf Modus pair oder cardBack ist
                        //    card1_text_int = Integer.parseInt(card1_text)- 2131165100;
                        //}
                        //else{
                        //    card1_text_int = 1;
                        //}
                        //Integer card2_text_int;
                        //if(card2_text!="pair" && card2_text !="cardBack"){
                        //    card2_text_int = Integer.parseInt(card2_text)- 2131165100;
                        //}
                        //else{
                        //    card2_text_int = 1;
                        //}

                        //umbenennung nach Baumart  für den Vergleih
                        Log.d("Hashcode1:", card2_text.toString()); //nur für entwicklung, nachher löschen
                        Log.d("Hashcode2:", card1_text.toString()); //nur für entwicklung, nachher löschen

                        card1_text = rename_by_treetype(card1_text); //je nach Datei, wird die Baumsorte benannt
                        card2_text = rename_by_treetype(card2_text);

                        Log.d("Hash_neu1", card2_text); //nur für entwicklung, nachher löschen
                        Log.d("Hash_neu2", card1_text); //nur für entwicklung, nachher löschen

                        String baum_sorte = "kein Paar";
                        if (card1_text == card2_text) {
                            baum_sorte = card1_text;

                            //Erfolg anzeigen
                            Toast myToast = Toast.makeText(getApplicationContext(), baum_sorte, Toast.LENGTH_LONG);
                            myToast.show();

                            //gefundenes Pärchen markieren
                            card1.setText(cardback_found_pair);
                            card1.setTextColor(Color.WHITE);
                            card1.setTextSize(23);

                            card2.setText(cardback_found_pair);
                            card2.setTextColor(Color.WHITE);
                            card2.setTextSize(23);

                            //pair-counter zurücksetzen
                            pair_counter = Integer.parseInt(pair_counter_textfenster.getText().toString());
                            pair_counter--;
                            String counter_string = Integer.toString(pair_counter);
                            pair_counter_textfenster.setText(counter_string);
                            if (pair_counter != 0) { //testweise hinzufgefüft   -> kann gelöscht werden?
                                turned_2_over = false;
                                counter_control_zwei = 0;
                            }
                        }
                    } else if (counter_control_zwei == 0) {
                        turned_2_over = false;
                    }
                    if (pair_counter == 0) {
                        //Spiel-Ende
                        image_gameover.setVisibility(View.VISIBLE);
                        Toast myToast2 = Toast.makeText(getApplicationContext(), "Super, alle gefunden!", Toast.LENGTH_LONG);
                        myToast2.show();
                    }
                    //} //kommt weg, wenn ich Zeile 155 auskommentiere
                    //}}
                }
            }); //diese Klammer + ; ist wichtig!

            }
    }
    //Funktion um Baumsorte zu bestimmen
    String rename_by_treetype(String any_card_text){
        String neuerText=" ";

        switch(any_card_text) {
            case "2131165294" :
            case "2131165295":
                neuerText = "Trauerweide";
                break;
            case "2131165191" :
            case "2131165192" :
                neuerText = "Birke";
                break;
            case "2131165305" :
            case "2131165306" :
                neuerText = "Rosskastanie";
                break;
            case "2131165297" :
            case "2131165298" :
                neuerText = "Eibe";
                break;
            case "2131165281" :
            case "2131165282" :
                neuerText = "Buche";
                break;
            case "2131165317" :
            case "2131165318" :
                neuerText = "Kirsche";
                break;
            case "2131165332" :
            case "2131165333" :
                neuerText = "Pappel";
                break;
            case "2131165315" :
            case "2131165316" :
                neuerText = "Kiefer";
                break;
            case "2131165309" :
            case "2131165310" :
                neuerText = "Eberesche";
                break;
            case "2131165312" :
            case "2131165313" :
                neuerText = "Eiche";
                break;
            case "cardBack" :
                neuerText = "cardBack";
                break;
            case "pair" :
                neuerText = "pair";
                break;
            default :
                neuerText = "noch unbekannt";
        }

        return neuerText;

    }
}

