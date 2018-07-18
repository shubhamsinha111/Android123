package com.example.shubham.jsonapp;

public class Temperature {
    String Date,MinTemp,MaxTemp,Link;

    public java.lang.String getDate() {
        return Date;
    }
    public void setDate(String date)
    {
        Date = date;
    }

    public String getMinTemp() {
        return MinTemp;
    }

    public void setMinTemp(String minTemp) {
        MinTemp = minTemp;
    }

    public void setMaxTemp(String maxTemp) {
        MaxTemp = maxTemp;
    }

    public String getMaxTemp() {
        return MaxTemp;
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }



}
