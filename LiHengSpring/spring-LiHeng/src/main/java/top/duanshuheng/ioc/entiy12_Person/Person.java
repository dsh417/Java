package top.duanshuheng.ioc.entiy12_Person;

import com.sun.xml.internal.ws.wsdl.writer.document.http.Address;
import lombok.Data;

import java.util.Date;

@Data
public class Person {

    private Address2 addr;
    private Date birthday;
    private String[] hobbies;

    Person(){}


}
