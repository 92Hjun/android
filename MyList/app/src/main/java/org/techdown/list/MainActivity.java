package org.techdown.list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SingerAdapter adapter;

    EditText editText;
    EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);

        ListView listView = (ListView) findViewById(R.id.listView);

        adapter = new SingerAdapter();

        adapter.addItem(new SingerItem("소녀시대", "010-0000-9872",R.drawable.icon01));
        adapter.addItem(new SingerItem("레인보우", "010-8725-0000",R.drawable.icon02));
        adapter.addItem(new SingerItem("으앙", "010-7825-8830",R.drawable.icon03));
        adapter.addItem(new SingerItem("테스트데이터", "010-8724-0781",R.drawable.icon04));
        adapter.addItem(new SingerItem("은비짱", "010-03250-0780",R.drawable.icon05));

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                SingerItem singerItem = (SingerItem) adapter.getItem(position);
                Toast.makeText(getApplicationContext(),"선택 : " + singerItem.getName(), Toast.LENGTH_LONG).show();
            }
        });

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editText.getText().toString();
                String mobile =editText2.getText().toString();

                adapter.addItem(new SingerItem(name,mobile,R.drawable.icon06));
                // 어댑터에서 리스트로 갱신하라고 알려주는 메소드
                adapter.notifyDataSetChanged();

            }
        });


    }
    
    // 어댑터 정의
    class SingerAdapter extends BaseAdapter {

        ArrayList<SingerItem> items = new ArrayList<SingerItem>();

        @Override
        // 아이템 갯수 호출
        public int getCount() {
            return items.size();
        }

        public void addItem (SingerItem singerItem) {

            items.add(singerItem);

        }

        @Override
        // 아이템 호출
        public Object getItem(int i) {
            return items.get(i);
        }

        @Override
        // 아이디를 통한 아이템 호출
        public long getItemId(int i) {
            return i;
        }

        @Override
        // 부분화면 생성후 데이터입력다음 리턴
        public View getView(int i, View view, ViewGroup viewGroup) {

            // 데이터가 많으면 객체를 매번 생성하기 때문에
            // view가 null이면 생성하고 원래 view가 있으면 원래있던 view를 활용해서 데이터만 바꾼후 사용한다.
            if (view == null) {
                view = new SingerItemView(getApplicationContext());
            }else {
                view = (SingerItemView) view;
            }
            SingerItemView singerItemView = new SingerItemView(getApplicationContext());

            SingerItem item = items.get(i);

            singerItemView.setName(item.getName());
            singerItemView.setMobile(item.getMobile());
            singerItemView.setImage(item.getResId());

            return singerItemView;
        }
    }
}
