import dao.UserInfo_dao;
import entity.UserInfo;
import util.DButil.DButil;

import java.util.List;

/**
 * Created by HuShu on 2017/7/18.
 */
public class Test {
    public static void main(String[] args) {
        DButil db = new DButil();
        UserInfo_dao dao = new UserInfo_dao();
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("007");
        List<UserInfo> list = dao.findUser(userInfo);
        System.out.println("哈哈哈哈哈哈");
    }
}
