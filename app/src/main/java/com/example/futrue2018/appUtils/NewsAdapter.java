package com.example.futrue2018.appUtils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.futrue2018.myapp001.R;

import java.util.List;

/**
 * Created by Futrue2018 on 2017/1/9.
 */

public class NewsAdapter extends BaseAdapter {
    private Context context;
    private List<NewsTab> newsList;
    public NewsAdapter(Context context,List<NewsTab> newsList){
        this.context = context;
        this.newsList = newsList;
    }
    @Override
    public int getCount() {
        return newsList.size();
    }

    @Override
    public NewsTab getItem(int i) {
        return newsList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view!=null){
            view = LayoutInflater.from(context).inflate(R.layout.news_item,null);
            TextView tvTitle = (TextView)view.findViewById(R.id.tvTitle);
            TextView tvDate = (TextView)view.findViewById(R.id.tvDate);
            TextView tvDesc = (TextView)view.findViewById(R.id.tvDesc);
            ImageView ivPic = (ImageView)view.findViewById(R.id.ivPic);

            NewsTab news = newsList.get(i);
            System.out.println(news);
            tvTitle.setText(news.getTitle());
            tvDesc.setText(news.getNewsContent());
            tvDate.setText(news.getCreateDate().toString());

            return view;
        }
        return null;
    }
}
