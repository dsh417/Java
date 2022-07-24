package top.duanshuheng.ioc.entiy12_Person;

import lombok.Data;

import java.beans.PropertyEditorSupport;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class DateEditor extends PropertyEditorSupport {
    private String dateFormat="yyyy-MM-dd";



    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        try {
            Date date=new SimpleDateFormat(dateFormat).parse(text);
            setValue(date);

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        super.setAsText(text);
    }
}
