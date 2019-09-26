package com.ecnu;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

class MoscowTimeTest {
    private Calendar currentTime;
    private UTCTime stdTime;
    private MoscowTime mTime;
    @BeforeEach
    public void before(){
        this.currentTime = Calendar.getInstance();
        this.currentTime.set(2019,9,19,20,17,10);
        this.stdTime  = new UTCTime(this.currentTime);
        this.mTime = new MoscowTime(this.stdTime);
    }
    @Test
    void moscow_time_should_be_4_hours_earlier_than_utc_time() {
        Calendar newTime = Calendar.getInstance();
        newTime.set(2019,9,20,8,19,3);
        UTCTime newUtc = new UTCTime(newTime);
        this.mTime.adjust(newUtc);

        Calendar correctmTime = Calendar.getInstance();
        correctmTime.set(2019,9,20,12,19,3);

        Assert.assertEquals(correctmTime.get(Calendar.YEAR),this.mTime.getTime().get(Calendar.YEAR));
        Assert.assertEquals(correctmTime.get(Calendar.MONTH),this.mTime.getTime().get(Calendar.MONTH));
        Assert.assertEquals(correctmTime.get(Calendar.DATE),this.mTime.getTime().get(Calendar.DATE));
        Assert.assertEquals(correctmTime.get(Calendar.HOUR_OF_DAY),this.mTime.getTime().get(Calendar.HOUR_OF_DAY));
        Assert.assertEquals(correctmTime.get(Calendar.MINUTE),this.mTime.getTime().get(Calendar.MINUTE));
        Assert.assertEquals(correctmTime.get(Calendar.SECOND),this.mTime.getTime().get(Calendar.SECOND));
    }
}