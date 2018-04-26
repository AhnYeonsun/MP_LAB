package com.example.ahn.lab03_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    EditText editName;
    RadioGroup radGroup;
    RadioButton radman;
    RadioButton radwoman;
    CheckBox chkemail;
    CheckBox chksms;
    Button buttonEnter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Find activity_main's widgets by id, and get it
        editName = (EditText)findViewById(R.id.editName);
        radGroup = (RadioGroup)findViewById(R.id.radioGroup);
        radman = (RadioButton)findViewById(R.id.man);
        radwoman = (RadioButton)findViewById(R.id.woman);
        chkemail = (CheckBox)findViewById(R.id.email);
        chksms = (CheckBox)findViewById(R.id.sms);

        buttonEnter = (Button)findViewById(R.id.buttonEnter);
        //Listen for whether the button is pressed or not
        buttonEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editName.getText().toString();
                String send = "";
                String type = "";

                //if checked, set text
                if(chkemail.isChecked())
                    send += "E-mail ";
                if(chksms.isChecked())
                    send += "SMS ";

                //Get checked radio button's id, and set text
                int radioId = radGroup.getCheckedRadioButtonId();
                if(radman.getId()==radioId)
                    type = "남";
                if(radwoman.getId()==radioId)
                    type = "여";

                //context객체를 매개변수로 NewActicity에 넘겨준다.
                //intent에 data를 넣고
                //startActivity 실행
                Intent intent = new Intent(getApplicationContext(), NewActivity.class);
                intent.putExtra("loginName",name);
                intent.putExtra("loginSend",send);
                intent.putExtra("loginType",type);
                startActivity(intent);

                //All clear
                editName.setText("");
                chksms.setChecked(false);
                chkemail.setChecked(false);
                radGroup.clearCheck();
            }
        });
    }
}
