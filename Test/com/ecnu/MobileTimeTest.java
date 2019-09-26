package com.ecnu;

import org.junit.Test;
import org.junit.Assert;

import java.util.Calendar;

public class MobileTimeTest {
    @Test
    public void All_Time_Should_be_Adjusted_by_One_Function(){
        Calendar currentTime = Calendar.getInstance();
        currentTime.set(2019,9,19,20,17,10);

        UTCTime stdTime  = new UTCTime(currentTime);
        LondonTime lTime = new LondonTime(stdTime);
        NewYorkTime nyTime = new NewYorkTime(stdTime);
        SydneyTime sTime = new SydneyTime(stdTime);
        MoscowTime mTime = new MoscowTime(stdTime);
        BeijingTime bTime = new BeijingTime(stdTime);
        MobileTime mbTime = new MobileTime(stdTime);

        UTCTime[] timeArray = {stdTime,lTime,nyTime,sTime,mTime,bTime};
        mbTime.changeTime(Calendar.HOUR_OF_DAY,2,timeArray);

        Calendar correctBeijingTime = Calendar.getInstance();
        Calendar correctUtcTime = Calendar.getInstance();
        Calendar correctNyTime = Calendar.getInstance();
        Calendar correctStime = Calendar.getInstance();
        Calendar correctMtime = Calendar.getInstance();
        Calendar correctLtime = Calendar.getInstance();
        correctLtime.set(2019,9,19,22,17,10);
        correctMtime.set(2019,9,20,2,17,10);
        correctStime.set(2019,9,20,8,17,10);
        correctNyTime.set(2019,9,19,17,17,10);
        correctUtcTime.set(2019,9,19,22,17,10);
        correctBeijingTime.set(2019,9,20,6,17,10);

        Calendar assertTime[] = {correctUtcTime,correctLtime,correctNyTime,correctStime,correctMtime,correctBeijingTime};
        for(int i = 0;i<timeArray.length;i++){
            Assert.assertEquals(assertTime[i].get(Calendar.YEAR),timeArray[i].getTime().get(Calendar.YEAR));
            Assert.assertEquals(assertTime[i].get(Calendar.MONTH),timeArray[i].getTime().get(Calendar.MONTH));
            Assert.assertEquals(assertTime[i].get(Calendar.DATE),timeArray[i].getTime().get(Calendar.DATE));
            Assert.assertEquals(assertTime[i].get(Calendar.HOUR_OF_DAY),timeArray[i].getTime().get(Calendar.HOUR_OF_DAY));
            Assert.assertEquals(assertTime[i].get(Calendar.MINUTE),timeArray[i].getTime().get(Calendar.MINUTE));
            Assert.assertEquals(assertTime[i].get(Calendar.SECOND),timeArray[i].getTime().get(Calendar.SECOND));
        }




    }
}
