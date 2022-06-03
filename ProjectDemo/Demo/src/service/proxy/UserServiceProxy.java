package service.proxy;

import entity.*;
import exception.DataException;
import exception.ServiceException;
import factory.ObjectFactory;
import service.UserService;
import transaction.TransactionManager;

import java.util.List;

public class UserServiceProxy implements UserService {

    private UserService userService;

    public UserServiceProxy(){
        userService= (UserService) ObjectFactory.getObject("userServiceTarget");
    }


    @Override
    public List<User> select() throws ServiceException {

        return queryLock(1);
    }


    @Override
    public List<UserTalk> Talk() throws ServiceException {

        return queryLock(2);
    }

    @Override
    public void regis(UserRegis userRegis) throws ServiceException {
        queryLock(3,userRegis);
    }

    @Override
    public Boolean ajax(UserAjax userAjax) throws ServiceException {
        return userService.ajax(userAjax);
    }

    @Override
    public User Loding(UserLoding userLoding) throws ServiceException {
        return userService.Loding(userLoding);
    }

    @Override
    public boolean massege(UserMessage userMessage) throws ServiceException {
//        return userService.massege(userMessage);
        TransactionManager tran= (TransactionManager) ObjectFactory.getObject("transaction");
        boolean b=false;
        try{
            //开始事务
            tran.beginTransaction();
            b=userService.massege(userMessage);


            //提交事务
            tran.commit();
            b=true;
        }catch (DataException e){
            //回滚
            tran.rollback();
            try {
                throw  new ServiceException();
            } catch (ServiceException ex) {
                ex.printStackTrace();
            }
        }catch (Exception e){
            //回滚
            tran.rollback();
            try {
                throw e;
            } catch (ServiceException ex) {
                ex.printStackTrace();
            }
        }

        return  b;
    }









    public List queryLock(int n){
        return queryLock(n,null);
    }

    public List queryLock(int n,Object o){
        TransactionManager tran= (TransactionManager) ObjectFactory.getObject("transaction");


        List list=null;
        try{

            //开始事务
            tran.beginTransaction();
            switch (n){
                case 1:{
                    list =userService.select();
                    break;
                }
                case 2:{
                    list =userService.Talk();
                    break;
                }
                case 3:{
                    userService.regis((UserRegis) o);
                    break;
                }
            }

            //提交事务
            tran.commit();

        }catch (DataException e){
            //回滚
            tran.rollback();
            try {
                throw  new ServiceException();
            } catch (ServiceException ex) {
                ex.printStackTrace();
            }
        }catch (Exception e){
            //回滚
            tran.rollback();
            try {
                throw e;
            } catch (ServiceException ex) {
                ex.printStackTrace();
            }
        }

        return list;
    }

}
