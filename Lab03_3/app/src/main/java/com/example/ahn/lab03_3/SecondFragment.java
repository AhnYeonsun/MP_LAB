package com.example.ahn.lab03_3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class SecondFragment extends android.support.v4.app.Fragment {

    //Create the view hierarchy associated with the fragment
    //Return its UI
    //By using inflation
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

}
