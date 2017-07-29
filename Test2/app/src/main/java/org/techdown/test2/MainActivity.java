package org.techdown.test2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.KeyListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        textView = (TextView) findViewById(R.id.textView2);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int before, int count) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                int textLength = charSequence.toString().trim().getBytes().length;
                if (textLength > 80) {
                    Toast.makeText(getApplicationContext(),"문자의 길이제한",Toast.LENGTH_SHORT).show();
                    textView.setText("0 / 80 bytes");
                    editText.setText("");
                }
                textView.setText(textLength + " / 80 bytes");
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


    }
}
