package com.example.memu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Collections;

public class AnimalMemory extends AppCompatActivity {

    public int counter_controll_zwei = 0; //global?
    public int clicked = 0;
    public boolean turned_2_over = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_memory);

        Intent intent = getIntent(); //gets the intent that started this activity

        //meine Programmcode-Beginn

        ArrayList<Integer> images = new ArrayList<Integer>(10);
        images.add(0, R.drawable.bat);
        images.add (1, R.drawable.bee);
        images.add (2, R.drawable.coala);
        images.add (3, R.drawable.eagle);
        images.add (4, R.drawable.elephant);
        images.add (5, R.drawable.penguin);
        images.add (6, R.drawable.shark);
        images.add (7, R.drawable.sheep);
        images.add (8, R.drawable.spider);
        images.add (9, R.drawable.turtle);
        images.add(10, R.drawable.bat);
        images.add (11, R.drawable.bee);
        images.add (12, R.drawable.coala);
        images.add (13, R.drawable.eagle);
        images.add (14, R.drawable.elephant);
        images.add (15, R.drawable.penguin);
        images.add (16, R.drawable.shark);
        images.add (17, R.drawable.sheep);
        images.add (18, R.drawable.spider);
        images.add (19, R.drawable.turtle);

        Button button1,button2, button3, button4, button5, button6, button7,
                button8,button9, button10, button11, button12, button13, button14,
                button15, button16, button17, button18, button19, button20;

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
        final Integer[] images_list1 = {R.drawable.bat, R.drawable.coala, R.drawable.elephant,  //kann weg?
                                 R.drawable.fox, R.drawable.turtle,
                R.drawable.bat, R.drawable.coala, R.drawable.elephant,
                R.drawable.fox, R.drawable.turtle };


        Collections.shuffle(images); //Bilder werden geshuffelt
        final Integer[] images_list = images.toArray(new Integer[images.size()]); //turn geshuffelte ArrayList into Array

        final int[] counter_front_back = {0}; //final Array, damit diese Variable in der Click-Methode nutzbar ist, Workaround vorschlag von Android Stuiod
            //genaueers hier: https://stackoverflow.com/questions/14425826/variable-is-accessed-within-inner-class-needs-to-be-declared-final
        //um zu überprüfen, wann Vorder und Rückseite der Karten zu sehen sind, im Tutorial nimmt man unsichtbaren Buttontext


        for(int i=0;i<button_list.length;i++){

            button_list[i].setText("cardBack");
            //button_list[i].setTextSize(0,0); //wieder unsichtbar machen

            final int loop_counter = i; //final, damit es noch iin OnClick-Methode genutzt werden kann

            button_list[i].setOnClickListener(new View.OnClickListener() { //beim Anklicken eines Buttons, wird ein Bild aus der Liste dahinter eingefügt
                @Override
                public void onClick(View v) {

                    if(button_list[loop_counter].getText().toString() =="cardBack" && turned_2_over == false) {
                        button_list[loop_counter].setBackgroundResource(images_list[loop_counter]);

                            button_list[loop_counter].setText(images_list[loop_counter].toString());

                        counter_controll_zwei++;
                        //clicked++;
                    }
                    else if(button_list[loop_counter].getText().toString() != "cardBack"){
                        button_list[loop_counter].setBackgroundResource(R.drawable.ghost);

                        button_list[loop_counter].setText("cardBack");


                        counter_controll_zwei--; //wieder zurück um 1, damit neues Pärchen gedreht werden kann
                    }


                    if (counter_controll_zwei ==2){
                        turned_2_over = true;
                        //kommt noch zeugs
                    }
                    else if(counter_controll_zwei ==0){
                        turned_2_over = false;
                    }
                }
            }); //diese Klammer + ; ist wichtig!

        }

    //VideoMinute 23.48 min
        //https://www.youtube.com/watch?v=BGvjScKcW1s


        //ArrayList<Button> buttons   =new ArrayList<Button>(20);
        //buttons.add(0, button1);
        //buttons.add(1, button2);
        //buttons.add(button3);
        //buttons.add(button4);
        //buttons.add(button5);
        //buttons.add(button6);
        //buttons.add(button7);
        //buttons.add(button8);
        //buttons.add(button9);
        //buttons.add(button10);
        //buttons.add(button11);
        //buttons.add(button12);
        //buttons.add(button13);
        //buttons.add(button14);
        //buttons.add(button15);
        //buttons.add(button16);
        //buttons.add(button17);
        //buttons.add(button18);
        //buttons.add(button19);
        //buttons.add(button20);
//
        //Collections.shuffle(images);
        ////buttons.set(0,button1).setBackgroundResource(R.drawable.bat); //Fehler, hier nullpointer reference
        //for(int i = 0; i<12; i++)
        //{for (Button f : buttons) {
        //    buttons.set(i, f).setBackgroundResource(R.drawable.bat);
        //    buttons.set(i,f).setText("cardBack"); = "cardBack";
        //    buttons.set(i,f).textSize = 0.0;
//
        //}}
    }
}
