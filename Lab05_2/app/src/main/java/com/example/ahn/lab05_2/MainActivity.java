package com.example.ahn.lab05_2;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button;
    TextView textView1;
    TextView textView2;
    int facto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Find activity_main's widgets by id, and get it
        editText = (EditText)findViewById(R.id.editText);
        button = (Button)findViewById(R.id.button);
        textView1 = (TextView)findViewById(R.id.textView1);
        textView2 = (TextView)findViewById(R.id.textView2);
        //Listen for whether the button is pressed or not
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Facto().execute();
            }
        });
    }

    //Facto : Class extends AsyncTask
    //Calculate factorial
    public class Facto extends AsyncTask<Void, Integer, Void>{
        int n;

        @Override
        //Setup the task
        protected void onPreExecute(){
            textView1.setText("");
            textView2.setText("");
            n = Integer.parseInt(editText.getText().toString());
            facto = 1;
        }
        @Override
        //After onPreExecute()
        //runs automatically in a separate (Background)Thread
        protected Void doInBackground(Void... params){
            for (int i=n; i>0; i--){
                try{
                    Thread.sleep(500);
                    publishProgress(i);
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
            return null;
        }
        @Override
        //While background computation is still executing,
        //display any form of progress in the UI
        protected void onProgressUpdate(Integer... values){
            textView1.append(values[0].toString() + " ");
            facto *= values[0];
        }
        @Override
        //After background task, execute at UI Thread
        protected void onPostExecute(Void aVoid){
            textView2.setText("= "+facto);
        }
    }
}