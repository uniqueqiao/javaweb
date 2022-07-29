<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8" %>
<%@page import="java.util.* , java.io.* " %>
<%@page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style type="text/css">
        span{
            color: indianred;
        }
    </style>
    <script type="text/javascript" src="jquery-1.8.3.js"></script>
    <script type="text/javascript">
        $(function() {
            $("#username").blur(function() {
                //原来   发送同步请求,验证用户名是否存在
                location.href="${pageContext.request.contextPath}/user/CheckAction?username="+$("#username").val();

            });
        });
    </script>
</head>
<body>
    <form method="get" >
      username<input type="text" name="username" id="username"/><span id="mess1">*</span>${sessionScope.mess}<br><br>
      password<input type="password" name="password" id="password"/><br><br>
      <input type="submit" value="注册">
    </form>
${pageContext.session.removeAttribute("mess")}
</body>