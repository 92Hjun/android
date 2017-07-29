package org.techdown.http;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;
    String urlStr;

    Handler handler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        textView = (TextView) findViewById(R.id.textView);

        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                urlStr = editText.getText().toString();
                RequestThread thread = new RequestThread();
                thread.start();

            }
        });

    }

    class RequestThread extends Thread{
        public void run() {

            try {
                URL url = new URL(urlStr);

                HttpURLConnection conn =  (HttpURLConnection) url.openConnection();
                if (conn != null) {
                    conn.setConnectTimeout(10000);
                    conn.setRequestMethod("GET");

                    // 웹 입출력 가능
                    conn.setDoInput(true);
                    conn.setDoOutput(true);

                    // 정상적인 코드가 넘어오면 200
                    int resCode = conn.getResponseCode();

                    // reader는 한줄씩 읽음
                    BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    String line = null;

                    while (true) {

                        line = reader.readLine();

                        if (line == null) {
                            break;
                        }

                        println(line);
                    }
                    reader.close();
                    conn.disconnect();

                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public void println(final String msg){
        handler.post(new Runnable() {
            @Override
            public void run() {
                textView.append(msg + "\n");
            }
        });
    }



}
