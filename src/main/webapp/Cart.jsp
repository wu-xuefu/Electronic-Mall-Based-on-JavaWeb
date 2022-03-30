<%@ page import="ccit.js1842.wxf.bean.GoodsBean" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: FuHua
  Date: 2021-06-30
  Time: 20:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>购物车-手机电子商城</title>
    <%@include file="/common/head.jsp" %>
    <script type="text/javascript">
        $(function () {
            $("button.clear").click(function () {
                location.href = "http://localhost:8080/CartServlet?action=clear";
            })
        })
    </script>
</head>
<ul>
    <%@include file="/common/manager_menu.jsp" %>
    <%@include file="/common/longin_success_menu.jsp" %>
</ul>
<body>
<div style="padding: 20px;margin-top: 30px;background-image: url('/static/img/background.png');background-repeat: no-repeat ;background-attachment: fixed;height: 1300px">
    <table id="customers">
        <tr>
            <th>图 片</th>
            <th>名 称</th>
            <th>数 量</th>
            <th>单 价</th>
            <th>操 作</th>
        </tr>
        <c:set var="number" value="0"/>
        <c:forEach items="${requestScope.page.items}" var="cartItem" varStatus="idx">
            <tr>
                <td><img src="/static/img/1.webp"></td>
                <td>${cartItem.name}</td>
                <td>${cartItem.count}</td>
                <td>${cartItem.price}</td>
                <td><a class="deleteClass" href="/CartServlet?action=delete&id=${cartItem.id}">删除</a></td>
            </tr>
        </c:forEach>
        <c:if test="${not empty requestScope.page.items}">
            <tr>

            </tr>
        </c:if>
    </table>
    <div style="text-align: center">
        <h1>购物车中共有${requestScope.totalCount}件商品 总金额${requestScope.totalPrice}元</h1>
        <h2></h2><a href="/PayServlet?action=pay">去结账</a></h2>
        <button class="clear">清除购物车</button>
    </div>
    <%@include file="/common/page_nav.jsp" %>
</div>
<%@include file="/common/footer.jsp" %>
</body>
</html>
