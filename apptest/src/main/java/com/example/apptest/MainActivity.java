package com.example.apptest;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText mEtName;
    private Button mBtnLogin;
    private TextView mTvResult;
    private String mStrName, mStrResult;

    //新建Handler的对象，在这里接收Message，然后更新TextView控件的内容
    private Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

        }

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEtName = (EditText) findViewById(R.id.et_hello);
        mTvResult = (TextView) findViewById(R.id.tv_result);
        mBtnLogin = (Button) findViewById(R.id.btn_login);

        mBtnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

            }
        });
    }



}
