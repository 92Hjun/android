package org.techdown.parcelable;

import android.os.Parcel;
import android.os.Parcelable;

/**
 *
 */

public class SimpleData implements Parcelable {

    int number;
    String message;

    public SimpleData(int number, String message) {
        this.number = number;
        this.message = message;
    }

    // 객체안에 있는 데이터를 전달할때 사용되는 객체.
    public SimpleData(Parcel src) {
        number = src.readInt();
        message = src.readString();
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public SimpleData createFromParcel(Parcel src) {
            return new SimpleData(src);
        }

        public SimpleData[] newArray(int size) {
            return new SimpleData[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(number);
        parcel.writeString(message);
    }
}
