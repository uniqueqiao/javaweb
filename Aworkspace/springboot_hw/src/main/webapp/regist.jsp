<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8" %>
<%@page import="java.util.* , java.io.* " %>
<%@page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>regist</title>
        <script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/jquery-1.8.3.min.js"></script>
    </head>
    <body><%--onchange="checkUsername()"--%>
    <form action="${pageContext.request.contextPath}/reg" method="post" enctype="multipart/form-data" id="form1">
        用户名：<input type="text" id="ipt-username" name="username" onchange="checkUsername()"><br>
        密码：<input type="text" name="password"><br>
        头像：<input type="file" name="photo"><br>
        <button type="button" onclick="submitForm1()">注册</button><br>
        <input type="button" value="返回" onclick="location.href='login.jsp'"><br>
        <div style="color: red" id="error-msg">${requestScope.errorMess}</div>
    </form>
  <%--  <form action="${pageContext.request.contextPath}/reg" id="form1" enctype="multipart/form-data" method="post">
        用户名：<input type="text" name="username" onchange="checkName()" id="username"><br>
        密码：<input type="password" name="password"><br>
        上传头像：<input type="file" name="photo"/><br>
        <input type="button"  onclick="submitForm1()" value="注册"/>
        <input type="button" value="返回" onclick="location.href='login.jsp'"><br>
        <span style="color: red" id="errorMess">${requestScope.errorMess}</span>
    </form>--%>
    <script>
        //获取标签对应的jQuery对象
        var iptUsername = $("#ipt-username");
        var form1 = $("#form1");
        var errorMsg = $("#error-msg");
        //先假定用户名不能用，之后能用时手动设置为true
        var usernameOK = false;
        console.log(usernameOK)
        function checkUsername(){
            //获取用户名
            var username = iptUsername.val();
            console.log(username)
            //使用ajax请求，在后端验证用户名是否可用
            $.get("${pageContext.request.contextPath}/registCheck?username=" + username, function (data){
                //后端响应的对象中的status属性表示是否可用
                usernameOK = data.status;
                console.log(data.status)
                console.log(usernameOK)
                if(!usernameOK){
                    //后端响应中的message属性表示错误信息
                    errorMsg.text(data.message);
                }
            })
        }

        function submitForm1(){
            if(usernameOK){
                //如果用户名可用，手动提交表单
                form1.submit()
            }
        }
    </script>
    </body>
</html>