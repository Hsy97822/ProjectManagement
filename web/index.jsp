<%--
  Created by IntelliJ IDEA.
  User: HuShu
  Date: 2017/7/8
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
  <head>
    <title>登 录</title>
    <!-- <link rel="stylesheet" type="text/css" href="css/style.css" />
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
    <link href="css/font-awesome.css" rel="stylesheet" type="text/css" media="all" />
    <link rel="stylesheet" href="css/chocolat.css" type="text/css" media="screen"><!-- chocolate css for gallery light box-->

    <link href="css/animate.css" rel="stylesheet" type="text/css" media="all">
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
  </head>


  <body>
  <div>
    <div class="header jarallax" id="home">
      <div class="container">
        <div class="banner-text text-center">
          <h2>Project Management</h2></br>
        </div>
      </div>
    </div>
  </div>
  <div class="container">
    <section id="content">
      <form action="/UserLogin_servlet" method="post">
        <h1>Logining</h1>
        <div>
          <input name="username" type="text" placeholder="Username" required="" id="username" />
        </div>
        <div>
          <input name="password" type="password" placeholder="Password" required="" id="password" />
        </div>

        <div style="margin-left: 30%;">
          <input type="submit" value="Log in" />

        </div>
      </form><!-- form -->

    </section><!-- content -->
  </div><!-- container -->
  </body>
</html>
