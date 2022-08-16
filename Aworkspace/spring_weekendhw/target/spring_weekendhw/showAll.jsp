<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8" %>
<%@page import="java.util.* , java.io.* " %>
<%@page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
    <head>
        <title>showAll</title>
    </head>
    <body>
    <table >
        <tr >
            <td>Id</td>
            <td>Name</td>
            <td>age</td>
            <td>bir</td>
        </tr>
        <c:forEach var="user" items="${sessionScope.list}" varStatus="vs">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.age}</td>
                <td><fmt:formatDate value="${user.bir}" pattern="yyyy-MM-dd"/></td>
            </tr>
        </c:forEach>
    </table>
    <p>
        <input type="button" class="button" value="Add" onclick="location='${pageContext.request.contextPath}/add.jsp'"/>
    </p>
    </body>
</html>