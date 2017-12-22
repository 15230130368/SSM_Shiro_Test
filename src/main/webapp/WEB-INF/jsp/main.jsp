<%--
  Created by IntelliJ IDEA.
  User: zkx
  Date: 2017/12/21
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>主要界面</title>
</head>
<body>
<c:forEach items="${gns}" var="gn">
    <a href="${gn.url}">${gn.name}</a><br/>
</c:forEach>
<a href="/logout">退出登录</a>
</body>
</html>
