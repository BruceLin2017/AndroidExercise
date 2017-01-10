package com.example.futrue2018.myapp001;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView tvShow = (TextView)findViewById(R.id.tvShow);
        Intent intent  = getIntent();

        String str = intent.getStringExtra("info");
        tvShow.setText(str);
    }
}
