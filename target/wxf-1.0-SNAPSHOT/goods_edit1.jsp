<%--
  Created by IntelliJ IDEA.
  User: FuHua
  Date: 2021-06-21
  Time: 0:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="/common/head.jsp" %>
</head>
<body>
<form action="/GoodsServlet" method="post">
    <input type="hidden" name="action" value="update">
    <input type="hidden" name="id" value="${requestScope.goods.id}">
    <table>
        <tr>
            <td>
                name
            </td>
            <td>
                value
            </td>
            <td>
                number
            </td>
            <td>
                操作
            </td>
        </tr>
        <tr>
            <td>
                <input name="name" type="text" value="${requestScope.goods.name}">
            </td>
            <td>
                <input name="value" type="text" value="${requestScope.goods.value}">
            </td>
            <td>
                <input name="number" type="text" value="${requestScope.goods.number}">
            </td>
            <td>
                <input type="submit" value="提交">
            </td>
        </tr>
    </table>
</form>
<%@include file="/common/footer.jsp" %>
</body>
</html>
