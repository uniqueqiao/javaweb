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
    <script src="${pageContext.request.contextPath}/statics/js/jquery-1.8.3.min.js"></script>
</head>

<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-12">
            <h1 class="text-center">用户登录</h1>
        </div>
    </div>
    <div class="row" style="margin-top: 30px;">
        <div class="col-sm-4 col-sm-offset-4">
            <form action="${pageContext.request.contextPath}/user/LoginAction" method="post">
                <div class="form-group">
                    <label>用户名:</label>
                    <input type="text" class="form-control" name="u.username">
                </div>
                <div class="form-group">
                    <label >密&nbsp;&nbsp;码:</label>
                    <input type="password" name="u.password" class="form-control">${sessionScope.mess}
                </div>
                <div class="form-group">
                    <label >验证码:</label>
                    <div>
                        <input type="text" name="ucode" class="form-control" style="width: 50%;height:40px;float: left">
                        <img src="${pageContext.request.contextPath}/user/ImageAction" id="img" style="float: left;height: 40px;width: 30%;"/>
                        <a href="${pageContext.request.contextPath}/login.jsp" style="float: right;margin-top: inherit">看不清，换一张</a>
                    </div>
                    <div>

                    </div>
                </div>
                <div class="clearfix"></div>
                <div style="margin-top: 10px;">
                    <input class="btn btn-success btn-block" type="submit" value="登录"/>
                    <input class="btn btn-info btn-block" onclick="location.href='${pageContext.request.contextPath}/regist.jsp'" type="button" value="还没有账号,点我去注册"/>
                </div>
            </form>

        </div>
    </div>
</div>
</body>
</html>
${pageContext.session.removeAttribute("mess")}