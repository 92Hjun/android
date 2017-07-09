package org.techdown.toast;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Toast toast = Toast.makeText(getApplicationContext(),"위치가 바뀐 토스트",Toast.LENGTH_LONG);
                // UI구성시 gravity와 속성이 비슷함,
                toast.setGravity(Gravity.TOP|Gravity.LEFT,200,200);
                toast.show();
            }
        });
        Button button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 코드를 찾아 객체화 시킨후 사용한다.
                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.toastborder, (ViewGroup) findViewById(R.id.toast_layout_root));

                TextView textView = (TextView) layout.findViewById(R.id.text);

                textView.setText("Hello change shapeToast");

                // activity와 context를 넣어줬을때 다르게 실행될 수 있다.
                Toast toast = new Toast(getApplicationContext());

                toast.setGravity(Gravity.CENTER, 0, -100);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setView(layout);
                toast.show();

            }
        });
        Button button3 = (Button)findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"스낵바 입니다.",Snackbar.LENGTH_LONG).show();
            }
        });

    }
}
