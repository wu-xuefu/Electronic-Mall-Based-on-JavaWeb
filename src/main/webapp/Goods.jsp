<%@ page import="ccit.js1842.wxf.bean.GoodsBean" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: FuHua
  Date: 2021-06-20
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>后台管理</title>
    <%@include file="/common/head.jsp" %>
    <script type="text/javascript">
        $(function () {

            $("a.deleteClass").click(function () {
                return confirm("你确认删除【" + $(this).parent().parent().find("td:first").text() + "】?")
            });

        });
    </script>
</head>

<body>
<ul>
    <%@include file="/common/manager_menu.jsp" %>
    <%@include file="/common/longin_success_menu.jsp" %>
</ul>
<div style="padding: 20px;margin-top: 30px;background-image: url('/static/img/background.png');background-repeat: no-repeat ;background-attachment: fixed;height: 800px">
    <table id="customers">
        <tr>
            <th>手机型号</th>
            <th>价 格</th>
            <th>库 存</th>
            <th colspan="2">操 作</th>
        </tr>
        <c:forEach items="${requestScope.page.items}" var="goods" varStatus="idx">
            <tr>
                <td>${goods.name}</td>
                <td>${goods.value}</td>
                <td>${goods.number}</td>
                <td><a href="/GoodsServlet?action=getDate&id=${goods.id}">修改</a></td>
                <td><a class="deleteClass" href="/GoodsServlet?action=delete&id=${goods.id}">删除</a></td>
            </tr>
        </c:forEach>
    </table>
    <a href="/goods_edit.jsp">添加</a>
    <br/><br/>
    <%@include file="common/page_nav.jsp" %>
    <br/><br/>

</div>
<%@include file="/common/footer.jsp" %>
</body>
</html>
