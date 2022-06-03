package resultsetextractor;

import entity.User;
import util.RowMapper;

import java.io.Serial;
import java.io.Serializable;
import java.sql.ResultSet;


public class UserRowMapper implements RowMapper, Serializable {
    public Object mapRow(ResultSet rs) throws Exception {
        User o=new User();

        o.setUid(rs.getInt("uid"));
        o.setUser(rs.getString("user"));
        o.setPass(rs.getString("pass"));
        o.setGold(rs.getInt("gold"));
        o.setTime(rs.getString("time"));
        o.setAttennum(rs.getInt("attennum"));
        o.setExtnum(rs.getInt("extnum"));
        o.setAppellation(rs.getString("appellation"));

        return o;
    }

}
