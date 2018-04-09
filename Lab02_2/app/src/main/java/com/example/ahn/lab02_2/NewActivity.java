package com.example.ahn.lab02_2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class NewActivity extends AppCompatActivity {

    TextView textView;
    Button goBtn;
    Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        //Find activity_main's TextView and buttons by id, and get it
        textView = (TextView)findViewById(R.id.textview);
        goBtn = (Button)findViewById(R.id.button2);
        backBtn = (Button)findViewById(R.id.button3);

        //Make intent for receiving MainActivity's intent, and Get it
        final Intent passedIntent = getIntent();
        //Get value from received intent
        final String passedUrl = passedIntent.getStringExtra("Url");
        //View the text
        textView.setText(passedUrl);

        //Listen for whether the button is pressed or not
        goBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                if(!passedUrl.isEmpty()){
                    //Make intent for getting URI
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://"+passedUrl));
                    startActivity(intent);
                }else{
                    //Floating toast message with parameter, and finish
                    Toast.makeText(getApplicationContext(), "주소를 다시 입력하세요.", Toast.LENGTH_LONG).show();
                    finish();
                }
            }
        });
        //Listen for whether the button is pressed or not
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Floating toast message with parameter, and finish
                Toast.makeText(getApplicationContext(), "뒤로가기 버튼을 눌렀습니다.", Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
}
