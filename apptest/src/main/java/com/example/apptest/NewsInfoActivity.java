package com.example.apptest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;

public class NewsInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_info);
        Intent intent = this.getIntent();
        NewsTab news=(NewsTab)intent.getSerializableExtra("News");
        //Log.v("Log:",news.getTitle());

        TextView tvTitle = (TextView) findViewById(R.id.tvTitle);
        TextView tvDate = (TextView) findViewById(R.id.tvDate);
        TextView tvDesc = (TextView) findViewById(R.id.tvDesc);
        ImageView ivPic = (ImageView) findViewById(R.id.ivPic);

        tvTitle.setText(news.getTitle());
        String date = (new SimpleDateFormat("yyyy-MM-dd")).format(news.getCreateDate());
        tvDate.setText(date);
        tvDesc.setText(news.getNewsContent());

    }
}
