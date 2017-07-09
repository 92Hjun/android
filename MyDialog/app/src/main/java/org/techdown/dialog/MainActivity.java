package org.techdown.dialog;

import android.content.DialogInterface;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
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

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMessage(view);
            }
        });
    }

    public void showMessage(final View view) {

        // AlertDialog 생성
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        // title 지정
        builder.setTitle("안내");

        // message 지정
        builder.setMessage("종료하시겠습니까?");

        // AlertDialog 형태 지정
        builder.setIcon(android.R.drawable.ic_dialog_alert);

        // 긍정 버튼 클릭시 실행할 코드
        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Snackbar.make(view,"yes 버튼이 눌렸습니다.", Snackbar.LENGTH_LONG).show();
            }
        });

        // 부정 버튼 클릭시 실행할 코드
        builder.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Snackbar.make(view,"no 버튼이 눌렸습니다.", Snackbar.LENGTH_LONG).show();
            }
        });

        // 생성되는 시점
        AlertDialog dialog = builder.create();

        // 화면에 보여주게됨.
        dialog.show();


    }
}
