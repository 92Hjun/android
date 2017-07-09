package org.techdown.lifecycle;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "onCreate 호출", Toast.LENGTH_LONG).show();

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


    // 주로사용되는 수명주기 메소드의 종류
    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "onStart 호출", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "onStop 호출", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy 호출", Toast.LENGTH_LONG).show();
    }


    // 가장중요 ex)필요한 데이터를저장
    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "onPause 호출", Toast.LENGTH_LONG).show();
        // SharedPreferences은 임시저장소 개념
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);

        // inner Class
        SharedPreferences.Editor editor = pref.edit();

        // key value 값으로 문자열 저장
        editor.putString("name", "홍길동");

        // 저장시 필수
        editor.commit();
    }

    // 가장중요
    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onResume 호출", Toast.LENGTH_LONG).show();

        // SheredPreferences 찾기.
        SharedPreferences pref = getSharedPreferences("pref",Activity.MODE_PRIVATE);
        if (pref != null) {
            // pref에 저장되어있는 이름을 key값으로 꺼내는데 없다면 공백을 return
            String name = pref.getString("name", "");
            Toast.makeText(this,"복구된 이름 : " + name, Toast.LENGTH_LONG).show();
        }

    }
}
