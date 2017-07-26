package util.DButil;

/**
 * Created by hsy on 2017/7/6.
 */
public class PoolConfig {
    //数据库连接最基础的属性
    private String driverName;//数据库驱动类
    private String url;//数据库的连接地址
    private String userName;//数据库的用户名
    private String password;//数据库的密码

    //连接池的配置项
    private  int minConn=5;//空闲集合中最小的连接数
    private int maxConn=20;//空闲集合中最大的连接数
    private int initConn=10;//初始化空闲连接池的数量
    private int maxActiveConn=50;//允许产生最大连接数，包括空闲和正在使用的，一般是数据库允许的最大连接数
    private  int waitTime=10000;//ms,
    private boolean isCheck=false;//是否检查连接池状态，自检机制
    private long checkPeriod=1000*60*30;//半个小时检查一次

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getMinConn() {
        return minConn;
    }

    public void setMinConn(int minConn) {
        this.minConn = minConn;
    }

    public int getMaxConn() {
        return maxConn;
    }

    public void setMaxConn(int maxConn) {
        this.maxConn = maxConn;
    }

    public int getInitConn() {
        return initConn;
    }

    public void setInitConn(int initConn) {
        this.initConn = initConn;
    }

    public int getMaxActiveConn() {
        return maxActiveConn;
    }

    public void setMaxActiveConn(int maxActiveConn) {
        this.maxActiveConn = maxActiveConn;
    }

    public int getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(int waitTime) {
        this.waitTime = waitTime;
    }

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }

    public long getCheckPeriod() {
        return checkPeriod;
    }

    public void setCheckPeriod(long checkPeriod) {
        this.checkPeriod = checkPeriod;
    }
}
