package org.techdown.progress;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    ProgressBar progressBar;

    Handler handler = new Handler();

    CompletionThread completionThread;


    String msg = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /* handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ProgressThread thread = new ProgressThread();
                        thread.start();
                    }
                },5000);*/
                ProgressTask task = new ProgressTask();
                task.execute("시작");


            }
        });
        completionThread = new CompletionThread();
        completionThread.start();

    }

    // AsyncTask1
    class ProgressTask extends AsyncTask<String, Integer, Integer> {
        int value = 0;


        @Override
        // 스레드 내부 코드 입력 String... < 가변길이 문자열타입
        protected Integer doInBackground(String... params) {
            while (true) {
                if (value > 100) {
                    break;
                }
                value += 1;
                // 메소드가 사용되면 onProgressUpdate호출한다.
                publishProgress(value);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return value;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBar.setProgress(values[0].intValue());
        }

        @Override
        // 완료되면 실행한다.
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);

            Toast.makeText(getApplicationContext(),"완료됨", Toast.LENGTH_SHORT).show();

        }
    }

    // 스레드1
    class ProgressThread extends  Thread {
        int value = 0;
        @Override
        public void run() {
            while (true) {
                if (value > 100) {
                    break;
                }
                value += 1;
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.setProgress(value);
                    }
                });
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            completionThread.cimpletionHandler.post(new Runnable() {
                @Override
                public void run() {
                    msg = "OK";

                    Log.d("MainActivity", "메시지 : " + msg);
                }
            });
        }
    }

    class CompletionThread extends  Thread {

        public Handler cimpletionHandler = new Handler();

        public void run() {

            Looper.prepare();
            Looper.loop();

        }
    }

}
