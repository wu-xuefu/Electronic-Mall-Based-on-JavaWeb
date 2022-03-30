<%--
  Created by IntelliJ IDEA.
  User: FuHua
  Date: 2021-06-20
  Time: 22:12
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
    <input type="hidden" name="action" value="add">
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
                <input name="name" type="text">
            </td>
            <td>
                <input name="value" type="text">
            </td>
            <td>
                <input name="number" type="text">
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
