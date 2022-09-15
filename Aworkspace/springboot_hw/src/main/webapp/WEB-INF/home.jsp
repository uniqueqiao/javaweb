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
    <div class="top-right">
        当前登录：${sessionScope.user.username} <img style="width: 20px;height: 20px" src="${pageContext.request.contextPath}/statics/avatar/${user.avatar}">
        <a href="${pageContext.request.contextPath}/logout">安全退出</a>
    </div>
    <table border="1">
        <tr >
            <td>Id</td>
            <td>username</td>
            <td>avatar</td>
            <td>createTime</td>
            <td>option</td>
        </tr>
        <c:forEach var="user" items="${requestScope.list}" varStatus="vs">
            <tr>
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td><img style="width: 100px;height: 100px" src="${pageContext.request.contextPath}/statics/avatar/${user.avatar}"></td>
                <td><fmt:formatDate value="${user.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <td><a href="${pageContext.request.contextPath}/delete?id=${user.id}">删除</a></td>
            </tr>
        </c:forEach>
    </table>
    <p>
        <input type="button" class="button" value="Add" onclick="location='${pageContext.request.contextPath}/add.jsp'"/>
    </p>
    </body>
</html>