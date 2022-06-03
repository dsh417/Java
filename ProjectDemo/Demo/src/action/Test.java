package action;

import entity.User;
import entity.UserLoding;
import exception.DataException;
import exception.ServiceException;
import factory.ObjectFactory;
import service.UserService;

public class Test {
    public static void main(String[] args) {


        UserService userService= (UserService) ObjectFactory.getObject("userService");
        UserLoding o=new UserLoding();
        o.setUser("ggg1");
        o.setPass("ggg1");

        try {
            User user=null;
            user=userService.Loding(o);
            System.out.println(user);
            System.out.println("111");
        } catch (ServiceException e) {
            System.out.println("222");
        } catch (DataException e){
            System.out.println("333");
        }

    }

}
