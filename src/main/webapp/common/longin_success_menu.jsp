<%--
  Created by IntelliJ IDEA.
  User: FuHua
  Date: 2021-06-28
  Time: 13:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<li style="float: right"><a class="active" href="">${sessionScope.user.name}</a></li>
<li style="float: right"><a href="/UserServlet?action=logout">注销</a></li>