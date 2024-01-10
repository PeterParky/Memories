package com.example.memories;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // initializing variables
    TextView tv_year, tv_month, tv_day;
    TextView tv_totaldays;
    Button btn_Calc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // assign variables
        tv_totaldays = findViewById(R.id.tv_show);

        //
        Intent data_intent = getIntent();
        Bundle info_bun = data_intent.getBundleExtra("DayBundle");
        long totaldays = info_bun.getLong("DatedDay");
        tv_totaldays.setText("" + totaldays);


    }
}