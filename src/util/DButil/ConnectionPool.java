package util.DButil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

/**
 * Created by hsy on 2017/7/14.
 */
public class ConnectionPool {
    private PoolConfig config;//当前连接池的配置对象

    //标记连接池是否可用
    private  boolean isActive=false;
    private int connCount=0;//当前连接数
    //空余链接
    private Vector<Connection> freeConn=new Vector<Connection>();
    //正在使用的连接
    private Vector<Connection> busyConn=new Vector<Connection>();
    //本地线程变量,用于将连接与当前线程关联起来
    private static ThreadLocal<Connection> threadLocal=new ThreadLocal<Connection>();

    public  ConnectionPool(PoolConfig config){
        this.config=config;
        //创建连接池时，就应该开始初始化的工作
        init();
    }
    public  Connection getCurrentConn(){
        return threadLocal.get();
    }
    private void init(){
        try {
            Class.forName(config.getDriverName());
            for(int i=0;i<config.getInitConn();i++){
                //创建连接对象
                Connection conn=getNewConnection();
                //添加到空闲连接
                freeConn.add(conn);
                connCount++;
            }
            isActive=true;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /*
        创建一个数据库连接，并且保证线程是安全的
         */
    private  synchronized Connection getNewConnection() throws SQLException {
        Connection conn;
        conn= DriverManager.getConnection(config.getUrl(),config.getUserName(),config.getPassword());
        return  conn;
    }
    /*
    外部连接
     */
    public synchronized Connection getConnection(){
        Connection conn=null;
        try {
            if(connCount<config.getMaxActiveConn()){
                //如果空闲对象中存在连接
                if(freeConn.size()>0){
                    conn=freeConn.get(0);
                    freeConn.remove(0);
                }else {
                    conn=getNewConnection();
                }
                //判断连接是否可用
                if(isEnable(conn)){
                    //添加到正在被占用的集合中
                    busyConn.add(conn);
                    connCount++;
                }else {//不可用时递归调用
                    conn=getConnection();
                }
            }
            else {//以经达到最大的连接池
                wait(config.getWaitTime());
                conn=getConnection();
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        threadLocal.set(conn);
        return conn;
    }
    public synchronized void releaseConnection(Connection conn){
        if(isEnable(conn)){
            if(freeConn.size()<config.getMaxConn()){
                freeConn.add(conn);
            }else {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        busyConn.remove(conn);
        connCount--;
        threadLocal.remove();
        //唤醒等待的线程
        notifyAll();

    }
    public  synchronized void destory(){
        for (Connection conn:freeConn){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        for (Connection conn:busyConn){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        isActive=false;
        connCount=0;
    }
    private  boolean isEnable(Connection conn){
        try {
            if(conn==null||conn.isClosed()){
                return  false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public PoolConfig getConfig() {
        return config;
    }

    public void setConfig(PoolConfig config) {
        this.config = config;
    }
}
