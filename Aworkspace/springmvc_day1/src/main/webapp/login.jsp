<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8" %>
<%@page import="java.util.* , java.io.* " %>
<%@page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>test页面</title>
    </head>
    <body>
    <form action="${pageContext.request.contextPath}/login">
        <input type="text" name="username"/><br>
        <input type="text" name="password"/><br>
        <input type="submit" value="登录"><br>
        <span style="color: red">${requestScope.errorMess}</span>
    </form>

    </body>
</html>