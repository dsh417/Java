package 集合;

import java.util.Properties;
import java.util.Set;

public class TestProperties {
    public static void main(String[] args) throws Exception{
        Properties p=new Properties();

        p.load(TestProperties.class
                .getClassLoader()
                .getResourceAsStream("集合/info.properties"));

//        System.out.println(p.get("a"));

        String d=p.getProperty("d");
        System.out.println(d);

//        遍历
        Set<String> keys=p.stringPropertyNames();
        for (String key :
                keys) {
            System.out.println(key+" "+p.getProperty(key));
        }
    }



}
