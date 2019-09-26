package com.ecnu;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

class NewYorkTimeTest {
    private Calendar currentTime;
    private UTCTime stdTime;
    private NewYorkTime nyTime;
    @BeforeEach
    public void before(){
        this.currentTime = Calendar.getInstance();
        this.currentTime.set(2019,9,19,20,17,10);
        this.stdTime  = new UTCTime(this.currentTime);
        this.nyTime = new NewYorkTime(this.stdTime);
    }
    @Test
    void ny_time_should_be_5_hours_later_than_utc_time() {
        Calendar newTime = Calendar.getInstance();
        newTime.set(2019,9,20,8,19,3);
        UTCTime newUtc = new UTCTime(newTime);
        this.nyTime.adjust(newUtc);

        Calendar correctnyTime = Calendar.getInstance();
        correctnyTime.set(2019,9,20,3,19,3);

        Assert.assertEquals(correctnyTime.get(Calendar.YEAR),this.nyTime.getTime().get(Calendar.YEAR));
        Assert.assertEquals(correctnyTime.get(Calendar.MONTH),this.nyTime.getTime().get(Calendar.MONTH));
        Assert.assertEquals(correctnyTime.get(Calendar.DATE),this.nyTime.getTime().get(Calendar.DATE));
        Assert.assertEquals(correctnyTime.get(Calendar.HOUR_OF_DAY),this.nyTime.getTime().get(Calendar.HOUR_OF_DAY));
        Assert.assertEquals(correctnyTime.get(Calendar.MINUTE),this.nyTime.getTime().get(Calendar.MINUTE));
        Assert.assertEquals(correctnyTime.get(Calendar.SECOND),this.nyTime.getTime().get(Calendar.SECOND));
    }
}