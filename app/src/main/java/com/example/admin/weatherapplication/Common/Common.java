package com.example.admin.weatherapplication.Common;

import android.location.Location;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Common {


    public static final String APP_ID="f491467b732261569f4d73421a51a120";
    public static Location current_location=null;

    public static String  convertUnixToDate(int dt){
        Date date=new Date(dt* 1000L) ;
        SimpleDateFormat sdf=new SimpleDateFormat("HH:mm dd EEE MM yyyy");
        String formatted=sdf.format(date);
        return  formatted;
    }

    public static String  convertUnixToHour(long sunrise){
        Date date=new Date(sunrise* 1000L) ;
        SimpleDateFormat sdf=new SimpleDateFormat("HH:mm");
        String formatted=sdf.format(date);
        return  formatted;
    }



}
