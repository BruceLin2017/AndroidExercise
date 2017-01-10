package com.example.futrue2018.myapp001;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


import java.util.*;

public class LViewActivity extends AppCompatActivity {
    private ListView lvNews;
    private List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lview);

        lvNews = (ListView) findViewById(R.id.LVNews);

         list = new ArrayList<String>();
        list.add("今天天气不错，还挺风和日丽的。");
        list.add("2017年新年快乐！");
        list.add("2017年新年快乐！");

        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
        lvNews.setAdapter(adapter);

        AdapterView.OnItemClickListener listviewListener = new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(),NewsItemActivity.class);
                intent.putExtra("item",list.get(i));
                startActivity(intent);
            }
        };

        lvNews.setOnItemClickListener(listviewListener);
    }


}
