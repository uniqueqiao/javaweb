<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8" %>
<%@page import="java.util.* , java.io.* " %>
<%@page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
    </head>
    <body>
         <h1>错误操作！错误信息为${requestScope.errorMess}</h1>
    </body>
</html>