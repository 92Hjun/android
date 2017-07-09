package org.techdown.progress;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.editText);

        // 프로그레스바 객체 찾기
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // 입력 데이터 찾기
                String inputStr = editText.getText().toString().trim();

                // 입력데이터 int 변환
                int number = Integer.parseInt(inputStr);

                // 프로그레스바에 데이터 저장
                progressBar.setProgress(number);
            }
        });
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               showProgressDialog();
            }
        });

        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        // seekBar가 변경될때 실행시키는 메소드
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            // 변경될때 호출
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                editText.setText(String.valueOf(i));
            }

            @Override
            // 변경되기 시작시에 호출
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            // 변경되고 종료시에 호출
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }


    // 프로그레스바 알림창
    public void showProgressDialog() {
        // 프로그레스바 생성
        ProgressDialog dialog = new ProgressDialog(this);

        // 프로그레스바 스타일 지정
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);

        // 프로그레스바 알림창 확인
        dialog.setMessage("데이터 확인중...");

        // 프로그레스바 보여주기.
        dialog.show();
    }
}
