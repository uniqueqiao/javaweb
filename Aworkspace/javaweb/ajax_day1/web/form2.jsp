<%@page contentType="text/html;charset=UTF-8"  pageEncoding="UTF-8" %>
<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/jquery-1.8.3.js"></script>
    <script type="text/javascript">
        $( function(){
            // 为username文本框添加失去焦点事件的代码
            $("#username").blur(function(){
                // 发送ajax的异步请求
                // 1. 创建异步请求对象
                var xhr;
                if( window.XMLHttpRequest){
                    xhr = new XMLHttpRequest();     // ---- 0
                }else{
                    xhr = new ActiveXObject("Microsoft.XMLHTTP");
                }
                // 2. 初始化异步请求 和  发送
                xhr.open("get","${pageContext.request.contextPath}/user/CheckAction2?username="+$("#username").val() , true);  // 1
                xhr.send();   // 2
                // 3. 处理响应结果
                xhr.onreadystatechange = function(){
                    if( xhr.readyState==4 && xhr.status==200 ){
                        console.log( xhr.responseText );
                        $("#mess1").html( xhr.responseText );
                    }
                };
            });

        });

    </script>
</head>
<body>

<form action="" method="get">

    username :  <input type="text" name="username" id="username"/> <span id="mess1">*</span>

    <br/><br/>

    password: <input type="password" name="password" />   <br/><br/>

    <input type="submit" value="注册" />

</form>

</body>
</html>