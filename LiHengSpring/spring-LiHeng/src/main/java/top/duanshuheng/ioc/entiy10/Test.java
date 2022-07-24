package top.duanshuheng.ioc.entiy10;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.xml.sax.SAXException;
import sun.text.resources.FormatData;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.text.DateFormat;
import java.text.Format;
import java.util.Date;

public class Test {
    public static void main(String[] args) throws ParserConfigurationException, SAXException {

//        SAXParserFactory factory=SAXParserFactory.newInstance();
//        SAXParser parser=factory.newSAXParser();

        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext10.xml");

        SAXParser parser= (SAXParser) ac.getBean("saxParser");

        System.out.println(parser);

//        Date date=ac.getBean("date");

        Date date= (Date) ac.getBean("date");

        System.out.println(DateFormat.getDateTimeInstance().format(date));

    }
}
