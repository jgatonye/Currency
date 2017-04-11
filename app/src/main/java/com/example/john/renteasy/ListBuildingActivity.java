package com.example.john.renteasy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

public class ListBuildingActivity extends AppCompatActivity {

    GridView  myGridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_building);

        myGridView = (GridView) findViewById(R.id.gridView);

        myGridView.setAdapter(new HouseAdapter(this));
    }
}



//adapter details


