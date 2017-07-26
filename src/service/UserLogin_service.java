package service;

import dao.UserInfo_dao;
import entity.UserInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HuShu on 2017/7/17.
 */
public class UserLogin_service {

    public String getUserPassword(String username){
        UserInfo_dao userInfo_dao = new UserInfo_dao();
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(username);
        List<UserInfo> list = new ArrayList<>();
        System.out.println("size: "+userInfo_dao.findUser(userInfo).size());
        list = userInfo_dao.findUser(userInfo);
        // list=userInfo_dao.findUser(userInfo);
        //list.addAll(userInfo_dao.findUser(userInfo));
        //System.out.println(userInfo.getUserPassword());
        System.out.println(list.size());
        if(list.size()==1){
            userInfo = list.get(0);
            System.out.println("password: "+userInfo.getUserPassword());
        }
        return userInfo.getUserPassword();
    }

}
