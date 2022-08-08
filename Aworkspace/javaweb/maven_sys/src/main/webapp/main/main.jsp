<%@ page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>main</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/statics/css/bootstrap.min.css">
</head>
<frameset rows="10%,*" frameborder="no" border="1">
    <frame src="head.jsp" />
    <frameset cols="12%,*">
        <frame src="menu.jsp" />
        <frame src="${pageContext.request.contextPath}/index.html" name="main">
    </frameset>
</frameset>
<body>
</body>
</html>