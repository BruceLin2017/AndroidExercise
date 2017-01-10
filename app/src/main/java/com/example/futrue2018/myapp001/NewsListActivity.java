package com.example.futrue2018.myapp001;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import com.example.futrue2018.appUtils.HttpUtils;
import com.example.futrue2018.appUtils.NewsAdapter;
import com.example.futrue2018.appUtils.NewsTab;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NewsListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView LvNews;
    private NewsAdapter adaper;
    private List<NewsTab> newsList;

    public static final String GET_URL = "http://192.168.1.103:8080/Web001/servlet/NewsServlet";
    private Handler getNewshandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String jsonData = (String)msg.obj;

            JSONArray result = null;
            try {
                result = new JSONArray(jsonData);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            // 从中提取需要的值
            for (int i=0;i<jsonData.length();i++){
                try {
                    if(i==9)
                        break;
                    JSONObject object = result.getJSONObject(i);
                    int Nid = object.getInt("Nid");
                    String title = object.getString("Title");
                    String NewsContent = object.getString("NewsContent");
                    String ImgUrl = object.getString("ImgUrl");
                    //String CreateDate = object.getString("CreateDate");
                    newsList.add(new NewsTab(Nid,title,NewsContent,ImgUrl,(new Date())));

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            adaper.notifyDataSetChanged();

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list);
        LvNews = (ListView) findViewById(R.id.LVNews);

        newsList = new ArrayList<NewsTab>();
        adaper = new NewsAdapter(this,newsList);
        LvNews.setAdapter(adaper);
        LvNews.setOnItemClickListener(this);
        HttpUtils.getNewsJSON(GET_URL, getNewshandler);
     }



    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        NewsTab news = newsList.get(i);
        Intent intent = new Intent(this, NewsItemActivity.class);
         intent.putExtra("content_url", news.getImgUrl());
        startActivity(intent);
    }
}
