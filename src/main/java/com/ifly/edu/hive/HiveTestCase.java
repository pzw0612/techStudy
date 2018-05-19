package com.ifly.edu.hive;

/**
 * @Description: todo
 * @author: pangzhiwang
 * @create: 2018/4/26
 **/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

/**
 * Handle data through hive on eclipse
 * @author zhouls
 * @time 2016\11\12 22:14
 */
public class HiveTestCase {
    private static String driverName = "org.apache.hive.jdbc.HiveDriver";
    private static String url = "jdbc:hive2://52.53.238.57:10000/hft";
    private static String user = "";
    private static String password = "";
    private static String sql = "";
    private static ResultSet res;
    private static final Logger log = Logger.getLogger(HiveTestCase.class);

    public static void main(String[] args) {
        try {
            Class.forName(driverName); // 注册JDBC驱动
//            Connection conn = DriverManager.getConnection(url, user, password);

            //默认使用端口10000, 使用默认数据库，用户名密码默认
            Connection conn = DriverManager.getConnection(url, "hadoop", "");
//
            Statement stmt = conn.createStatement();



            // 执行“show tables”操作
            sql = "show tables ";
            System.out.println("Running:" + sql);
            res = stmt.executeQuery(sql);
            System.out.println("执行“show tables”运行结果:");
            if (res.next()) {
                System.out.println(res.getString(1));
            }


            conn.close();
            conn = null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            log.error(driverName + " not found!", e);
            System.exit(1);
        } catch (SQLException e) {
            e.printStackTrace();
            log.error("Connection error!", e);
            System.exit(1);
        }

    }
}
