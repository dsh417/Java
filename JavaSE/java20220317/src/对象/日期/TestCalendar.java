package 对象.日期;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/*
*
*
* 对时间加减循环
* 日历类*/
public class TestCalendar {
    public static void main(String[] args) throws ParseException {
        //String->DateFormat->Date->Calendar

        String StarS="2017/08/08 00:00:00";

        String EndS="2017/08/15 00:00:00";

        DateFormat dateFormat=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        Date StarDate=dateFormat.parse(StarS);

        Date EndDate=dateFormat.parse(EndS);

        Calendar StarCalendar=Calendar.getInstance();
        StarCalendar.setTime(StarDate);

        Calendar EndCalendar=Calendar.getInstance();
        EndCalendar.setTime(EndDate);

        while (StarCalendar.before(EndCalendar)){
//            开始日期在结束日期之前
//            Calendar->Date
            Date date=StarCalendar.getTime();
//            Date->String
            String ss=dateFormat.format(date);

            System.out.println(ss);
//            将Starcalendar+1 单位（第一个参数是位置，如年，天，日）
            StarCalendar.add(Calendar.DAY_OF_MONTH,1);


        }
    }
}
