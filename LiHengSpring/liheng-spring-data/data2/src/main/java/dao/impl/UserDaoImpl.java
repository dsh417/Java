package dao.impl;

import dao.UserDao;
import entiry.User;
import lombok.Data;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.math.BigInteger;
import java.sql.PreparedStatement;
import java.util.List;

@Data
public class UserDaoImpl implements UserDao {

    private JdbcTemplate jdbcTemplate;

    @Override
    public void insert(User user) {
        String sql=new StringBuffer()
                .append("insert into t_user ")
                .append(" (username,password) ")
                .append("values ")
                .append("  (?,?) ")
                .toString();
        jdbcTemplate.update(sql,new Object[]{user.getUsername(),user.getPassword()});

    }

    @Override
    public void update(User user) {
        String sql=new StringBuffer()
                .append(" update t_user ")
                .append("set password=? ")
                .append("where id=? ")
                .toString();
        jdbcTemplate.update(sql,new Object[]{user.getPassword(),user.getId()});
    }

    @Override
    public void deleteById(Integer id) {
        String sql=new StringBuffer()
                .append("delete from t_user ")
                .append("where id=? ")
                .toString();

        jdbcTemplate.update(sql,new Object[]{id});
    }

    @Override
    public List<User> selectAll() {
        String sql=new StringBuffer()
                .append("select * ")
                .append("from t_user ")
                .toString();
        return jdbcTemplate.query(sql,new UserRowMapper());
    }

    @Override
    public User selectById(Integer id) {
        String sql=new StringBuffer()
                .append("select * ")
                .append("from t_user ")
                .append("where id=?")
                .toString();
        return (User) jdbcTemplate.queryForObject(sql,new Object[]{id},new UserRowMapper());
    }

    @Override
    public BigInteger save(final User user) {
        KeyHolder keyHolder=new GeneratedKeyHolder();
//        返回主键
        jdbcTemplate.update(
                (connection)->{
                    String sql=new StringBuffer()
                            .append("insert into t_user ")
                            .append(" (username,password) ")
                            .append("values ")
                            .append(" (?,?) ")
                            .toString();
                    PreparedStatement ps=connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
                    ps.setString(1,user.getUsername());
                    ps.setString(2,user.getPassword());
                    return ps;
                }


                ,keyHolder);

        return (BigInteger) keyHolder.getKey();
    }
}
