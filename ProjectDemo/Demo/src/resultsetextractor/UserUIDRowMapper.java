package resultsetextractor;

import entity.User;
import entity.UserAjax;
import entity.UserUID;
import util.RowMapper;

import java.io.Serializable;
import java.sql.ResultSet;

public class UserUIDRowMapper implements Serializable, RowMapper {
    public Object mapRow(ResultSet rs) throws Exception {
        UserUID o = new UserUID();

        o.setUid(rs.getInt("uid"));

        return o;
    }
}
