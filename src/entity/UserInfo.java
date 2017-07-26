package entity;

/**
 * Created by HuShu on 2017/7/17.
 */
public class UserInfo {
    private  long  userID;
    private String username;
    private String userFullname;
    private String userEngname;
    private String userPassword;
    private String userDuty;
    private String userTell;

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserFullname() {
        return userFullname;
    }

    public void setUserFullname(String userFullname) {
        this.userFullname = userFullname;
    }

    public String getUserEngname() {
        return userEngname;
    }

    public void setUserEngname(String userEngname) {
        this.userEngname = userEngname;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserDuty() {
        return userDuty;
    }

    public void setUserDuty(String userDuty) {
        this.userDuty = userDuty;
    }

    public String getUserTell() {
        return userTell;
    }

    public void setUserTell(String userTell) {
        this.userTell = userTell;
    }
}
