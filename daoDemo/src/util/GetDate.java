package util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetDate {
    public static String getToday(){   //获取当前日期格式“yyyyMMdd”
        Date d = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        String todayStr = df.format(d);
        return todayStr;
    }
    public static String getAnotherToday(){  //获取当前日期格式“yyyy-MM-dd”
        Date d = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String todayStr = df.format(d);
        return todayStr;
    }
    public static String getAfterNum(int flag){   //获取流水号的序号
        String str=null;
        str=String.valueOf(flag);
        while(str.length()<4){
            str="0"+str;
        }
        return str;
    }
    public static String getTime(){   //获取当前时间
        Date d = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String time = df.format(d);
        return time;
    }
    public static String replaceTime(String day){   //获取当前日期进行替换
        day=day.replaceFirst("-","年");
        day=day.replaceFirst("-","月");
        day=day+"日";
        return day;
    }
}
