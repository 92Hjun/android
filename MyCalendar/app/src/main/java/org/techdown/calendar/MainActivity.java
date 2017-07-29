package org.techdown.calendar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    TextView monthText;
    GridView monthView;
    MonthAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        monthText = (TextView) findViewById(R.id.monthText);
        monthView = (GridView) findViewById(R.id.monthView);

        adapter = new MonthAdapter();

        monthView.setAdapter(adapter);

        monthText.setText(adapter.getCurrentYear() + " 년 " + adapter.getCurMonth() + "월");


        Button monthPrevious  = (Button) findViewById(R.id.monthPrevious);
        Button monthNext = (Button) findViewById(R.id.monthNext);

        monthPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.setPreviousMonth();
                adapter.notifyDataSetChanged();
                monthText.setText(adapter.getCurrentYear() + " 년 " + adapter.getCurMonth() + "월");
            }
        });
        monthNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.setNextMonth();
                adapter.notifyDataSetChanged();
                monthText.setText(adapter.getCurrentYear() + " 년 " + adapter.getCurMonth() + "월");
            }
        });


    }

    class MonthAdapter extends BaseAdapter {

        MonthItem[] items;

        Calendar calendar;
        int firstDay;
        int lastDay;
        int curYear;
        int curMonth;

        public int getCurrentYear() {
            return curYear;
        }

        public int getCurMonth() {
            return curMonth;
        }


        public MonthAdapter() {
            items =  new MonthItem[7 * 6];

            Date date = new Date();

            calendar = Calendar.getInstance();
            calendar.setTime(date);

            recalculate();
            resetDayNumbers();
        }

        public void setPreviousMonth () {
            calendar.add(Calendar.MONTH,-1);

            recalculate();
            resetDayNumbers();
        }

        public void setNextMonth () {
            calendar.add(Calendar.MONTH, 1);

            recalculate();
            resetDayNumbers();
        }

        public void recalculate () {
            calendar.set(Calendar.DAY_OF_MONTH, 1);

            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
            firstDay = getFirstDay(dayOfWeek);

            curYear = calendar.get(Calendar.YEAR);
            curMonth = calendar.get(Calendar.MONTH);
            lastDay = getLastDay();
        }

        public void resetDayNumbers(){
            for (int i=0 ; i < 42; i++){
                int dayNumber = (i+1) - firstDay;
                if (dayNumber < 1 || dayNumber > lastDay) {
                    dayNumber = 0;
                }

                items[i] = new MonthItem(dayNumber);


            }
        }

        public int getLastDay() {

            switch (curMonth) {
                case 0:
                case 2:
                case 4:
                case 6:
                case 7:
                case 9:
                case 11:
                    return 31;

                case 3:
                case 5:
                case 8:
                case 10:
                    return 30;
                default:
                    if (((curYear%4 == 0) &&(curYear % 100 != 0)) || curYear % 400 == 0) {
                        return 29;
                    } else {
                        return 28;
                    }
            }
        }

        public int getFirstDay (int dayOfWeek) {
            int result = 0;
            if (dayOfWeek == Calendar.SUNDAY) {
                result = 0;
            } else if (dayOfWeek == Calendar.MONDAY) {
                result = 1;
            } else if (dayOfWeek == Calendar.TUESDAY) {
                result = 2;
            } else if (dayOfWeek == Calendar.WEDNESDAY) {
                result = 3;
            } else if (dayOfWeek == Calendar.THURSDAY) {
                result = 4;
            } else if (dayOfWeek == Calendar.FRIDAY) {
                result = 5;
            } else if (dayOfWeek == Calendar.SATURDAY) {
                result = 6;
            }

            return result;
        }


        @Override
        public int getCount() {
            return 42;
        }

        @Override
        public Object getItem(int index) {
            return items[index];
        }

        @Override
        public long getItemId(int index) {
            return index;
        }

        @Override
        public View getView(int index, View view, ViewGroup viewGroup) {
            MonthItemview monthItemview = null;
            if (view ==null) {
                monthItemview = new MonthItemview(getApplicationContext());
            }else {
                monthItemview = (MonthItemview) view;
            }

            monthItemview.setDay(items[index].day);

            return monthItemview;
        }
    }
}
