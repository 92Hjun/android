package org.techdown.thread;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    ValueHandler handler = new ValueHandler();

    Handler handler2 = new ValueHandler();

    //int value = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //BackgroundThread thread = new BackgroundThread();
                //thread.start();

                new Thread(new Runnable() {
                    boolean running = false;
                    int value = 0;

                    public void run() {
                        running = true;
                        while (running) {
                            value += 1;

                            handler2.post(new Runnable() {
                                public void run() {
                                    textView.setText("현재값 : " + value);
                                }
                            });

                            try {
                                Thread.sleep(1000);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }).start();

            }
        });
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //textView.setText("현재 값 : " + value);
            }
        });

    }
/*  스레드 상속 내부 클래스
    class BackgroundThread extends Thread{
        boolean running = false;
        int value = 0;
        @Override
        public void run() {
            running = true;
            while (running) {
                value += 1;
                //메인스레드가 아니므로 접근못함.
                //textView.setText("현재 값 : " + value);

                // 핸들러 사용
                Message message = handler.obtainMessage();
                Bundle bundle = new Bundle();
                bundle.putInt("value", value);
                message.setData(bundle);
                handler.sendMessage(message);

                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }*/

    // 핸들러 상속 내부 클래스
    class ValueHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            Bundle bundle = msg.getData();
            int value = bundle.getInt("value");
            textView.setText("현재값 : " + value);
        }
    }

}
