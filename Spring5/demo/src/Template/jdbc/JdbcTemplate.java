package Template.jdbc;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcTemplate {
    private DataSource dataSource;

    public JdbcTemplate(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    public List<?> executeQuery(String sql, RowMapper rowMapper, Object[] values){
        try {
//            链接
            Connection con=this.dataSource.getConnection();
//            语句集
            PreparedStatement pstm=this.createPrepareStatement(con,sql);
//            执行语句集
            ResultSet rs=this.executeQuery(pstm,values);
//            结果集
            List<?> result=this.paresResultSet(rs,rowMapper);
//            关闭结果集，语句集，关闭链接
            this.closeResultSet(rs);
            this.closeStatment(pstm);
            this.closeConnection(con);
            return result;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    private List<?> paresResultSet(ResultSet rs, RowMapper rowMapper) {
        try {
            List<Object> result=new ArrayList<Object>();
            int rowNum=1;
            while(rs.next()){
                result.add(rowMapper.mapRow(rs,rowNum++));
            }
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected ResultSet executeQuery(PreparedStatement pstm,Object[] values){

        try {
            for (int i = 0; i < values.length; i++) {
                pstm.setObject(i,values[i]);
            }
            return pstm.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private void closeConnection(Connection con) {
        //        不关闭数据链接池
        if(con!=null){
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void closeStatment(PreparedStatement pstm) {
        if (pstm != null) {
            try {
                pstm.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private PreparedStatement createPrepareStatement(Connection con, String sql) {
        try {
            return con.prepareStatement(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public Connection getConnection(){
        try {
            return this.dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
