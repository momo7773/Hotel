package com.ecnu;

import java.util.Calendar;

public class MoscowTime extends UTCTime{
    private Calendar Time;
    private int deviationToUtc;

    MoscowTime(UTCTime utc){
        super(utc.getTime());
        this.deviationToUtc = 4;
        this.Time = Calendar.getInstance();
        this.Time.set(utc.getTime().get(Calendar.YEAR),utc.getTime().get(Calendar.MONTH),utc.getTime().get(Calendar.DATE),utc.getTime().get(Calendar.HOUR_OF_DAY)
                ,utc.getTime().get(Calendar.MINUTE),utc.getTime().get(Calendar.SECOND));
        this.Time.add(Calendar.HOUR_OF_DAY,this.deviationToUtc);
    }
    public void adjust(UTCTime utc){
        this.Time.set(utc.getTime().get(Calendar.YEAR),utc.getTime().get(Calendar.MONTH),utc.getTime().get(Calendar.DATE),utc.getTime().get(Calendar.HOUR_OF_DAY)
                ,utc.getTime().get(Calendar.MINUTE),utc.getTime().get(Calendar.SECOND));
        System.out.println("use moscow adjust");
        this.Time.add(Calendar.HOUR_OF_DAY,this.deviationToUtc);
    }

    public Calendar getTime() {
        return this.Time;
    }

    public int getDeviationToUtc() {
        return this.deviationToUtc;
    }
}
