package com.example.ahn.lab02_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText Name;
    EditText Age;
    Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Find activity_main's editText and button by id, and get it
        Name = (EditText)findViewById(R.id.editName);
        Age = (EditText)findViewById(R.id.editAge);
        button1 = (Button)findViewById(R.id.addButton);

        //Listen for whether the button is pressed or not
        button1.setOnClickListener(new View.OnClickListener(){
            //If button is pressed, perform onClick method
            public void onClick(View view){
                //Get string from editText's value
                String username = Name.getText().toString();
                String userage = Age.getText().toString();

                //context객체를 매개변수로 NewActicity에 넘겨준다.
                //intent에 name, age변수를 넣고
                //startActivity 실행
                Intent intent = new Intent (getApplicationContext(), NewActivity.class);
                intent.putExtra("loginName", username);
                intent.putExtra("loginAge", userage);
                startActivity(intent);
            }
        });
    }
}
