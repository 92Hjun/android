package org.techdown.test1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView firstImg;
    ImageView secondImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstImg = (ImageView) findViewById(R.id.imageView);
        secondImg = (ImageView) findViewById(R.id.imageView2);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstImg.setImageResource(R.drawable.dream02);
                secondImg.setImageResource(R.drawable.dream01);

            }
        });

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstImg.setImageResource(R.drawable.dream01);
                secondImg.setImageResource(R.drawable.dream02);
            }
        });

    }
}
