package org.techdown.picker;

import android.widget.DatePicker;

/**
 * Created by fribel on 2017-07-22.
 */

public interface OnDateTimeChangeListener {

    public void onDateTimeChange(DateTimePicker view, int year, int monthOfYeat, int dayOfMonth, int hour, int minute);

}
