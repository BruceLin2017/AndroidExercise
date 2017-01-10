package com.example.apptest;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.List;

import static android.R.id.list;

/**
 * Created by Futrue2018 on 2017/1/9.
 */

public class MyAdapter extends BaseAdapter {

    private List<NewsTab> list;
    private Context context;
    public MyAdapter(List<NewsTab> list, Context context) {
        this.list = list;
        this.context = context;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public NewsTab getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
          convertView = View.inflate(context, R.layout.news_item, null);
      }
        TextView tvTitle = (TextView)convertView.findViewById(R.id.tvTitle);
        TextView tvDate = (TextView)convertView.findViewById(R.id.tvDate);
        TextView tvDesc = (TextView)convertView.findViewById(R.id.tvDesc);
        ImageView ivPic = (ImageView)convertView.findViewById(R.id.ivPic);

        String title =list.get(position).getTitle();
        tvTitle.setText((title.length()>=20)?(title.substring(0,20)):title);

        String date = (new SimpleDateFormat("yyyy-MM-dd")).format(list.get(position).getCreateDate());
        tvDate.setText(date);

        String desc = list.get(position).getNewsContent();
        tvDesc.setText(((desc.length()>=45)?(desc.substring(0,45)):desc)+"...");
       // Bitmap bitmap = getHttpBitmap(list.get(position).getImgUrl());
       // ivPic.setImageBitmap(bitmap);
     // long end = System.nanoTime();

      // Log.d("main", list.get(position).getImgUrl() );
      return convertView;
    }
    /**
     * 获取网落图片资源
     * @param url
     * @return
     */
    public static Bitmap getHttpBitmap(String url){
        URL myFileURL;
        Bitmap bitmap=null;
        try{
            myFileURL = new URL(url);
            //获得连接
            HttpURLConnection conn=(HttpURLConnection)myFileURL.openConnection();
            //设置超时时间为6000毫秒，conn.setConnectionTiem(0);表示没有时间限制
            conn.setConnectTimeout(6000);
            //连接设置获得数据流
            conn.setDoInput(true);
            //不使用缓存
            conn.setUseCaches(false);
            //这句可有可无，没有影响
            //conn.connect();
            //得到数据流
            InputStream is = conn.getInputStream();
            //解析得到图片
            bitmap = BitmapFactory.decodeStream(is);
            //关闭数据流
            is.close();
        }catch(Exception e){
            e.printStackTrace();
        }

        return bitmap;

    }
}
