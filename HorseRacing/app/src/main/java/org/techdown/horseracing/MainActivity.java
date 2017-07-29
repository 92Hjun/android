package org.techdown.horseracing;

import android.net.NetworkInfo;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ProgressBar hors1;
    ProgressBar hors2;
    ProgressBar hors3;
    Handler handler = new Handler();
    Random random = new Random();

    TextView textView;
    TextView textView2;
    TextView textView3;

    ArrayList<String> textList = new ArrayList<>();

    int value1 = 0;
    int value2 = 0;
    int value3 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            hors1 = (ProgressBar) findViewById(R.id.progressBar);
            hors2 = (ProgressBar) findViewById(R.id.progressBar2);
            hors3 = (ProgressBar) findViewById(R.id.progressBar3);

            textView = (TextView) findViewById(R.id.textView7);
            textView2 = (TextView) findViewById(R.id.textView8);
            textView3 = (TextView) findViewById(R.id.textView9);

            Button button = (Button)findViewById(R.id.button);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    HorsOneThread thread1 = new HorsOneThread();
                    thread1.start();
                    HorsTwoThread thread2 = new HorsTwoThread();
                    thread2.start();
                    HorsThreeThread thread3 = new HorsThreeThread();
                    thread3.start();
                }
            });

            Button button2 = (Button) findViewById(R.id.button2);
            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    textView.setText(textList.get(0));
                    textView2.setText(textList.get(1));
                    textView3.setText(textList.get(2));
                }
            });
    }

    class HorsOneThread extends Thread {
        @Override
        public void run() {
           while (true){
               value1 += random.nextInt(9);
               handler.post(new Runnable() {
                   public void run() {
                       hors1.setProgress(value1);
                   }
               });
               try {
                   Thread.sleep(500);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               if (value1 >= 100) {
                   textList.add("1번");
                   break;
               }

           }
        }
    }

    class HorsTwoThread extends  Thread {
        @Override
        public void run() {
            while (true) {
                value2 += random.nextInt(9);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        hors2.setProgress(value2);
                    }
                });
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (value2 >= 100) {
                    textList.add("2번");
                    break;
                }
            }
        }
    }

    class HorsThreeThread extends  Thread {
        @Override
        public void run() {
            while (true) {
                value3 += random.nextInt(9);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        hors3.setProgress(value3);
                    }
                });

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (value3 >= 100) {
                    textList.add("3번");
                    break;
                }
            }
        }
    }
}
