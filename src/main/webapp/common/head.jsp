<%--
  Created by IntelliJ IDEA.
  User: FuHua
  Date: 2021-06-28
  Time: 14:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme()
            + "://"
            + request.getServerName()
            + ":"
            + request.getServerPort()
            + request.getContextPath()
            + "/";
%>
<base href="<%=basePath%>">
<link type="text/css" rel="stylesheet" href="/static/style/css_all.css">
<script type="text/javascript" src="/static/script/jquery-3.6.0.js"></script>