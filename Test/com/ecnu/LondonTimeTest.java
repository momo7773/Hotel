package com.ecnu;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

class LondonTimeTest {
    private Calendar currentTime;
    private UTCTime stdTime;
    private LondonTime lTime;

    @BeforeEach
    public void before ()throws Exception{
        this.currentTime = Calendar.getInstance();
        this.currentTime.set(2019,9,19,20,17,10);
        this.stdTime  = new UTCTime(this.currentTime);
        this.lTime = new LondonTime(this.stdTime);
    }

    @Test
    void london_time_should_be_exactly_the_same_with_utc_time() {
        Calendar newTime = Calendar.getInstance();
        newTime.set(2019,9,20,8,19,3);
        UTCTime newUtc = new UTCTime(newTime);
        this.lTime.adjust(newUtc);
        Calendar correctLtime = Calendar.getInstance();
        correctLtime.set(2019,9,20,8,19,3);

        Assert.assertEquals(correctLtime.get(Calendar.YEAR),this.lTime.getTime().get(Calendar.YEAR));
        Assert.assertEquals(correctLtime.get(Calendar.MONTH),this.lTime.getTime().get(Calendar.MONTH));
        Assert.assertEquals(correctLtime.get(Calendar.DATE),this.lTime.getTime().get(Calendar.DATE));
        Assert.assertEquals(correctLtime.get(Calendar.HOUR_OF_DAY),this.lTime.getTime().get(Calendar.HOUR_OF_DAY));
        Assert.assertEquals(correctLtime.get(Calendar.MINUTE),this.lTime.getTime().get(Calendar.MINUTE));
        Assert.assertEquals(correctLtime.get(Calendar.SECOND),this.lTime.getTime().get(Calendar.SECOND));
        

    }
}