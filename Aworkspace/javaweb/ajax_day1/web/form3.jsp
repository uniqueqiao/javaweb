<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8" %>
<%@page import="java.util.* , java.io.* " %>
<%@page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style type="text/css">
        span{
            color: indianred;
        }
    </style>
    <script type="text/javascript" src="${pageContext.request.contextPath}/jquery-1.8.3.js"></script>
    <script type="text/javascript">
        $(function() {
            $("#username").blur(function() {
                //发送ajax异步请求
                //1.创建异步请求对象
                var xhr;
                if(window.XMLHttpRequest){
                    xhr=new XMLHttpRequest();
                }else {
                    xhr=new ActiveXObject("Microsoft.XMLHTTP");
                }
                //初始化异步请求  发送

                xhr.open("post","${pageContext.request.contextPath}/user/CheckAction2",true);
                xhr.setRequestHeader("content-type","application/x-www-form-urlencoded");
                xhr.send("username="+$("#username").val());
                //3.处理响应结果
                xhr.onreadystatechange=function () {
                    if(xhr.readyState==4&&xhr.status==200){
                        console.log(xhr.responseText);
                        $("#mess1").html(xhr.responseText);
                    }
                };
            });
        });

    </script>
</head>
<body>
    <form method="post" >
      username<input type="text" name="username" id="username"/><span id="mess1">*</span><%--<img src=""/>--%><br><br>
      password<input type="password" name="password" id="password"/><span id="mess2">*</span><br><br>
      <input type="submit" value="注册">
    </form>
</body>
</html>