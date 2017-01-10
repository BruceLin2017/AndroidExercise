package com.example.futrue2018.myapp001;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class NewsItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_item);

        TextView tvText=(TextView)findViewById(R.id.textView4);
        Intent intent = this.getIntent();
        String title = intent.getStringExtra("item");

        tvText.setText(title);

    }
}
