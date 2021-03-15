package com.example.weatherchekk.pojo;
public class reminds {
    private String hour;
    private String minute;
    private String am;
    private String city;
    private String edit;

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getMinute() {
        return minute;
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

    public reminds(String hour, String minute, String am, String city, String edit) {
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
