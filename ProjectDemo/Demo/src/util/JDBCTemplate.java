package util;

import exception.DataException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCTemplate {
    public void update(String sql,Object[] params){
        Connection con=null;

        PreparedStatement ps=null;

        try{
            con= JDBCUtil.getConnection();
            System.out.println("111");
            //1,事务应该在业务开始的时候开
            ps=con.prepareStatement(sql);


            for (int i = 0; i < params.length; i++) {
                setParam(i+1,params[i],ps);
            }

            ps.executeUpdate();

        }catch (Exception e){
            throw new DataException("数据访问失败",e);
        }finally {
            //链接con不能关，事务在外面。rs没用到，传空

            JDBCUtil.close(null,ps,null);
        }


    }


    private void setParam(int index,Object param,PreparedStatement ps) throws SQLException {

        if(param==null){
            ps.setNull(index, Types.VARCHAR);
        }else if(param instanceof String){
            ps.setString(index, (String) param);
        }else if(param instanceof java.sql.Date){
            ps.setDate(index, (java.sql.Date) param);
        }else if(param instanceof Time){
            ps.setTime(index, (Time) param);
        }else if(param instanceof Timestamp){
            ps.setTimestamp(index, (Timestamp) param);
        }else if(param instanceof Date) {
            Date date = (Date) param;
            ps.setTimestamp(index, new Timestamp(date.getTime()));
        }else{
            ps.setObject(index,param);
        }

    }

    public List query(String sql, Object[] params, RowMapper rm){
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        List list=new ArrayList();

        try {
            con= JDBCUtil.getConnection();

            //1,事务应该在业务开始的时候开
            ps=con.prepareStatement(sql);

            if(params!=null){
                for (int i = 0; i < params.length; i++) {
                    setParam(i+1,params[i],ps);
                }
            }


            rs=ps.executeQuery();

//            System.out.println("jdbc：rs获取");
            while(rs.next()){
                Object object=rm.mapRow(rs);
                list.add(object);
            }

//            System.out.println("jdbc:"+list);

        } catch (Exception e) {
            throw new DataException("数据访问失败",e);
        } finally {
            JDBCUtil.close(null, ps, rs);
        }

        return list;
    }


}
