package com.example.futrue2018.myapp001;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.print("onCreate......");
        Button btnInfo = (Button) findViewById(R.id.button);
        CheckBox chk01 = (CheckBox) findViewById(R.id.checkBox);
        CheckBox chk02 = (CheckBox) findViewById(R.id.checkBox2);
        Button btnAlert = (Button) findViewById(R.id.button2);

        btnAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("对话框");
                dialog.setMessage("请选择是否要继续：");
                dialog.setPositiveButton("确定", new AlertDialog.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "你选择的爱好是：" + "你选择的是确定", Toast.LENGTH_LONG).show();
                    }
                });
                dialog.create().show();
            }
        });


        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
//                intent.putExtra("info","hell2017.....");
//                startActivity(intent);
                CheckBox chk01 = (CheckBox) findViewById(R.id.checkBox);
                CheckBox chk02 = (CheckBox) findViewById(R.id.checkBox2);
                String str = "";
                if (chk01.isChecked())
                    str += chk01.getText();
                if (chk02.isChecked())
                    str += chk02.getText();


                Toast.makeText(getApplicationContext(), "你选择的爱好是：" + str, Toast.LENGTH_LONG).show();
            }
        });


    }

    @Override
    protected void onStart() {
        System.out.print("onStart......");
        super.onStart();
    }

    @Override
    protected void onRestart() {
        System.out.print("onRestart......");
        super.onRestart();

    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.print("onResume......");
    }

    @Override
    protected void onStop() {
        System.out.print("onStop......");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        System.out.print("onDestroy......");
        super.onDestroy();

    }

    @Override
    protected void onPause() {
        System.out.print("onPause......");
        super.onPause();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {


        }
    }

}
