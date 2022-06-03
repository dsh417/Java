package sqlTest;

import util.JDBCTemplate;
import util.JDBCUtil;

public class sqlTest01 {
    public static void main(String[] args) {
//        String sb=new StringBuffer()
//                .append("create table copy1 ")
//                .append("as (select * from t_ext ")
//                .append(");")
//                .toString();

        String sb=new StringBuffer()
                .append("create table copy1 ")
                .append("as (select * from t_ext ")
                .append(");")
                .toString();



        System.out.println(sb);



    }
}
