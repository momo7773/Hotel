package com.ecnu;

import java.util.Calendar;

public class LondonTime extends UTCTime{
    private int deviationToUtc;
    private Calendar Time;

    LondonTime(UTCTime utc){
        super(utc.getTime());
        this.deviationToUtc = 0;
        this.Time = Calendar.getInstance();
        this.Time.set(utc.getTime().get(Calendar.YEAR),utc.getTime().get(Calendar.MONTH),utc.getTime().get(Calendar.DATE),utc.getTime().get(Calendar.HOUR_OF_DAY)
                ,utc.getTime().get(Calendar.MINUTE),utc.getTime().get(Calendar.SECOND));
    }
     public void adjust(UTCTime utc){
        System.out.println("use london adjust");
         this.Time.set(utc.getTime().get(Calendar.YEAR),utc.getTime().get(Calendar.MONTH),utc.getTime().get(Calendar.DATE),utc.getTime().get(Calendar.HOUR_OF_DAY)
                 ,utc.getTime().get(Calendar.MINUTE),utc.getTime().get(Calendar.SECOND));
        this.Time.add(Calendar.HOUR_OF_DAY,this.deviationToUtc);
     }

    public Calendar getTime() {

        return this.Time;
    }

    public int getDeviationToUtc() {
        return this.deviationToUtc;
    }
}
