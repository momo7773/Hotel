package com.ecnu;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

class SydneyTimeTest {
    private Calendar currentTime;
    private UTCTime stdTime;
    private SydneyTime sTime;
    @BeforeEach
    public void before(){
        this.currentTime = Calendar.getInstance();
        this.currentTime.set(2019,9,19,20,17,10);
        this.stdTime  = new UTCTime(this.currentTime);
        this.sTime = new SydneyTime(this.stdTime);
    }
    @Test
    void sydney_time_should_be_10_hours_earlier_than_utc_time() {
        Calendar newTime = Calendar.getInstance();
        newTime.set(2019,9,20,8,19,3);
        UTCTime newUtc = new UTCTime(newTime);
        this.sTime.adjust(newUtc);

        Calendar correctsTime = Calendar.getInstance();
        correctsTime.set(2019,9,20,18,19,3);

        Assert.assertEquals(correctsTime.get(Calendar.YEAR),this.sTime.getTime().get(Calendar.YEAR));
        Assert.assertEquals(correctsTime.get(Calendar.MONTH),this.sTime.getTime().get(Calendar.MONTH));
        Assert.assertEquals(correctsTime.get(Calendar.DATE),this.sTime.getTime().get(Calendar.DATE));
        Assert.assertEquals(correctsTime.get(Calendar.HOUR_OF_DAY),this.sTime.getTime().get(Calendar.HOUR_OF_DAY));
        Assert.assertEquals(correctsTime.get(Calendar.MINUTE),this.sTime.getTime().get(Calendar.MINUTE));
        Assert.assertEquals(correctsTime.get(Calendar.SECOND),this.sTime.getTime().get(Calendar.SECOND));
    }
}