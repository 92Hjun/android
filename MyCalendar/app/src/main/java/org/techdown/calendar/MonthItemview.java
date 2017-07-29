package org.techdown.calendar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by fribel on 2017-07-22.
 */

public class MonthItemview extends RelativeLayout {


    TextView textView;

    public MonthItemview(Context context) {
        super(context);
        init(context);
    }

    public MonthItemview(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init (Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.month_item, this, true);

         textView = (TextView)findViewById(R.id.textView);
    }

    public void setDay (int dayNumber) {
        textView.setText(String.valueOf(dayNumber));
    }

}
