package dao;

import entity.UserInfo;
import util.DButil.DButil;
import util.JDBCtools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by HuShu on 2017/7/17.
 */
public class UserInfo_dao {
    private int row;
/*
    public boolean addUser(UserInfo userInfo ) {
        int flag = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "insert into UserInfo (userName,userFullname,userEngname,userPassword,userDuty,userTell) values (?,?,?,?,?,?)";
        try {
            conn =  DButil.getConnection();
            ps =conn.prepareStatement(sql);
            ps.setString(1,userInfo.getUsername());
            ps.setString(2,userInfo.getUserFullname());
            ps.setString(3,userInfo.getUserEngname());
            ps.setString(4,userInfo.getUserPassword());
            ps.setString(5,userInfo.getUserDuty());
            ps.setString(6,userInfo.getUserTell());
            flag = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DButil.closeConnection(conn);
        }
        if (flag == 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteUserInfo(UserInfo userInfo) {
        long id =userInfo.getUserID();
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "delete from UserInfo  where userID=?";
        try {
            conn = DButil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setLong(1, id);
            row = ps.executeUpdate();
            if (row > 0)
                return true;
            else
                return false;
        } catch (Exception e) {

            e.printStackTrace();
        } finally {

            DButil.closeConnection(conn);
        }
        return false;
    }*/

    public String sqlbuild(UserInfo userInfo) {
        String sql_base = "select * from UserInfo ";
        long id = userInfo.getUserID();
        String name=userInfo.getUsername();
        String fullName=userInfo.getUserFullname();
        String engName=userInfo.getUserEngname();
        String password=userInfo.getUserPassword();
        String duty=userInfo.getUserDuty();
        String tell=userInfo.getUserTell();


        if(null == userInfo || (id == 0 &&( null == name || name.trim().equals(""))
                && (null == fullName || fullName.trim().equals(""))
                && (null == engName || engName.trim().equals(""))
                && (null == password || password.trim().equals(""))
                &&(null==duty||duty.trim().equals(""))
                &&(null==tell||tell.trim().equals(""))
        ))	{
            return sql_base;
        }else{

            sql_base += " where ";

            if (id != 0) {
                sql_base += " userID=" + id + " and";
            }
            if (name != null && !name.trim().equals("")) {
                sql_base += " username=" + "'" + name + "'" +" and";
            }
            if (fullName != null && !fullName.trim().equals("")) {
                sql_base += " userFullname=" + "'" + fullName + "'" +" and";
            }
            if (engName != null && !engName.trim().equals("")) {
                sql_base += " userEngname=" + "'" + engName + "'" +" and";
            }
            if (password != null && !password.trim().equals("")) {
                sql_base += " userPassword=" + "'" + password + "'" +" and";
            }
            if(duty!=null&&!duty.trim().equals("")){
                sql_base+=" userDuty="+"'"+duty+"'"+" and";
            }
            if(tell!=null&&!tell.trim().equals("")){
                sql_base+=" userTell="+"'"+tell+"'"+" and";
            }
        }

        if(sql_base.endsWith("and")){
            sql_base = sql_base.substring(0, sql_base.length()-4);
        }

        if(sql_base.endsWith("where")){
            sql_base = sql_base.substring(0, sql_base.length()-6);
        }

        return sql_base;
    }

    public <T> List<UserInfo> findUser(UserInfo userInfo) {

        List<UserInfo> list1 = new ArrayList<UserInfo>();
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            String sql = sqlbuild(userInfo);
            conn = JDBCtools.getConnection();
            System.out.println("lalaaaaaaaa"+sql);
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {

                UserInfo userInfo1 = new UserInfo();
                userInfo1.setUserID(rs.getLong("userID"));
                userInfo1.setUsername(rs.getString("username"));
                userInfo1.setUserFullname(rs.getString("userFullname"));
                userInfo1.setUserEngname(rs.getString("userEngname"));
                userInfo1.setUserPassword(rs.getString("userPassword"));
                userInfo1.setUserDuty(rs.getString("userDuty"));
                userInfo1.setUserTell(rs.getString("userTell"));
                System.out.println(userInfo.getUserPassword());
                System.out.println("哈哈哈哈哈哈哈啊哈哈哈哈");
                list1.add(userInfo1);
            }
            return list1;
        } catch (Exception e) {
            System.out.println("哈哈哈哈哈哈哈啊哈哈哈哈");

            e.printStackTrace();
        } finally {

           JDBCtools.releaseDB(rs,ps,conn);
        }
        return null;
    }
/*
    public boolean changeUser(UserInfo userInfo) {
        PreparedStatement ps = null;
        Connection conn = null;
        long id=userInfo.getUserID();
        String name=userInfo.getUsername();
        String fullName=userInfo.getUserFullname();
        String engName=userInfo.getUserEngname();
        String password=userInfo.getUserPassword();
        String duty=userInfo.getUserDuty();
        String tell=userInfo.getUserTell();

        String sql = "UPDATE UserInfo set userName=?,userFullname=?,userEngname=?,userPassword=?,userDuty=?,userTell=? where userID=?";

        try {
            conn = DButil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, fullName);
            ps.setString(3, engName);
            ps.setString(4, password);
            ps.setString(5,duty);
            ps.setString(6,tell);
            ps.setString(7, ""+id);
            row = ps.executeUpdate();
            if (row > 0)
                return true;
            else
                return false;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            DButil.closeConnection(conn);
        }
        return false;}*/
}
