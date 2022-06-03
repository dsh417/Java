package 对象.日期;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {
    public static void main(String[] args) {
//        long time=0;

        java.util.Date date=new java.util.Date();

        DateFormat dateFormat=new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒 E");
        String s=dateFormat.format(date);

        System.out.println(date);
        System.out.println(s);
        System.out.println("-----------------------------");
//        Date->Calendar
//        获得当前时间（和new Date一样）
        Calendar calendar=Calendar.getInstance();

        System.out.println(calendar);
        Date date1=calendar.getTime();
        System.out.println(date1);
    }

}
