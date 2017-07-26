package servlet;

import entity.UserInfo;
import service.UserLogin_service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by HuShu on 2017/7/17.
 */
public class UserLogin_servlet extends HttpServlet{

    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        //定义字符集
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");

        //获取会话session
        HttpSession session = request.getSession();

        String username=request.getParameter("username");//从前台获取用户名
        String password=request.getParameter("password");//从前台获取密码

        UserLogin_service userLogin_service=new UserLogin_service();

            String password1=userLogin_service.getUserPassword(username);//查询该用户名是否在管理员的数据库中并返回密码
            String contextPath = request.getContextPath();
            //将输入的密码与查询到的密码进行比对
            if(password.equals(password1)){
                UserInfo userInfo = new UserInfo();
                userInfo.setUsername(username);
                session.setAttribute("user", userInfo.getUserID());
                response.sendRedirect(contextPath+"/message.jsp");
            }else{
                request.setAttribute("message","用户名或密码有误！！");
                request.getRequestDispatcher("/message.jsp").forward(request, response);
            }

        }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
