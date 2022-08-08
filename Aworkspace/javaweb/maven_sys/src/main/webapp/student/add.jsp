<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>添加学生</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/statics/css/bootstrap.min.css">
    <style>
        .form-control {
            height: 30px;
        }
    </style>
    <script type="text/javascript" src="${pageContext.request.contextPath}/jquery-1.8.3.js"></script>
    <script type="text/javascript">
        $(function () {
            // 网页加载完成后执行
            //异步请求 学生tag
            $.get(
                "${pageContext.request.contextPath}/tag/ShowAllStuTagAction",
                function (result){//result存的数组 存的clazz对象
                    //遍历
                    for(var i=0;i<result.length;i++){
                        var c=result[i];
                        $("#tag").append("<label style='margin-right: 5px;'><input type='checkbox' name='tids' value='"+c.id+"'>"+c.name+"</label>")
                    }
                },
                "json"
            );
            //异步请求 city
            $.get(
                "${pageContext.request.contextPath}/city/ShowAllCityAction",
                function (result){//result存的数组 存的clazz对象
                    //遍历
                    for(var i=0;i<result.length;i++){
                        var c=result[i];
                        $("#city").append("<option name='stu.city.id' value='"+c.id+"'>"+c.name+"</option>")
                    }
                },
                "json"
            );
            //异步请求 班级名+组名
            $.get(
                "${pageContext.request.contextPath}/group/ShowAllGroupAndCLazzAction",
                function (result){//result存的数组 存的clazz对象
                    //遍历
                    for(var i=0;i<result.length;i++){
                        var c=result[i];
                        $("#clazz").append("<option name='stu.city.id' value='"+c.id+"'>"+c.clazz.name+"----"+c.name+"</option>")
                    }
                },
                "json"
            );
        });
    </script>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-offset-2 col-sm-8">
            <form action="${pageContext.request.contextPath}/student/AddAction" method="post">
                <div class="form-group">
                    <label>名称:</label>
                    <input type="text" name="stu.name" class="form-control" >
                </div>
                <div class="form-group">
                    <label>生日:</label>
                    <input type="date" name="stu.bir" class="form-control" >
                </div>
                <div class="form-group">
                    <label>QQ:</label>
                    <input type="text" name="stu.qq" class="form-control" >

                </div>
                <div class="form-group">
                    <label>Phone:</label>
                    <input type="text" name="stu.phone" class="form-control">
                </div>
                <div class="form-group">
                    <label for="clazz">选择班级-小组:</label>
                    <select class="form-control" name="stu.group.Id" id="clazz">
                        <%--ajax--%>
                    </select>
                </div>
                <div class="form-group">
                    <label for="city">就业城市:</label>
                    <select class="form-control" name="stu.city.id" id="city">
                        <%-- ajax --%>
                    </select>
                </div>
                <div class="form-group">
                    <label>请选择标签:</label>
                    <div class="checkbox" name="tids" id="tag">
                        <%--ajax异步请求 --%>
                    </div>
                </div>
                <div class="form-group">
                    <label>备注:</label>
                        <div id="div1"></div>
                        <input type="text" name="mark" style="display: none;" id="markContent"/>
                </div>
                <button type="submit" class="btn btn-info btn-block btn-sm">保存学生信息</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
<script src="https://cdn.jsdelivr.net/npm/wangeditor@latest/dist/wangEditor.min.js"></script>
<script type="text/javascript">
    const E = window.wangEditor
    const editor = new E('#div1');
    editor.config.height = 250;
    editor.create()
</script>