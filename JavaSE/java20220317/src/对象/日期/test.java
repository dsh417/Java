package 对象.日期;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class test {
    public static void main(String[] args) throws ParseException, InterruptedException {
        while(true){
            Scanner scanner=new Scanner(System.in);
            String s=scanner.nextLine();
//        System.out.println(s);

            String regis="(\\d){4}/(\\d){2}/(\\d){2}\s(\\d){2}:(\\d){2}:(\\d){2}";

            if(!s.matches(regis)){
                System.out.println("again input");
                continue;
            }
            DateFormat dateFormat=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

            Date date=dateFormat.parse(s);
            Date today=new Date();

            Calendar starCalendar=Calendar.getInstance();
            starCalendar.setTime(date);

            Calendar endCalendar=Calendar.getInstance();
            endCalendar.setTime(today);

            if(!starCalendar.before(endCalendar)){
                System.out.println("again input");
                continue;
            }
            System.out.println("休眠1秒");
            Thread.sleep(1000);
            System.out.println("完成");
            break;

        }


    }
}
