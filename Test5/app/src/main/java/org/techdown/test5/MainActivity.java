package org.techdown.test5;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    EditText nameEdit;

    EditText ageEdit;


    EditText yearEdit;
    EditText monthEdit;
    EditText dayEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button birthBtn = (Button) findViewById(R.id.button2);

        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");

        String nowText = sdf.format(now);
        birthBtn.setText(nowText);

        birthBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDialog(v);
            }
        });

    }

    public void addDialog (View v) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);

        alert.setTitle("생년월일 설정");
        alert.setView(R.layout.activity_alert);

        Dialog dialog = alert.create();
        Button button = (Button) dialog.findViewById(R.id.button3);
        dialog.show();
    }
}
