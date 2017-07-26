package util.DButil;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

/**
 * Created by hsy on 2017/7/6.
 */
public class DButil {
    private static PoolConfig config = new PoolConfig();

    static {
        Properties prop = new Properties();
        try {
            prop.load(DButil.class.getClassLoader().getResourceAsStream("util/DButil/db.properties"));
            config.setDriverName(prop.getProperty("jdbc.driverName"));
            config.setUrl(prop.getProperty("jdbc.url"));
            config.setUserName(prop.getProperty("jdbc.username"));
            config.setPassword(prop.getProperty("jdbc.password"));
            config.setMinConn(Integer.valueOf(prop.getProperty("jdbc.minConn")));
            config.setMinConn(Integer.valueOf(prop.getProperty("jdbc.maxConn")));
            config.setInitConn(Integer.valueOf(prop.getProperty("jdbc.initConn")));
            config.setMaxActiveConn(Integer.valueOf(prop.getProperty("jdbc.maxActiveConn")));
            config.setWaitTime(Integer.valueOf(prop.getProperty("jdbc.waitTime")));
            config.setCheckPeriod(Long.valueOf((eval(prop.getProperty("jdbc.checkPeriod", String.valueOf(1000 * 60)))).toString()));
            System.out.println(config.getPassword());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(config.getDriverName());
        }


    }
    private static ConnectionPool connPool=new ConnectionPool(config);
    public static Connection getConnection(){
        return  connPool.getConnection();
    }
    public static Connection getCurrentConnection(){
        return connPool.getCurrentConn();
    }
    public static void closeConnection(Connection conn){
        connPool.releaseConnection(conn);
    }

    private static Object eval(String str) {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        Object result = null;
        try {
            result = engine.eval(str);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        return result;
    }
}
