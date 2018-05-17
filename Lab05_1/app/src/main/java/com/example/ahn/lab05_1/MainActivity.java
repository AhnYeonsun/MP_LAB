package com.example.ahn.lab05_1;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ImageView imgView1;
    ImageView imgView2;
    EditText editText;
    Button button;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Find activity_main's widgets by id, and get it
        imgView1 = (ImageView)findViewById(R.id.imageView);
        imgView2 = (ImageView)findViewById(R.id.imageView2);
        editText = (EditText)findViewById(R.id.editText);
        button = (Button)findViewById(R.id.button);
        //Listen for whether the button is pressed or not
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Create thread with index
                DogThread thread1 = new DogThread(0);
                thread1.start();
                DogThread thread2 = new DogThread(1);
                thread2.start();
            }
        });
    }
    //Thread Class extends Thread
    class DogThread extends Thread{
        //Distinguish threads by dog index
        //Distinguish images by state index
        int dogIndex;
        int stateIndex;

        //drawable image's type is Integer. Make arrayList for images
        ArrayList<Integer> images = new ArrayList<>();

        //Add images by each dog threads
        public DogThread(int index){
            dogIndex = index;
            images.add(R.drawable.dog_eating);
            images.add(R.drawable.dog_standing);
            images.add(R.drawable.dog_study);
        }
        public void run(){
            stateIndex = 0;
            for (int i = 0; i < 9; i++) {
                final String msg = "dog #" + dogIndex + " state: " + stateIndex;
                //By handler, send runnable object to message queue
                handler.post(new Runnable(){
                    public void run() {
                        editText.append(msg + "\n");
                        if (dogIndex == 0) {
                            imgView1.setImageResource(images.get(stateIndex));
                        } else if (dogIndex == 1) {
                            imgView2.setImageResource(images.get(stateIndex));
                        }
                    }
                });
                //State change with random seconds
                try {
                    int sleepTime = getRandomTime(500, 3000);
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                stateIndex++;
                if (stateIndex >= images.size()) {
                    stateIndex = 0;
                }
            }
        }
        //Get random time for changing states
        public int getRandomTime(int min, int max){
            return min+(int)(Math.random()*(max-min));
        }
    }
}
