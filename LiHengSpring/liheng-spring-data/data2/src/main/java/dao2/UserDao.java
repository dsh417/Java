package dao2;

import entiry.User;

import java.math.BigInteger;
import java.util.List;

public interface UserDao {
    public void insert(User user);
    public void update(User user);
    public void deleteById(Integer id);
    public List<User> selectAll();
    public User selectById(Integer id);
//    坑。数据库Long变成了BigInteger
    public BigInteger save(User user);
}
