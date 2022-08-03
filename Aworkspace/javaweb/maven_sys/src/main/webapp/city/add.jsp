<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8" %>
<%@page import="java.util.* , java.io.* " %>
<%@page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/statics/css/bootstrap.min.css">
    <title>添加城市</title>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-12">
            <form action="${pageContext.request.contextPath}/city/AddAction" method="post">
                <div class="form-group">
                    <label>
                        城市名称:
                    </label>
                    <input type="text" class="form-control" name="city.name"/>
                </div>

                <input type="submit" class="btn btn-success btn-block btn-sm" value="提交"/>
                <input type="button" class="btn btn-info btn-block btn-sm" value="返回上级" onclick="history.go(-1);"/>
            </form>
        </div>
    </div>
</div>

</body>
</html>