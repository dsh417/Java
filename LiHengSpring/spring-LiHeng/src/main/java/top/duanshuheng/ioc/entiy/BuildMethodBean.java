package top.duanshuheng.ioc.entiy;

import lombok.Data;

@Data
public class BuildMethodBean {

    public BuildMethodBean() {
        System.out.println("空构造函数");
    }

    public BuildMethodBean(String s1, String s2) {
        System.out.println(s1+" "+s2);
    }


}
