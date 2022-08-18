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
    <form action="${pageContext.request.contextPath}/param1/test1">
        <input type="text" name="name"/><br>
        <input type="text" name="age"/><br>
        <input type="date" name="bir"/><br>
        <input type="submit" value="submit">
    </form>

    </body>
</html>