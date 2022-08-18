<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8" %>
<%@page import="java.util.* , java.io.* " %>
<%@page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
</head>
<body>
<form action="${pageContext.request.contextPath}/file/upload" method="post" enctype="multipart/form-data">
    <input type="file" name="avatar"/>
    <input type="submit" value="上传头像"/>
</form>
<span style="color:red;">${requestScope.errorMess}</span>
</body>
</html>