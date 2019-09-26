package com.ecnu;

import java.util.Calendar;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Calendar currentTime = Calendar.getInstance();
        currentTime.set(2019,9,19,20,17,10);
        UTCTime stdTime  = new UTCTime(currentTime);
        LondonTime lTime = new LondonTime(stdTime);
        NewYorkTime nyTime = new NewYorkTime(stdTime);
        SydneyTime sTime = new SydneyTime(stdTime);
        MoscowTime mTime = new MoscowTime(stdTime);
        BeijingTime bTime = new BeijingTime(stdTime);
        MobileTime mbTime = new MobileTime(stdTime);
        System.out.println();
        UTCTime[] timeArray = {stdTime,lTime,nyTime,sTime,mTime,bTime};
//        for(int i = 0;i<timeArray.length;i++){
//            int year = timeArray[i].getTime().get(Calendar.YEAR);
//            int month = timeArray[i].getTime().get(Calendar.MONTH);
//            int day = timeArray[i].getTime().get(Calendar.DATE);
//            int hour = timeArray[i].getTime().get(Calendar.HOUR_OF_DAY);
//            int minute = timeArray[i].getTime().get(Calendar.MINUTE);
//            int second = timeArray[i].getTime().get(Calendar.SECOND);
//            String hint = "the ! " + " time is: " + year + "/" + month + "/" + day + " " + hour + ":" + minute + ":" + second;
//            System.out.println(hint);
//        }
        mbTime.changeTime(Calendar.HOUR_OF_DAY,2,timeArray);
//        for(int i = 0;i<timeArray.length;i++){
//            int year = timeArray[i].getTime().get(Calendar.YEAR);
//            int month = timeArray[i].getTime().get(Calendar.MONTH);
//            int day = timeArray[i].getTime().get(Calendar.DATE);
//            int hour = timeArray[i].getTime().get(Calendar.HOUR_OF_DAY);
//            int minute = timeArray[i].getTime().get(Calendar.MINUTE);
//            int second = timeArray[i].getTime().get(Calendar.SECOND);
//            String hint = "the ! " + " time is: " + year + "/" + month + "/" + day + " " + hour + ":" + minute + ":" + second;
//            System.out.println(hint);
//        }



    }
}
