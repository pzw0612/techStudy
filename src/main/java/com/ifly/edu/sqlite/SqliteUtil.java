package com.ifly.edu.sqlite;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Repository
public class SqliteUtil {

    private Logger logger = Logger.getLogger(this.getClass());
    /**
     * 数据源
     */
    @Resource(name = "sqliteDataSource")
    private DataSource sqliteDataSource;

    /**
     * 获取数据库连接
     * @return conn
     */
    public Connection getConnection() throws SQLException {
        Connection conn = sqliteDataSource.getConnection();
        conn.setAutoCommit(false);
        return conn;
    }

    /**
     * 关闭数据库连接
     * @param conn
     */
    public void close(Connection conn, Statement stmt, ResultSet rs) {
        if (null != rs) {
            try {
                rs.close();
            } catch (SQLException ex) {
                logger.error(null, ex);
            }
            rs = null;
        }
        if (null != stmt) {
            try {
                stmt.close();
            } catch (SQLException ex) {
                logger.error(null, ex);
            }
            stmt = null;
        }
        if (null != rs) {
            try {
                rs.close();
            } catch (SQLException ex) {
                logger.error(null, ex);
            }
            rs = null;
        }
    }
}

