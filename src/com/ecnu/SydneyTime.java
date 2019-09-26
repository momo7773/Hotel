
package com.ecnu;

import java.util.Calendar;

public class SydneyTime extends UTCTime{
    private int deviationToUtc;
    private Calendar Time;

    public SydneyTime(UTCTime utc) {
        super(utc.getTime());
        this.deviationToUtc = 10;
        this.Time = Calendar.getInstance();
        this.Time.set(utc.getTime().get(Calendar.YEAR),utc.getTime().get(Calendar.MONTH),utc.getTime().get(Calendar.DATE),utc.getTime().get(Calendar.HOUR_OF_DAY)
                ,utc.getTime().get(Calendar.MINUTE),utc.getTime().get(Calendar.SECOND));
        this.Time.add(Calendar.HOUR_OF_DAY,this.deviationToUtc);
    }

    public void adjust(UTCTime utc){
        this.Time.set(utc.getTime().get(Calendar.YEAR),utc.getTime().get(Calendar.MONTH),utc.getTime().get(Calendar.DATE),utc.getTime().get(Calendar.HOUR_OF_DAY)
                ,utc.getTime().get(Calendar.MINUTE),utc.getTime().get(Calendar.SECOND));
        System.out.println("use sydney adjust");
        this.Time.add(Calendar.HOUR_OF_DAY,this.deviationToUtc);
        int year = this.Time.get(Calendar.YEAR);
        int month = this.Time.get(Calendar.MONTH);
        int day = this.Time.get(Calendar.DATE);
        int hour = this.Time.get(Calendar.HOUR_OF_DAY);
        int minute = this.Time.get(Calendar.MINUTE);
        int second = this.Time.get(Calendar.SECOND);
        String hint = "the Sydney time is: " + year + "/" + month + "/" + day + " " + hour + ":" + minute + ":" + second;
        System.out.println(hint);
    }
    public Calendar getTime() {

        return this.Time;
    }

    public int getDeviationToUtc() {
        return deviationToUtc;
    }
}
