package com.example.androidhardware;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

public class CameraActivity extends AppCompatActivity implements View.OnClickListener
 {
     private ImageView imgPic;
     private VideoView videoDemo;
     private Button btnCamera;
     private Button btnPicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

          btnCamera = (Button)findViewById(R.id.btnCamera);
        btnPicture = (Button)findViewById(R.id.btnPicture);
        btnCamera.setOnClickListener(this);
        btnPicture.setOnClickListener(this);

        imgPic=(ImageView)findViewById(R.id.imgViewPic);
        videoDemo=(VideoView)findViewById(R.id.videoDemo);

    }
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        if(requestCode==1){
            if(resultCode== Activity.RESULT_OK){
                Bitmap cameraBitmap = (Bitmap)data.getExtras().get("data");
                imgPic.setImageBitmap(cameraBitmap);
            }
        }

        if(requestCode==2){
            if(resultCode== Activity.RESULT_OK){
                Uri uri = data.getData();
                Cursor cursor = this.getContentResolver().query(uri,null,null,null,null);
                if(cursor.moveToFirst()){
                    String videoPath = cursor.getString(cursor.getColumnIndex("_data"));
                    videoDemo.setVideoURI(uri.parse(videoPath));
                    videoDemo.setMediaController(new MediaController(this));
                    videoDemo.start();
                }
            }
        }
    }

        @Override
        public void onClick(View view) {
            if(view.getId()==btnPicture.getId()){
                videoDemo.setVisibility(1);
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,1);
            }

            if(view.getId()==btnCamera.getId()){
                Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                startActivityForResult(intent,2);
            }


        }

}
