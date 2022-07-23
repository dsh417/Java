package top.duanshuheng.ioc.entiy8;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.*;

public class Text {
    public static void main(String[] args) throws IOException {

//        Resource resource=new ClassPathResource("a.txt");
//
//        System.out.println(resource.exists());
//
//        System.out.println(resource.getFilename());
//        System.out.println(resource.getURL());
//
//        File file=resource.getFile();
//
//        InputStream in=resource.getInputStream();
//
//        System.out.println(file.length());
//        BufferedReader br=new BufferedReader(
//                new InputStreamReader(in,"utf-8"));
//
//        System.out.println(br.readLine());
//        br.close();


        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext8.xml");

//        Resource resource=applicationContext.getResource("classpath:a.txt");
        SomeBean someBean= (SomeBean) applicationContext.getBean("someBean");


        System.out.println(someBean.getResource().getFile().length());
    }
}
