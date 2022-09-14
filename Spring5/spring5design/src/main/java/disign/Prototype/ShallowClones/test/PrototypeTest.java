package disign.Prototype.ShallowClones.test;

import disign.Prototype.ShallowClones.imp.Client;
import disign.Prototype.ShallowClones.imp.ConcretePrototypeA;

import java.util.ArrayList;
import java.util.List;

public class PrototypeTest {
    public static void main(String[] args) {
        //创建一个需要克隆对象
        ConcretePrototypeA concretePrototypeA=new ConcretePrototypeA();
        concretePrototypeA.setAge(18);
        concretePrototypeA.setName("prototype");
        List hobbies=new ArrayList<String>();
        concretePrototypeA.setHobbies(hobbies);
        System.out.println(concretePrototypeA);

        //创建Client对象，准备克隆
        Client client=new Client(concretePrototypeA);
        ConcretePrototypeA concretePrototypeClone=(ConcretePrototypeA) client.startClone(concretePrototypeA);
        System.out.println(concretePrototypeClone);

        System.out.println("克隆对象引用的类型地址："+concretePrototypeClone.getHobbies());
        System.out.println("原对象中引用的类型地址："+concretePrototypeA.getHobbies());
        System.out.println("对象地址比较"+((concretePrototypeClone.getHobbies())==(concretePrototypeA.getHobbies())));

        //浅克隆不是我要的结果
    }
}
