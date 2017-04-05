package com.example.anubhav.secondimage;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import static android.R.attr.bitmap;

public class MainActivity extends AppCompatActivity {
    ImageView imageView,i2;
    Button B;
    EditText T;
    Button B2;
    Bitmap b;

    String url="https://www.w3schools.com/css/trolltunga.jpg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView=(ImageView)findViewById(R.id.I);
        B=(Button)findViewById(R.id.B);
        T=(EditText) findViewById(R.id.T);
        i2=(ImageView)findViewById(R.id.I2);
        B2=(Button)findViewById(R.id.B2);
        B2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                Bitmap bitmap = ((BitmapDrawable)imageView.getDrawable()).getBitmap();
                bitmap=toGrayscale(bitmap);
                i2.setImageBitmap(bitmap);
            }
        });
        B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=T.getText().toString();
                loadfromurl("http://www.menucool.com/slider/jsImgSlider/images/image-slider-2.jpg");
            }

        });

    }
    void loadfromurl(String url)
    {

        Picasso.with(this)
                .load(url)
                .into(imageView, new com.squareup.picasso.Callback() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError() {

                    }
                });
    }



    public Bitmap toGrayscale(Bitmap bmpOriginal)
    {
        int width, height;
        height = bmpOriginal.getHeight();
        width = bmpOriginal.getWidth();

        Bitmap bmpGrayscale = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
        Canvas c = new Canvas(bmpGrayscale);
        Paint paint = new Paint();
        ColorMatrix cm = new ColorMatrix();
        cm.setSaturation(0);
        ColorMatrixColorFilter f = new ColorMatrixColorFilter(cm);
        paint.setColorFilter(f);
        c.drawBitmap(bmpOriginal, 0, 0, paint);
        return bmpGrayscale;
    }

    }



