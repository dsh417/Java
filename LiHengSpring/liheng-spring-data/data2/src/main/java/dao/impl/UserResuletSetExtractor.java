package dao.impl;

import entiry.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserResuletSetExtractor implements ResultSetExtractor {
    @Override
    public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<User> users=new ArrayList<>();
        while (rs.next()){
            User user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            users.add(user);
        }
        return users;
    }
}
