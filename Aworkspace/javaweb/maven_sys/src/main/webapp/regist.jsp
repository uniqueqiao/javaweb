<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>index.html</title>

    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="this is my page">
    <meta name="content-type" content="text/html; charset=utf-8">
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/statics/css/bootstrap.min.css">
</head>

<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-12">
            <h1 class="text-center">用户注册</h1>
        </div>
    </div>
    <div class="row" style="margin-top: 70px;">
        <div class="col-sm-4 col-sm-offset-4">
            <form action="${pageContext.request.contextPath}/user/RegistAction" method="post">
                <div class="form-group">
                    <label>
                        用户名:
                    </label>
                    <input type="text" name="u.username" class="form-control"/>${sessionScope.mess}
                </div>
                <div class="form-group">
                    <label>
                        密&nbsp;&nbsp;码:
                    </label>
                    <input type="password" name="u.password" class="form-control"/>
                </div>
                <div class="form-group">
                    <label>
                        选择角色:
                    </label>
                    <select class="form-control" name="u.role">
                        <option value="admin">管理员</option>
                        <option value="student">学生</option>
                    </select>
                </div>
                <div style="margin-top:30px;">
                    <div>
                        <input type="submit" class="btn btn-info btn-block" value="提交"/>&nbsp;&nbsp;
                        <input type="button" class="btn btn-success btn-block" onclick="location.href='${pageContext.request.contextPath}/login.jsp'" value="返回登录"/>&nbsp;&nbsp;
                    </div>
                </div>
                <br/>
            </form>
        </div>
    </div>
</div>
</body>
</html>
${pageContext.session.removeAttribute("mess")}