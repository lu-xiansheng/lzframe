<%--
  Created by IntelliJ IDEA.
  User: lz
  Date: 2016/11/11
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="BASE" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <title>customer</title>
</head>
<body>
<h1>客户列表</h1>
<table>
    <tr>
        <th>客户名称</th>
        <th>联系人</th>
        <th>邮箱地址</th>
    </tr>


    <tr>
        <td>${customer.name}</td>
        <td>${customer.contact}</td>
        <td>${customer.email}</td>
    </tr>
</table>

</body>
</html>
