package org.techdown.hello;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // alert 과 비슷한기능
    public void onButton1Clicked(View v) {
        Toast.makeText(this, "버튼이 클릭되었습니다.", Toast.LENGTH_LONG).show();

        // Menu Activity와의 연동
        // this (현재 화면클래스지정, 돌아갈 화면의 클래스지정);
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }

    // WebPage Link 기능
    public void onButton2Clicked(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"));
        startActivity(intent);
    }

    // WebPage Link 기능과 비슷한데 Uri.parse("내부") / 내부에 tel:전화번호 를 입력하면
    // 전화거는 창으로 link 된다.
    public void onButton3Clicked(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:010-8714-7248"));
        startActivity(intent);
    }
}
