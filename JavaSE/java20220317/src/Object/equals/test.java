package Object.equals;

public class test {
    //浅克隆
    //重写clone方法：
//          放大访问权限
//          类实现Cloneable接口
    /*克隆出来是两个不同对象
    *
    *
    *
    * */


    public static void main(String[] args) throws CloneNotSupportedException {
        Person p = new Person();
        Address address=new Address();

        address.setCity("南京");
        p.setId("1");
        p.setName("1");
        p.setAddress(address);

        System.out.println(p.toString());
        System.out.println(p.getId());
        System.out.println(p.getName());
        System.out.println(p.getAddress().getCity());

        Person p2 = (Person) p.clone();

        System.out.println(p2.toString());
        System.out.println(p2.getId());
        System.out.println(p2.getName());
        System.out.println(p.getAddress().getCity());

//        System.out.println(p.getAddress()==p2.getAddress());
        System.out.println(p.equals(p2));
    }
}
