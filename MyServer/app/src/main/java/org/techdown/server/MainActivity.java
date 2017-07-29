package org.techdown.server;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* ServerThread thread = new ServerThread();
                thread.start();*/

                Intent intent = new Intent(getApplicationContext(), ServerService.class);
                startService(intent);
            }
        });
    }


/*
    class ServerThread extends Thread{
        @Override
        public void run() {
            int port = 5001;

            try {
                ServerSocket server = new ServerSocket(port);
                Log.d("ServerThread", "서버가 실행됨");

                while (true) {
                    Socket socket = server.accept();

                    ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                    Object input = in.readObject();

                    Log.d("ServerThread", "input : " + input);

                    ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                    out.writeObject(input + " from Server");

                    out.flush();

                    Log.d("Server Thread", "output 보냄");

                    out.close();
                    in.close();
                    socket.close();

                }


            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }*/
}
