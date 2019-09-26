package com.ecnu;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

class BeijingTimeTest {
    private Calendar currentTime;
    private UTCTime stdTime;
    private BeijingTime bjTime;
    @BeforeEach
    public void before(){
        this.currentTime = Calendar.getInstance();
        this.currentTime.set(2019,9,19,20,17,10);
        this.stdTime  = new UTCTime(this.currentTime);
        this.bjTime = new BeijingTime(this.stdTime);
        }
    @Test
    public void beijingTime_should_be_8_hours_earlier_than_utc_time_after_change() {
        Calendar newTime = Calendar.getInstance();
        newTime.set(2019,9,20,8,19,3);
        UTCTime newUtc = new UTCTime(newTime);
        this.bjTime.adjust(newUtc);

        Calendar correctBjTime = Calendar.getInstance();
        correctBjTime.set(2019,9,20,16,19,3);

        Assert.assertEquals(correctBjTime.get(Calendar.YEAR),this.bjTime.getTime().get(Calendar.YEAR));
        Assert.assertEquals(correctBjTime.get(Calendar.MONTH),this.bjTime.getTime().get(Calendar.MONTH));
        Assert.assertEquals(correctBjTime.get(Calendar.DATE),this.bjTime.getTime().get(Calendar.DATE));
        Assert.assertEquals(correctBjTime.get(Calendar.HOUR_OF_DAY),this.bjTime.getTime().get(Calendar.HOUR_OF_DAY));
        Assert.assertEquals(correctBjTime.get(Calendar.MINUTE),this.bjTime.getTime().get(Calendar.MINUTE));
        Assert.assertEquals(correctBjTime.get(Calendar.SECOND),this.bjTime.getTime().get(Calendar.SECOND));

    }
}