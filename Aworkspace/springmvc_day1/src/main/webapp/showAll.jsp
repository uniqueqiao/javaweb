<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8" %>
<%@page import="java.util.* , java.io.* " %>
<%@page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
    <head>
        <title>showAll页面</title>
    </head>
    <body>
    <c:forEach items="${requestScope.list}" var="u">
        姓名：${u.username}<br>
        生日：<fmt:formatDate value="${u.bir}" pattern="yyyy-MM-dd"/><br>
    </c:forEach>

    </body>
</html>