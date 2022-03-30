<%--
  Created by IntelliJ IDEA.
  User: FuHua
  Date: 2021-06-29
  Time: 18:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
    <%@include file="/common/head.jsp" %>
</head>
<body>
<div style="height: 800px;background-image: url('/static/img/background.png');background-repeat: no-repeat ;background-attachment: fixed;">
    <div class="card"
         style="  width: 15%;  height: 30%;  overflow: auto;  margin: auto;  position: absolute;  top: 0; left: 0; bottom: 0; right: 0;">
        <form action="/UserServlet" method="post">
            <input type="hidden" name="action" value="login"/>
            <h1>用户登录</h1>
            <br/>
            用户名:<input type="text" name="name">
            <br/><br/>
            密 码:&nbsp;&nbsp;<input type="password" name="passwd">
            <br/><br/>
            <input id="searchPageBtn" type="submit" value="登录"/>
        </form>
    </div>
</div>
<%@include file="/common/footer.jsp" %>
</body>
</html>
