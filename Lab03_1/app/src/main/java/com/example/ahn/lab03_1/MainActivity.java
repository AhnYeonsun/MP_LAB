package com.example.ahn.lab03_1;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button mBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Find activity_main's editText and button by id, and get it
        mBtn = (Button) findViewById(R.id.button);
        //Register the View(Button) to which the context menu should be associated
        registerForContextMenu(mBtn);
    }

    //When the registered view receives a long-click event, the system calls this method
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        //Set button's header title
        menu.setHeaderTitle("Button Menu");
        //Add menu object with groupId, itemId, order, and title
        menu.add(0, 1, 0, "Red");
        menu.add(0, 2, 0, "Green");
        menu.add(0, 3, 0, "Blue");
    }

    //When the user selects a menu item, the system calls this method
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) { //Get selected item's id
            case 1:
                //Set button's color to selected item's color
                mBtn.setTextColor(Color.RED);
                return true;
            case 2:
                mBtn.setTextColor(Color.GREEN);
                return true;
            case 3:
                mBtn.setTextColor(Color.BLUE);
                return true;
            default:
                return true;
        }
    }
}