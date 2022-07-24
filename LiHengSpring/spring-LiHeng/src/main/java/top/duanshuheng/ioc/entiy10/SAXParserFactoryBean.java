package top.duanshuheng.ioc.entiy10;

import org.springframework.beans.factory.FactoryBean;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class SAXParserFactoryBean implements FactoryBean{

    @Override
    public Object getObject() throws Exception {

        SAXParserFactory factory=SAXParserFactory.newInstance();
        SAXParser parser=factory.newSAXParser();

        return parser;
    }

    @Override
    public Class<?> getObjectType() {
        return SAXParser.class;
    }

    @Override
    public boolean isSingleton() {
     return false;
    }
}
