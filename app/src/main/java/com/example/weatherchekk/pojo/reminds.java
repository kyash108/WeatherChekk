package com.example.weatherchekk.pojo;

import android.os.Parcel;
import android.os.Parcelable;

public class reminds implements Parcelable {

    /**
     * Getter and setters for the reminder page
     * @author - Yash Kumar
     *
     */

    private int id;
    private String hour;
    private String minute;
    private String am;
    private String city;
    private String edit;

    public reminds() {

    }


    protected reminds(Parcel in) {
        id = in.readInt();
        hour = in.readString();
        minute = in.readString();
        am = in.readString();
        city = in.readString();
        edit = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(hour);
        dest.writeString(minute);
        dest.writeString(am);
        dest.writeString(city);
        dest.writeString(edit);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<reminds> CREATOR = new Creator<reminds>() {
        @Override
        public reminds createFromParcel(Parcel in) {
            return new reminds(in);
        }

        @Override
        public reminds[] newArray(int size) {
            return new reminds[size];
        }
    };

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getMinute() {
        return minute;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMinute(String minute) {
        this.minute = minute;
    }

    public String getAm() {
        return am;
    }

    public void setAm(String am) {
        this.am = am;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEdit() {
        return edit;
    }

    public void setEdit(String edit) {
        this.edit = edit;
    }

    public reminds(String hour, String minute, String am, String city) {
        this.hour = hour;
        this.minute = minute;
        this.am = am;
        this.city = city;
//        this.edit = edit;
    }

    public reminds(int id, String hour, String minute, String am, String city) {
        this.id = id;
        this.hour = hour;
        this.minute = minute;
        this.am = am;
        this.city = city;
    }

    public reminds(int id, String hour, String minute, String am, String city, String edit) {
        this.id = id;
        this.hour = hour;
        this.minute = minute;
        this.am = am;
        this.city = city;
        this.edit = edit;
    }

    @Override
    public String toString() {
        return city;
    }
}
