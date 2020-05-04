package com.example.memu;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class FirstFragment extends Fragment {

    Button button_animal_memory;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_first, container, false);

        View fragmentFirstLayout = inflater.inflate(R.layout.fragment_first, container, false);
        //Suchen der Items per View hier einmalig für ganze Klasse

        //Button wurde glöscht, welcher weiiter unten mit clickevent aufgerufen werden könnte (auskommentiert)
        //button_animal_memory = fragmentFirstLayout.findViewById(R.id.button_animal_memory);

        return fragmentFirstLayout;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });

        //Anklicken eines Buttons auf Homescreen (Button habe ich gelöscht)
       //button_animal_memory.setOnClickListener(new View.OnClickListener() {
       //    @Override
       //    public void onClick(View view) {

       //        Intent intent = new Intent(getActivity(), AnimalMemory.class);
       //        startActivity(intent);

       //    }
       //});

    }
}
