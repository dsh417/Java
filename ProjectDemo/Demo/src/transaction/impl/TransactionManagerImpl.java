package transaction.impl;

import exception.DataException;
import transaction.TransactionManager;
import util.JDBCUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class TransactionManagerImpl implements TransactionManager {
    @Override
    public void beginTransaction() {
        Connection con=null;
        try{
            con= JDBCUtil.getConnection();
            con.setAutoCommit(false);
        }catch (Exception e){
            throw new DataException("数据访问失败",e);
        }
    }

    @Override
    public void commit() {
        Connection con=null;
        try{
            con= JDBCUtil.getConnection();
            con.commit();
        }catch (Exception e){
            throw new DataException("数据访问失败",e);
        }finally {
            JDBCUtil.close();
        }
    }

    @Override
    public void rollback(){
        Connection con=null;
        try{
            con= JDBCUtil.getConnection();
            con.rollback();
        }catch (Exception e){
            //回滚要人为解决
            e.printStackTrace();
        }finally {
            JDBCUtil.close();
        }
    }
}
