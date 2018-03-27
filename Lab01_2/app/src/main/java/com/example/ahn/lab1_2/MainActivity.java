package com.example.ahn.lab1_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //text by user typing
    public EditText edit_name;

    //print, clear button. and text for printing
    public Button btn_print;
    public Button btn_clear;
    public TextView view_print;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Main layout inflation

        init();
        //initialize texts and buttons by id

        btn_clear.setOnClickListener(new View.OnClickListener(){
            //Listen for whether the clear button is pressed or not
            public void onClick(View v){
                //If button is pressed, then perform onClick() function
                clearClicked(v);
            }
        });
        btn_print.setOnClickListener(new View.OnClickListener() {
            //Listen for whether the print button is pressed or not
            @Override
            public void onClick(View v) {
                //If button is pressed, then perform onClick() function
                printClicked(v);
            }
        });
    }

    public void init(){
        //initialize texts and buttons by id from main xml
        edit_name = (EditText) findViewById(R.id.editName);
        btn_clear = (Button) findViewById(R.id.clear);
        btn_print = (Button) findViewById(R.id.print);
        view_print = (TextView) findViewById(R.id.view_print);
    }
    public void clearClicked(View v){
        //Set edit text and printed text to blank
        edit_name.setText("");
        view_print.setText("");
    }
    public void printClicked(View v){
        //Get edit text and print it
        String text = "";
        text = edit_name.getText().toString();
        view_print.setText(text);
    }
}
