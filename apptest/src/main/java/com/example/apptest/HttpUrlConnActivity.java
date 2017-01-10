package com.example.apptest;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.io.Serializable;

public class HttpUrlConnActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView lvNews;
    private List<NewsTab> newsList= new ArrayList<NewsTab>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_clent);
        lvNews =(ListView)findViewById(R.id.lvNews) ;

       // NewsTab news= new NewsTab(1,"Hi","what date is today","PicUrl",new Date());
      //  newsList.add(news);
        MyAdapter adapter = new MyAdapter(newsList,this);
        lvNews.setAdapter(adapter);
        lvNews.setOnItemClickListener(this);
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                try {  //10.0.2.2  映射 127.0.0.1
                    URL url = new URL("http://10.12.137.214:8080/Web001/servlet/NewsServlet");
                    connection = (HttpURLConnection) url.openConnection();

                    connection.setRequestMethod("GET");

                    connection.setConnectTimeout(8000);
                    connection.setReadTimeout(8000);

                    InputStream in = connection.getInputStream();
                    // 下面对获取到的输入流进行读取
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }
                    //Log.VERBOSE(response);
                    Message message = new Message();
                    message.what = 1;
                    // 将服务器返回的结果存放到Message中
                    message.obj = response.toString();
                    handler.sendMessage(message);
                } catch (Exception e) {

                    e.printStackTrace();

                } finally {
                    if (connection != null) {
                        connection.disconnect();
                    }
                }
            }
        }).start();

        //Log.v("ListSize:",newsList.size()+"");


    }
    //消息的具体处理过程，
    // 需要在new Handler对象时使用匿名内部类重写Handler的handleMessage(Message msg)方法
    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    String response = (String) msg.obj;
                    // 在这里进行UI操作，将结果显示到界面上
                    // 将返回结果生成JSON对象
                    JSONArray result = null;
                    try {
                        result = new JSONArray(response);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    // 从中提取需要的值
                    for (int i=0;i<response.length();i++){
                        try {
                            JSONObject object = result.getJSONObject(i);
                             int Nid = object.getInt("Nid");
                             String title = object.getString("Title");
                             String NewsContent = object.getString("NewsContent");
                             String ImgUrl = object.getString("ImgUrl");
                          //   String CreateDate = object.getString("CreateDate");
                             newsList.add(new NewsTab(Nid,title,NewsContent,ImgUrl,(new Date())));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                   // tvShow.setText(title);
            }
        }
    };

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this,NewsInfoActivity.class);
        NewsTab news = newsList.get(position);
        Bundle bundle = new Bundle();
        //Android中Intent传递类对象提供了两种方式一种是 通过实现Serializable接口传递对象，
        // 一种是通过实现Parcelable接口传递对象。
        //要求被传递的对象必须实现上述2种接口中的一种才能通过Intent直接传递。
        //如果传递的是List<Object>,可以把list强转成Serializable类型,而且object类型也必须实现了Serializable接口
        //如发送：Intent.putExtras(key, (Serializable)list)
        // 接收：(List<YourObject>)getIntent().getSerializable(key)
        bundle.putSerializable("News", news);

        intent.putExtras(bundle);
        startActivity(intent);
    }
}
