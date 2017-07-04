package org.techdown.hello;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void onBackButtonClicked(View v) {
        Toast.makeText(this, "돌아가기 버튼이 눌렸습니다.", Toast.LENGTH_LONG).show();
        // finish(); stack 영역 메소드 임으로 생성자가 필요없고
        // 메소드를 실행하면 화면이 닫힌다. 정확히 말하자면 돌아가기가 아닌 화면이 닫히는것.
        finish();
    }
}
