package org.techdown.baseball;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText)findViewById(R.id.editText);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                String textNumber = "";
                int number =0;
                for (int i=0; i<3; i++) {
                    number = random.nextInt(10);
                    textNumber += String.valueOf(number) + ",";
                }
                String[] arrayText = textNumber.split(",");

                String numString = editText.getText().toString();
                System.out.println(numString);
            }
        });

    }
}
