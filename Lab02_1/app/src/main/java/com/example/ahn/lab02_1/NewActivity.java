package com.example.ahn.lab02_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class NewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        //Make intent for receiving MainActivity's intent, and Get it
        Intent passedIntent = getIntent();
        if(passedIntent != null){
            //Get values from received intent
            String loginName = passedIntent.getStringExtra("loginName");
            String loginAge = passedIntent.getStringExtra("loginAge");

            //Floating toast message with parameter
            Toast.makeText(getApplicationContext(), "Name : " + loginName + ", Age : " + loginAge, Toast.LENGTH_LONG).show();
        }

        Button button0 = (Button)findViewById(R.id.closeButton);
        //Listen for whether the button is pressed or not
        button0.setOnClickListener(new View.OnClickListener(){
            //If button is pressed, perform onClick method
            public void onClick(View view){
                finish();
            }
        });
    }
}