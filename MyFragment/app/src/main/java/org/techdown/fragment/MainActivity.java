package org.techdown.fragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    MainFragment fragment1;
    MenuFragment fragment2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment1 = new MainFragment();
        fragment2 = new MenuFragment();

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // supportFragmentManager로 생성하였기때문에 supportFragmentManager를 활용,
                // 트랜잭션을 beginTransaction을 생성후 .add()메소드를 활용해
                // 프래그먼트가 들어갈 레이아웃의 아이디, 들어갈 프래그먼트를 매개변수로 넣어준후
                // commit을 하면 실행된다.
                getSupportFragmentManager().beginTransaction().replace( R.id.container,fragment1).commit();

            }
        });

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // replace를 활용하면 이미 생성되어 있으면 그것을 재활용한다.
                getSupportFragmentManager().beginTransaction().replace( R.id.container,fragment2).commit();

            }
        });

    }
    // 메소드를 활용해서 프래그먼트의 화면을 전환해준다.
    // 프래그먼트 끼리는 직접적으로 접근하지 않는다.
    // 그래서 보안에 유리하다.
    // 그리고 액티비티의 생성을 많이하지 않게됨으로
    // 리소스가 간략해진다.
    public void onFragmentChange(int index) {
        if (index == 0) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment1).commit();
        }else if (index == 1) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment2).commit();
        }
    }

}
