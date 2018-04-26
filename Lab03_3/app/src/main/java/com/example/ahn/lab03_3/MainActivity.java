package com.example.ahn.lab03_3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public Button btn_frag1;
    public Button btn_frag2;
    public FirstFragment firstFragment;
    public SecondFragment secondFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        setListener();
    }

    //Find activity_main's widgets by id, and get it
    //And create new fragment Classes' objects
    public void init(){
        btn_frag1 = (Button)findViewById(R.id.btn_frag1);
        btn_frag2 = (Button)findViewById(R.id.btn_frag2);

        firstFragment = new FirstFragment();
        secondFragment = new SecondFragment();
    }

    //If buttons clicked, then create fragments' transaction
    //Replace whatever is in the fragment_container view with this fragment
    //And commit the transaction
    public void setListener(){
        //Listen for whether the button is pressed or not
        btn_frag1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_for_fragment, firstFragment).commit();
            }
        });
        //Listen for whether the button is pressed or not
        btn_frag2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_for_fragment, secondFragment).commit();
            }
        });
    }
}
