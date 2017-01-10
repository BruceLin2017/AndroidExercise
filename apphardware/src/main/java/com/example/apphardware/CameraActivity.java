package com.example.apphardware;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class CameraActivity extends AppCompatActivity implements View.OnClickListener
 {
     private ImageView imgPic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        Button btnCamera = (Button)findViewById(R.id.btnCamera);
        btnCamera.setOnClickListener(this);

        imgPic=(ImageView)findViewById(R.id.imgViewPic);

    }
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        if(requestCode==1){
            if(resultCode== Activity.RESULT_OK){
                Bitmap cameraBitmap = (Bitmap)data.getExtras().get("data");
                imgPic.setImageBitmap(cameraBitmap);
            }

        }
    }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent,1);
        }

}
