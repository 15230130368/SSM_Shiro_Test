<%--
  Created by IntelliJ IDEA.
  User: zkx
  Date: 2017/12/21
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<fieldset>
    <legend>注册</legend>
    <form action="/reg" method="post">
        用户名：<input type="text" name="username"><br/>
        密码：<input type="password" name="password"><br/>
        <input type="submit" value="注册">
    </form>
</fieldset>
</body>
</html>
