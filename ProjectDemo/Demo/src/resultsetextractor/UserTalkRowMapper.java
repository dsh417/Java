package resultsetextractor;

import entity.User;
import entity.UserTalk;
import util.RowMapper;

import java.io.Serializable;
import java.sql.ResultSet;


public class UserTalkRowMapper implements RowMapper, Serializable {
    public Object mapRow(ResultSet rs) throws Exception {
        UserTalk o=new UserTalk();

        o.setTid(rs.getInt("tid"));
        o.setAppellation(rs.getString("appellation"));
        o.setTime(rs.getString("time"));
        o.setUser(rs.getString("user"));
        o.setSome(rs.getString("some"));

        return o;
    }

}
