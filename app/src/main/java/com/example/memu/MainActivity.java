package com.example.memu;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //FloatingActionButton fab = findViewById(R.id.fab);
        //fab.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View view) {
        //        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
        //                .setAction("Action", null).show();
        //    }
        //});

        //meine Programmcode-Beginn

        ArrayList<Integer> images = new ArrayList<Integer>(7);
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




        ArrayList<Button> buttons   =new ArrayList<Button>(20);
        buttons.add(0, button1);
        buttons.add(1, button2);
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

        Collections.shuffle(images);
        buttons.set(0,button1).setBackgroundResource(R.drawable.bat); //Fehler, hier nullpointer reference
        //for(int image : images)
          //  buttons.set(i,button1).setBackgroundResource(R.drawable.bat);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
