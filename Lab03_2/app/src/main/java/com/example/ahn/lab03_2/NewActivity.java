package com.example.ahn.lab03_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NewActivity extends AppCompatActivity {
    TextView receiveName;
    TextView receiveType;
    TextView receiveSend;
    Button buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        //Find activity_new's widgets by id, and get it
        receiveName = (TextView)findViewById(R.id.receiveName);
        receiveType = (TextView)findViewById(R.id.receiveType);
        receiveSend = (TextView)findViewById(R.id.receiveSend);

        //Make intent for receiving MainActivity's intent, and Get it
        Intent receiveIntent = getIntent();
        //Get values from received intent
        receiveName.setText(": "+ receiveIntent.getStringExtra("loginName"));
        receiveType.setText(": "+ receiveIntent.getStringExtra("loginType"));
        receiveSend.setText(": "+ receiveIntent.getStringExtra("loginSend"));

        buttonBack = (Button)findViewById(R.id.buttonBack);
        //Listen for whether the button is pressed or not
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish(); //End newActicity
            }
        });
    }
}
