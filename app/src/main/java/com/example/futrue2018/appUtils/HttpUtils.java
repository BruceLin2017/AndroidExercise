package com.example.futrue2018.appUtils;

import android.app.Notification;
import android.os.Handler;
import android.os.Message;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Futrue2018 on 2017/1/8.
 */

public class HttpUtils   {
    public static void getNewsJSON(final String url, final Handler handler){
         new Thread(new Runnable() {
             @Override
             public void run() {
                 HttpURLConnection conn;
                 InputStream is;

                 try {
                     conn = (HttpURLConnection) new URL(url).openConnection();
                     conn.setRequestMethod("GET");
                     is = conn.getInputStream();
                     BufferedReader reader =  new BufferedReader(new InputStreamReader(is));
                     String line = "";
                     StringBuilder result = new StringBuilder();
                     while ((line=reader.readLine())!=null){
                        result.append(line);
                     }
                     Message msg = new Message();
                    msg.obj = result.toString();
                     handler.sendMessage(msg);

                 } catch (IOException e) {
                     e.printStackTrace();
                 }

             }
         }).start();

    }
    public void run(){
        HttpURLConnection conn;
        InputStream is;

        //conn = new URL(url)

    }
}
