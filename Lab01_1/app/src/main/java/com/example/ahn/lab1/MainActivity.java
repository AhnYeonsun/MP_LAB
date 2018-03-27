package com.example.ahn.lab1;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.ImageView;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    ImageView imageView2;
    int imageIndex = 0; //initialize index to 0.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Main layout inflation

        imageView = (ImageView) findViewById(R.id.imageView);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        //Find main's images by id, and get it

        Button button = (Button) findViewById(R.id.button);
        //initialize button by id from main xml
        button.setOnClickListener(new View.OnClickListener(){
            //Listen for whether the button is pressed or not
            public void onClick(View v){
                //If button is pressed, then perform onClick() function
                changeImage();
            }
        });
    }

    private void changeImage() {
        //if index 0, then image changes to blue and we input 1 to index
        if (imageIndex == 0) {
            imageView.setVisibility(View.VISIBLE);
            imageView2.setVisibility(View.INVISIBLE);
            imageIndex = 1;

        } else if(imageIndex == 1){
            //if index 1, then image changes to green and we input 0 to index
            imageView.setVisibility(View.INVISIBLE);
            imageView2.setVisibility(View.VISIBLE);
            imageIndex = 0;
        }
    }

}



