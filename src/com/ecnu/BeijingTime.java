package com.ecnu;

import java.util.Calendar;

public class BeijingTime extends UTCTime{
    private int deviationToUtc;
    private Calendar Time;

    public BeijingTime(UTCTime utc) {
        super(utc.getTime());
        this.Time = Calendar.getInstance();
        this.Time.set(utc.getTime().get(Calendar.YEAR),utc.getTime().get(Calendar.MONTH),utc.getTime().get(Calendar.DATE),utc.getTime().get(Calendar.HOUR_OF_DAY)
                ,utc.getTime().get(Calendar.MINUTE),utc.getTime().get(Calendar.SECOND));
        this.deviationToUtc = 8;
        this.Time.add(Calendar.HOUR_OF_DAY,this.deviationToUtc);
    }

    public Calendar getTime() {
        return this.Time;
    }

    public void adjust(UTCTime utc){
        this.Time.set(utc.getTime().get(Calendar.YEAR),utc.getTime().get(Calendar.MONTH),utc.getTime().get(Calendar.DATE),utc.getTime().get(Calendar.HOUR_OF_DAY)
                ,utc.getTime().get(Calendar.MINUTE),utc.getTime().get(Calendar.SECOND));
        this.Time.add(Calendar.HOUR_OF_DAY,this.deviationToUtc);
    }

    public int getDeviationToUtc() {
        return this.deviationToUtc;
    }

}
