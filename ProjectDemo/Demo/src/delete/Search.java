//package dao.impl;
//
//
//import util.JDBCTemplate;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * 搜索算法
// */
//public class Search {
//    /**
//     * 限定代理人的单人行程搜索
//     *
//     * @param Dt       时间(格式为”yyyyMMdd“）
//     * @param dep      起始地
//     * @param arr      目的地
//     * @param agencies 代理人字符串（格式为“AAA111BBB222CCC333...”）
//     * @return 查询结果
//     */
//    public List<FlightObj> SearchFlight(String Dt, String dep, String arr, String agencies) {
//
//        return SearchFlight(Dt, dep, arr, agencies, 1);
//    }
//
//    /**
//     * 限定代理人的多人行程搜索
//     *
//     * @param Dt            时间(格式为”yyyyMMdd“）
//     * @param dep           起始地
//     * @param arr           目的地
//     * @param agencies      代理人字符串（格式为“AAA111BBB222CCC333...”）
//     * @param PassageAmount 旅客数
//     * @return 查询结果
//     */
//    public List<FlightObj> SearchFlight(String Dt, String dep, String arr, String agencies, int PassageAmount) {
//        //计算出参数中有多少个代理
//        int agenciesNum = agencies.length() / 6;
//        if(agenciesNum<=0){
//            agenciesNum=1;
//        }
//        //拼接sql
//        String sql = new StringBuffer()
//                .append(" SELECT f.carrier,                     ")
//                .append("        f.flightNo,                        ")
//                .append("        f.departure,                       ")
//                .append("        f.departureDatetime,                       ")
//                .append("        u.agencies,                        ")
//                .append("        f.arrival,                     ")
//                .append("        r.seatC,                     ")
//                .append("        r.seatY,                     ")
//                .append("        r.seatF,                     ")
//                .append("        (CASE                      ")
//                .append("             WHEN r.seatY >= ").append(PassageAmount).append(" THEN                        ")
//                .append("                 ((SELECT t_tariff.amount                      ")
//                .append("                   FROM t_tariff                       ")
//                .append("                   WHERE t_tariff.carrier = carrier                        ")
//                .append("                     AND (t_tariff.departure = departure)                      ")
//                .append("                     AND (t_tariff.arrival = arrival)                      ")
//                .append("                     AND t_tariff.cabin = 'Y'                      ")
//                .append("                   LIMIT 1)                        ")
//                .append("                     * ").append(PassageAmount).append(" *                     ")
//                .append("                  (1 + (SELECT t_rules.surcharge                       ")
//                .append("                        FROM t_rules                       ")
//                .append("                        WHERE t_rules.carrier = carrier                        ")
//                .append("                          AND (t_rules.departure = departure OR t_rules.departure IS NULL)                     ")
//                .append("                          AND (t_rules.arrival = arrival OR t_rules.arrival IS NULL)                       ")
//                .append("                        ORDER BY sequenceNo                        ")
//                .append("                        LIMIT 1) / 100))                       ")
//                .append("             WHEN (r.seatY < ").append(PassageAmount).append(" AND r.seatY + r.seatC >= ").append(PassageAmount).append(" - r.seatY) THEN                      ")
//                .append("                     ((SELECT t_tariff.amount                      ")
//                .append("                       FROM t_tariff                       ")
//                .append("                       WHERE t_tariff.carrier = carrier                        ")
//                .append("                         AND (t_tariff.departure = departure)                      ")
//                .append("                         AND (t_tariff.arrival = arrival)                      ")
//                .append("                         AND t_tariff.cabin = 'Y'                      ")
//                .append("                       LIMIT 1                     ")
//                .append("                      ) * r.seatY +                        ")
//                .append("                      (SELECT t_tariff.amount                      ")
//                .append("                       FROM t_tariff                       ")
//                .append("                       WHERE t_tariff.carrier = carrier                        ")
//                .append("                         AND (t_tariff.departure = departure)                      ")
//                .append("                         AND (t_tariff.arrival = arrival)                      ")
//                .append("                         AND t_tariff.cabin = 'C'                      ")
//                .append("                       LIMIT 1                     ")
//                .append("                      ) * (").append(PassageAmount).append(" - r.seatY)) *                     ")
//                .append("                     (1 + (SELECT t_rules.surcharge                        ")
//                .append("                           FROM t_rules                        ")
//                .append("                           WHERE t_rules.carrier = carrier                     ")
//                .append("                             AND (t_rules.departure = departure OR t_rules.departure IS NULL)                      ")
//                .append("                             AND (t_rules.arrival = arrival OR t_rules.arrival IS NULL)                        ")
//                .append("                           ORDER BY sequenceNo                     ")
//                .append("                           LIMIT 1) / 100)                     ")
//                .append("             WHEN r.seatY < ").append(PassageAmount).append(" AND r.seatY + r.seatC < ").append(PassageAmount).append(" THEN                       ")
//                .append("                     ((SELECT t_tariff.amount                      ")
//                .append("                       FROM t_tariff                       ")
//                .append("                       WHERE t_tariff.carrier = carrier                        ")
//                .append("                         AND (t_tariff.departure = departure)                      ")
//                .append("                         AND (t_tariff.arrival = arrival)                      ")
//                .append("                         AND t_tariff.cabin = 'Y'                      ")
//                .append("                       LIMIT 1                     ")
//                .append("                      ) * r.seatY +                        ")
//                .append("                      (SELECT t_tariff.amount                      ")
//                .append("                       FROM t_tariff                       ")
//                .append("                       WHERE t_tariff.carrier = carrier                        ")
//                .append("                         AND (t_tariff.departure = departure)                      ")
//                .append("                         AND (t_tariff.arrival = arrival)                      ")
//                .append("                         AND t_tariff.cabin = 'C'                      ")
//                .append("                       LIMIT 1                     ")
//                .append("                      ) * r.seatC +                        ")
//                .append("                      (SELECT t_tariff.amount                      ")
//                .append("                       FROM t_tariff                       ")
//                .append("                       WHERE t_tariff.carrier = carrier                        ")
//                .append("                         AND (t_tariff.departure = departure)                      ")
//                .append("                         AND (t_tariff.arrival = arrival)                      ")
//                .append("                         AND t_tariff.cabin = 'C'                      ")
//                .append("                       LIMIT 1                     ")
//                .append("                      ) *                      ")
//                .append("                      (").append(PassageAmount).append(" - r.seatY - r.seatC)) *                       ")
//                .append("                     (1 + (SELECT t_rules.surcharge                        ")
//                .append("                           FROM t_rules                        ")
//                .append("                           WHERE t_rules.carrier = f.carrier                       ")
//                .append("                             AND (t_rules.departure = f.departure OR t_rules.departure IS NULL)                        ")
//                .append("                             AND (t_rules.arrival = f.arrival OR t_rules.arrival IS NULL)                      ")
//                .append("                           ORDER BY sequenceNo                     ")
//                .append("                           LIMIT 1) / 100)                     ")
//                .append("            END) AS price                      ")
//                .append(" from t_flight AS f                        ")
//                .append("          INNER JOIN t_remainder AS r ON f.flightNo = r.flightNo                       ")
//                .append("          INNER JOIN t_rules AS u ON ( f.carrier = u.carrier                       ")
//                .append("     AND f.departure = u.departure AND f.arrival = u.arrival )                     ")
//                .append(" WHERE f.departure = ?                     ")
//                .append("   AND f.arrival = ?                       ")
//                .append("   AND f.departureDatetime LIKE ?                      ")
//                .append("   AND (u.agencies LIKE ?                     ")
//                //根据代理数量附加条件
//                .append("           OR u.agencies LIKE ?                " .repeat(agenciesNum-1))
//                .append("   ) AND r.seatF + r.seatC + r.seatY > ").append(PassageAmount)
//                .append(" ORDER BY price;                       ")
//                .toString();
//        //给日期添上通配符
//        String time = Dt + '%';
//        //创建参数列表
//        List<String> paramsList = new ArrayList<>();
//        paramsList.add(dep);
//        paramsList.add(arr);
//        paramsList.add(time);
//        //根据代理数目截取字符串添加参数
//        for (int i = 0; i < agenciesNum; i++) {
//            try {
//                paramsList.add("%" + agencies.substring(i, i + 6) + "%");
//            }catch (Exception e){
//                paramsList.add("%");
//            }
//            i += 6;
//        }
//        //执行sql返回结果
//        JDBCTemplate JdbcTemplate = new JDBCTemplate();
//        return JdbcTemplate.query(sql,paramsList.toArray(),new FlightRowMapper());
//
//    }
//}
//
