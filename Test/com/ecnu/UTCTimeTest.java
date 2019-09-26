package com.ecnu;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

class UTCTimeTest {
    private MobileTime mbTime;
    private Calendar currentTime;
    private  UTCTime stdTime;

    @BeforeEach
    public void before(){
        this.currentTime = Calendar.getInstance();
        this.currentTime.set(2019,9,19,20,17,10);
        this.stdTime  = new UTCTime(this.currentTime);
        
        
    }
    @Test
    void utc_time_should_be_altered_through_mobile_and_should_be_8_hours_later_than_mobile_time() {
        Calendar newUtcTime = Calendar.getInstance();
        newUtcTime.set(2019,9,20,10,44,20);
        UTCTime newU = new UTCTime(newUtcTime);
        this.mbTime = new MobileTime(newU);
        this.stdTime.adjustBasedOnMobile(this.mbTime);
        Assert.assertEquals(newUtcTime.get(Calendar.YEAR),this.stdTime.getTime().get(Calendar.YEAR));
        Assert.assertEquals(newUtcTime.get(Calendar.MONTH),this.stdTime.getTime().get(Calendar.MONTH));
        Assert.assertEquals(newUtcTime.get(Calendar.DATE),this.stdTime.getTime().get(Calendar.DATE));
        Assert.assertEquals(newUtcTime.get(Calendar.HOUR_OF_DAY),this.stdTime.getTime().get(Calendar.HOUR_OF_DAY));
        Assert.assertEquals(newUtcTime.get(Calendar.MINUTE),this.stdTime.getTime().get(Calendar.MINUTE));
        Assert.assertEquals(newUtcTime.get(Calendar.SECOND),this.stdTime.getTime().get(Calendar.SECOND));
    }
}