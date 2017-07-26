package util;

import java.sql.*;

public class JDBCtools {
	public JDBCtools(){}
	//连接数据库的方法
	public static Connection getConnection() throws Exception {
		String url = "jdbc:mysql://localhost/projectmanagement?charset=utf-8&useSSL=true";
	    String name = "com.mysql.jdbc.Driver";  
	    String user = "root";  
	    String password = "0000";
	    //必要的四个属性
	    Class.forName(name);
	    Connection conn = DriverManager.getConnection(url, user, password);
		return conn;
	}
	//关闭数据库的方法
	public static void releaseDB(ResultSet rs,Statement st,Connection conn)
	{
		if(rs!=null)  //关闭resultset
		{try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}}
		if(st!=null)  //关闭statement
		{
			try {
				st.close();
			} catch (SQLException e) {		
				e.printStackTrace();
			}
		}
		if(conn!=null) //断开数据库连接
		{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
