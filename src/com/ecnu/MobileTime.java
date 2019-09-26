package com.ecnu;

import java.util.Calendar;

public class MobileTime extends BeijingTime {
    private Calendar Time;

    public MobileTime(UTCTime utc) {
        super(utc);
        this.Time = Calendar.getInstance();
        this.Time.set(utc.getTime().get(Calendar.YEAR),utc.getTime().get(Calendar.MONTH),utc.getTime().get(Calendar.DATE),utc.getTime().get(Calendar.HOUR_OF_DAY)
                ,utc.getTime().get(Calendar.MINUTE),utc.getTime().get(Calendar.SECOND));
        this.Time.add(Calendar.HOUR_OF_DAY,super.getDeviationToUtc());
    }

    public Calendar getTime() {
        return this.Time;
    }

    public void changeTime(int option, int amount,UTCTime[] timePackage){
        this.Time.add(option,amount);
        UTCTime std = timePackage[0];
        std.adjustBasedOnMobile(this);
        for(int i = 1;i<timePackage.length;i++){
            timePackage[i].adjust(std);
        }

    }


}
