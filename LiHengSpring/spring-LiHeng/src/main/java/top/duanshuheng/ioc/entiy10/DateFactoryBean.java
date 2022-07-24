package top.duanshuheng.ioc.entiy10;

import lombok.Data;
import org.springframework.beans.factory.FactoryBean;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class DateFactoryBean implements FactoryBean {
    private String year;
    private String month;

    @Override
    public Object getObject() throws Exception {

        return new SimpleDateFormat("yyyyMM").parse(year+month);
    }

    @Override
    public Class<?> getObjectType() {
        return Date.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
