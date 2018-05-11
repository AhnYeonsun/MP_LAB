package com.example.ahn.lab04_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout slidingArea;
    Button button;

    //if 0, it means base area
    //if 1, it means slide area
    public int pressed = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Find activity_main's widgets by id, and get it
        slidingArea = (LinearLayout)findViewById(R.id.slideArea);
        button = (Button)findViewById(R.id.button);
        //Listen for whether the button is pressed or not
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if base area
                if(pressed==0) {
                    //Get translate animation
                    Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.left_slide);
                    //Start animation
                    slidingArea.startAnimation(anim);
                    //Slide Area Layout visible
                    slidingArea.setVisibility(View.VISIBLE);
                    button.setText("CLOSE PAGE");
                    pressed = 1;
                }
                //if slide area
                else if(pressed==1){
                    //Get translate animation
                    Animation anim2 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.right_slide);
                    //Start animation
                    slidingArea.startAnimation(anim2);
                    //Slide Area Layout invisible
                    slidingArea.setVisibility(View.INVISIBLE);
                    button.setText("OPEN PAGE");
                    pressed = 0;
                }
            }
        });
    }
}
