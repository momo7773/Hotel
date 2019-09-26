package com.ecnu;

import java.util.Calendar;

public class UTCTime {
    private Calendar Time;

    public UTCTime(Calendar time){
        this.Time = time;
    }
    public void adjustBasedOnMobile(MobileTime mTime){
        int deviation = mTime.getDeviationToUtc() *  -1;
        this.Time = mTime.getTime();
        this.Time.add(Calendar.HOUR_OF_DAY,deviation);
    }

    public Calendar getTime() {
        return this.Time;
    }
    public void adjust(UTCTime utc){
        System.out.println("use utc adjust");
        this.Time.add(Calendar.HOUR_OF_DAY,0);
    }
    


}
