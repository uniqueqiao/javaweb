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
        <title>城市列表</title>
        <script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/jquery-1.8.3.min.js"></script>
        <script type="text/javascript">
            $(function () {
                // 网页加载完成后执行
                // 为name叫做aa的标签添加事件
                $("a[name='aa']").click( function(){
                    var ba = window.confirm("您确定要删除吗？");
                    if( ba == true ){
                        var id = $(this).parent().prev().prev().html();
                        location.href = "${pageContext.request.contextPath}/city/DeleteAction?id="+id;
                    }
                });
            });
        </script>
    </head>
    <body>

        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-12">
                    <input type="button" class="btn btn-success btn-sm" value="添加城市" onclick="location.href='${pageContext.request.contextPath}/city/add.jsp'"/>
                </div>
            </div>
            <div class="row" style="margin-top: 15px;">
                <div class="col-sm-12">
                    <table class="table table-striped table-bordered table-hover">
                        <tr>
                            <th>编号</th>
                            <th>名称</th>
                            <th>操作</th>
                        </tr>
                        <c:forEach var="city" items="${sessionScope.list}" >
                            <tr>
                                <td>${city.id}</td>
                                <td>${city.name}</td>
                                <td>
                                    <a href="javascript:void(0);"  name="aa" class="btn btn-danger btn-sm">删除</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>

        </div>
    </body>
</html>
