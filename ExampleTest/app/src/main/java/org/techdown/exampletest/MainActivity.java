package org.techdown.exampletest;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.EventListener;

public class MainActivity extends AppCompatActivity {
    private ImageView firstImg;
    private ImageView secondImg;
    private ImageView thirdImg;
    int index =1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstImg = (ImageView) findViewById(R.id.imageView);
        secondImg = (ImageView) findViewById(R.id.imageView2);
        thirdImg = (ImageView) findViewById(R.id.imageView3);

        // 이전버튼
        final Button prevBtn = (Button) findViewById(R.id.button);
        prevBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index == 1) {
                    firstImg.setVisibility(View.INVISIBLE);
                    secondImg.setVisibility(View.VISIBLE);
                    thirdImg.setVisibility(View.INVISIBLE);

                }else if (index == 2){
                    firstImg.setVisibility(View.INVISIBLE);
                    secondImg.setVisibility(View.INVISIBLE);
                    thirdImg.setVisibility(View.VISIBLE);
                }else if (index == 0){
                    firstImg.setVisibility(View.VISIBLE);
                    secondImg.setVisibility(View.INVISIBLE);
                    thirdImg.setVisibility(View.INVISIBLE);
                }
                index --;
            }
        });

        Button nextBtn = (Button) findViewById(R.id.button2);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (index == 1) {
                    firstImg.setVisibility(View.INVISIBLE);
                    secondImg.setVisibility(View.VISIBLE);
                    thirdImg.setVisibility(View.INVISIBLE);
                }else if(index == 2){
                    firstImg.setVisibility(View.INVISIBLE);
                    secondImg.setVisibility(View.INVISIBLE);
                    thirdImg.setVisibility(View.VISIBLE);
                }
            }
        });

    }

    /*public View setImageIndex(ImageView imageView,Button btn){
        System.out.println(imageView.getDrawable());
    }*/


}
