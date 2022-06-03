package service;

import entity.*;
import exception.ServiceException;

import java.util.List;

public interface UserService {

    public List<User> select() throws ServiceException;

    public List<UserTalk> Talk() throws ServiceException;

    public void regis(UserRegis userRegis) throws ServiceException;

    public Boolean ajax(UserAjax userAjax) throws ServiceException;

    public User Loding(UserLoding userLoding) throws ServiceException;

    public boolean massege(UserMessage userMessage) throws ServiceException;
}
