<%--
  Created by IntelliJ IDEA.
  User: FuHua
  Date: 2021-06-29
  Time: 18:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/common/head.jsp" %>
    <title>用户注册</title>
    <script>
        $(function () {
            $("#password")
        })
    </script>
</head>
<body>
<div style="height: 800px;background-image: url('/static/img/background.png');background-repeat: no-repeat ;background-attachment: fixed;">
    <div class="card"
         style="  width: 15%;  height: 45%;  overflow: auto;  margin: auto;  position: absolute;  top: 0; left: 0; bottom: 0; right: 0;">

        <form action="/UserServlet" method="post">
            <input type="hidden" name="action" value="registered"/>
            <h1>用户注册</h1>
            <br/>
            昵 称:<input type="text" name="nickname">
            <br/><br/>
            用户名:<input type="text" name="name">
            <br/><br/>
            密 码:&nbsp;&nbsp;<input type="password" id="password" name="passwd">
            <br/><br/>
            重复密码:&nbsp;&nbsp;<input type="password" id="re_password" name="rePasswd" onblur="check2pwd()">
            <br/><br/>
            <input id="searchPageBtn" type="submit" value="注册"/>
        </form>
    </div>
</div>
<%@include file="/common/footer.jsp" %>
</body>
</html>
