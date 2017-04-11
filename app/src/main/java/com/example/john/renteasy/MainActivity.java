package com.example.john.renteasy;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.findRental) Button mFindRental;
    @Bind(R.id.appNameTextView) TextView mNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Typeface coolFont = Typeface.createFromAsset(getAssets(), "fonts/cool.ttf");
        mNameTextView.setTypeface(coolFont);

        mFindRental.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RentActivity.class);
                startActivity(intent);
            }
        });
    }
}
