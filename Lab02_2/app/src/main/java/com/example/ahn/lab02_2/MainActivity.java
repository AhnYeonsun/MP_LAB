package com.example.ahn.lab02_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText Url;
    Button nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Find activity_main's editText and button by id, and get it
        Url = (EditText)findViewById(R.id.editText);
        nextBtn = (Button)findViewById(R.id.button1);

        //Listen for whether the button is pressed or not
        nextBtn.setOnClickListener(new View.OnClickListener(){
            //If button pressed, perform onClick method
            public void onClick(View view){
                //Get Url to String
                String myUrl = Url.getText().toString();

                //context객체를 매개변수로 NewActicity에 넘겨준다.
                //intent에 url 변수를 넣고
                //startActivity 실행
                Intent intent = new Intent(getApplication(), NewActivity.class);
                intent.putExtra("Url", myUrl);
                startActivity(intent);
            }
        });
    }
}
