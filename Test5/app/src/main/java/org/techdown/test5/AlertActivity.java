package org.techdown.test5;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by fribel on 2017-07-14.
 */

public class AlertActivity extends AppCompatActivity {

    EditText yearEdit;
    EditText monthEdit;
    EditText dayEdit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert);

        yearEdit = (EditText) findViewById(R.id.editText3);
        monthEdit = (EditText) findViewById(R.id.editText4);
        dayEdit = (EditText) findViewById(R.id.editText5);

        Button savedBtn = (Button) findViewById(R.id.button3);
        savedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);

                String year = yearEdit.getText().toString();
                String month = monthEdit.getText().toString();
                String day = dayEdit.getText().toString();

                Toast.makeText(getApplicationContext(),year+month+day,Toast.LENGTH_SHORT).show();
                intent.putExtra("date",year +" 년" + month + " 월" + day +" 일");
                startActivityForResult(intent, 101);

            }
        });
        Button exitBtn = (Button) findViewById(R.id.button4);
        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
