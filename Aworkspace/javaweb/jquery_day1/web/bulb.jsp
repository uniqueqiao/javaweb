<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8" %>
<%@page import="java.util.* , java.io.* " %>
<%@page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>title</title>
    <script type="text/javascript" src="jquery-1.8.3.js"></script>
    <script type="text/javascript">
        $(function (){
            //有参数
            //$("#btn").toggle(function(){f1();},function(){f2();});
          $("#btn").toggle(f1,f2);//只有无参才可以这样简写
        });
        function f1(){
            //修改图片标签的src
            //1. 获取图片标签对象//2. 修改图片的src属性
            $("#img1").prop("src","image/bulb_on.png");
        }
        function f2(){
            //修改图片标签的src
            //1. 获取图片标签对象//2. 修改图片的src属性
            $("#img1").prop("src","image/bulb_off.png");
        }
    </script>
</head>
<body>
<img id="img1" src="image/bulb_off.png"><br><br>
<input type="button" value="on/off"  id="btn" >
</body>
</html>