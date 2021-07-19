package cn.zyh.dao;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class DbUtils {
    private static DruidDataSource ds;
    private static final Properties PT = new Properties();
    private static final ThreadLocal<Connection> THREAD_LOCAL = new ThreadLocal<>();

    static {
        InputStream is = DbUtils.class.getResourceAsStream("/db.properties");
        try {
            PT.load(is);
            ds = (DruidDataSource) DruidDataSourceFactory.createDataSource(PT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection con = THREAD_LOCAL.get();
        try {
            if (con==null){
                con = ds.getConnection();
                THREAD_LOCAL.set(con);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return con;
    }

    public static void closeAll(Connection connection, Statement statement, ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
                THREAD_LOCAL.remove();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    public static void begin(){
        Connection con = null;
        try {
            con = getConnection();
            con.setAutoCommit(false);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void commit(){
        Connection con =null;
        try {
            con=getConnection();
            con.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll(con,null,null);
        }
    }

    public static void rollback(){
        Connection con =null;
        try {
            con=getConnection();
            con.rollback();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll(con,null,null);
        }
    }
}
