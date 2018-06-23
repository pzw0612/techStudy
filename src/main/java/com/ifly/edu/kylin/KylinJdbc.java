package com.ifly.edu.kylin;

//import org.apache.kylin.jdbc.Driver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

/**
 * @Description: todo
 * @author: pangzhiwang
 * @create: 2018/5/14
 **/
public class KylinJdbc {
    public static void main(String[] args) {
//
//        try{
//            Driver driver = (Driver) Class.forName("org.apache.kylin.jdbc.Driver").newInstance();
//            Properties info = new Properties();
//            info.put("user", "ADMIN");
//            info.put("password", "KYLIN");
//            Connection conn = driver.connect("jdbc:kylin://52.53.238.57:7070/dam_report", info);
//            PreparedStatement state = conn.prepareStatement("select sum(volume_usd) as volume_usd,  sum(volume_btc) as volume_btc from hft_user_order_view_usdbtc where  created_at_day >='20170901' and created_at_day <='20170930'  group by created_at_day");
//            ResultSet resultSet = state.executeQuery();
//
//            while (resultSet.next()) {
//                System.out.println(""+ resultSet.getString(1));
//                System.out.println(""+ resultSet.getString(2));
////            assertEquals("foo", resultSet.getString(1));
////            assertEquals("bar", resultSet.getString(2));
////            assertEquals("tool", resultSet.getString(3));
//            }
//        }catch (Exception e){
//
//        }

    }
}
