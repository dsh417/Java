package top.duanshuheng.ioc.entiy3;

import lombok.Data;
import sun.util.BuddhistCalendar;
import top.duanshuheng.ioc.entiy2.ISomeBean;
import top.duanshuheng.ioc.entiy2.SomeBean;

import java.util.Calendar;
import java.util.Date;

public class SomeBeanFactory {
    public ISomeBean getSomeBean(){
        return new SomeBean();
    }

    public Date getDate(){
        Calendar calendar=new BuddhistCalendar();
        Date date=calendar.getTime();
        return date;
    }
}
