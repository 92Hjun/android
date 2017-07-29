 package org.techdown.soket;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.Socket;

 public class MainActivity extends AppCompatActivity {

     TextView textView;

     Handler handler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClientThread thread = new ClientThread();

                thread.start();
            }
        });

    }

    class ClientThread extends Thread{
        @Override
        public void run() {
            String host = "localhost";
            int port = 5001;

            try {
                Socket socket = new Socket(host,port);

                ObjectOutput out = new ObjectOutputStream(socket.getOutputStream());
                out.writeObject("하이");
                out.flush();
                Log.d("ClientThread", "서버로 보냄");

                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

                final Object input = in.readObject();

                Log.d("Client Thread", "받은데이터 : " + input);

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText("받은데이터 : " + input);
                    }
                });


            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
