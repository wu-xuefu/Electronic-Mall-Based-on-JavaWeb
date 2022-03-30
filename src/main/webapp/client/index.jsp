<%@ page import="ccit.js1842.wxf.bean.GoodsBean" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: FuHua
  Date: 2021-06-30
  Time: 11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>手机电子商城</title>
    <%@include file="/common/head.jsp" %>
    <script type="text/javascript">
        $(function () {
            $("button.addToCart").click(function () {
                var GoodsId = $(this).attr("GoodsId");

                location.href = "http://localhost:8080/CartServlet?action=add&id=" + GoodsId;
            })
        })
    </script>
</head>
<body>
<ul>
    <%@include file="/common/manager_menu.jsp" %>
    <c:if test="${empty sessionScope.user}">
        <li style="float: right"><a class="active" href="/regis.jsp">注册</a></li>
        <li style="float: right"><a class="active" href="/login.jsp">登录</a></li>
    </c:if>
    <c:if test="${not empty sessionScope.user}">
        <%@include file="/common/longin_success_menu.jsp" %>
    </c:if>
</ul>

<div style="padding: 20px;margin-top: 30px;background-image: url('/static/img/background.png');background-repeat: no-repeat ;background-attachment: fixed;height: 800px">
    <div class="card"
         style="  width: 75%;  height: 50%;  overflow: auto;  margin: auto;  position: absolute;  top: 0; left: 0; bottom: 0; right: 0;">
        <table>
            <tr>
                <c:forEach items="${requestScope.page.items}" var="goods" varStatus="idx">
                    <td><img src="/static/img/1.webp"></td>
                    <td>
                        <p>手机型号：${goods.name}</p>
                        <p>价 格：${goods.value}</p>
                        <p>库 存：${goods.number}</p>
                        <p>
                            <button GoodsId="${goods.id}" class="addToCart">加入购物车</button>
                        </p>
                    </td>
                </c:forEach>
            </tr>
        </table>
        <%@include file="/common/page_nav.jsp" %>
    </div>
</div>
<%@include file="/common/footer.jsp" %>
</body>
</html>
