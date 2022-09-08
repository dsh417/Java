package disign.Template.jdbc;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.List;

public class MemberDao extends JdbcTemplate{
    public MemberDao(DataSource dataSource){
        super(dataSource);
    }

    public List<?> selectAll(){
        String sql="select * from t_member";
        return super.executeQuery(sql, new RowMapper() {
            @Override
            public Object mapRow(ResultSet rs, int rowNum) throws Exception {
                Member member=new Member();
//                原型模式
                member.setUsername(rs.getString("username"));
                member.setPassword(rs.getString("password"));
                member.setAge(rs.getInt("age"));
                member.setNikeName(rs.getNString("addr"));
                return member;
            }
        },null);
    }


}
