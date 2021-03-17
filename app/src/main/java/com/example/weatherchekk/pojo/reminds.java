package com.example.weatherchekk.pojo;

import android.os.Parcel;

public class reminds {
    private int id;
    private int hour;
    private int minute;
    private String am;
    private String city;
    private String edit;


    public int getHour() {
        return hour;
    }
//    protected reminds(Parcel in) {
//        id = in.readInt();
//        city = in.readString();
//        hour = in.readInt();
//        minute = in.readInt();
//        edit = in.readString();
//    }
//
//    public void writeToParcel(Parcel dest, int flags) {
//        dest.writeInt(id);
//        dest.writeString(city);
//        dest.writeInt(hour);
//        dest.writeInt(minute);
//    }


    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMinute(int minute) {
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

//    public reminds(String hour, String minute, String am, String city, String edit) {
//        this.hour = hour;
//        this.minute = minute;
//        this.am = am;
//        this.city = city;
//        this.edit = edit;
//    }

    public reminds(int id, int hour, int minute, String am, String city) {
        this.id = id;
        this.hour = hour;
        this.minute = minute;
        this.am = am;
        this.city = city;
    }

    public reminds(int id, int hour, int minute, String am, String city, String edit) {
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
