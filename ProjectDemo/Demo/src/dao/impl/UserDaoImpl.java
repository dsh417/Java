package dao.impl;

import dao.UserDao;
import entity.*;
import exception.DataException;
import resultsetextractor.UserUIDRowMapper;
import resultsetextractor.UserRowMapper;
import resultsetextractor.UserTalkRowMapper;
import util.JDBCTemplate;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private JDBCTemplate jdbcTemplate;

    public UserDaoImpl(){
        jdbcTemplate=new JDBCTemplate();
    }

    @Override
    public List select() {
        List list=null;

        String sql=new StringBuffer()
                .append("select * ")
                .append("from t_use ")
                .toString();

        System.out.println(sql);
        try{
            list=jdbcTemplate.query(sql,null,new UserRowMapper());
            System.out.println(list);
            return list;
        }catch (DataException e){
            e.printStackTrace();
            return null;
        }


    }

    @Override
    public List talk() {

        List list=null;

        String sql=new StringBuffer()
                .append("select t_use.user,t_use.appellation,t_talk.time,t_talk.some,t_talk.tid from t_talk left join t_use on t_talk.id_user=t_use.uid; ")
                .toString();

        System.out.println(sql);

        try{
            list=jdbcTemplate.query(sql,null,new UserTalkRowMapper());
            System.out.println(list);
            return list;
        }catch (DataException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void regis(UserRegis userRegis) {
        String sql=new StringBuffer()
                .append("INSERT INTO t_use (user,pass,appellation) ")
                .append("       value(?,?,?)")
                .toString();
        List list=new ArrayList();
        list.add(userRegis.getUser());
        list.add(userRegis.getPass());
        list.add(userRegis.getAppellation());

        jdbcTemplate.update(sql,list.toArray());

    }

    @Override
    public Boolean ajax(UserAjax userAjax) {

        String sql=new StringBuffer()
                .append("select * from t_use ")
                .append("   where user='")
                .append(userAjax.getUser())
                .append("'")
                .toString();

        List list=jdbcTemplate.query(sql,null,new UserRowMapper());

        if(list==null||list.isEmpty()){
            return true;
        }else {
            return false;
        }

    }

    @Override
    public User Loding(UserLoding userLoding) {
        String sql=new StringBuffer()
                .append("select * from t_use ")
                .append("   where user='")
                .append(userLoding.getUser())
                .append("' and pass='")
                .append(userLoding.getPass())
                .append("'")
                .toString();
        List list=jdbcTemplate.query(sql,null,new UserRowMapper());

        if(list==null||list.isEmpty()){
            return null;
        }else {
            return (User) list.get(0);
        }

    }

    @Override
    public Boolean messageUpdata(UserMessage userMessage,int uid) {
        String sql=new StringBuffer()
                .append("INSERT INTO t_talk (some,time,id_user) ")
                .append("       value(?,?,?)")
                .toString();

        List list=new ArrayList();

        list.add(userMessage.getSome());
        list.add(userMessage.getTime());
        list.add(uid);

        System.out.println(sql);
        try{
            jdbcTemplate.update(sql,list.toArray());
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }




    }

    @Override
    public int getUserForAppellation(String s) {

        String sql=new StringBuffer()
                .append("select uid from t_use ")
                .append("   where appellation='")
                .append(s)
                .append("'")
                .toString();

        System.out.println(sql);

        List list=jdbcTemplate.query(sql,null,new UserUIDRowMapper());

        if(list.isEmpty()||list==null){
            return -1;
        }

        UserUID temp= (UserUID) list.get(0);

        return temp.getUid();
    }


}
