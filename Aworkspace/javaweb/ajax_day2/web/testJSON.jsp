<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8" %>
<%@page import="java.util.* , java.io.* " %>
<%@page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title></title>
        <script type="text/javascript" src="${pageContext.request.contextPath}/jquery-1.8.3.js"></script>
        <script type="text/javascript">
            //网页全部加载完成
            $(function () {
                //btn1添加单击事件
                $("#btn1").click(function () {
                    //发送异步请求
                    var xhr;
                    if(window.XMLHttpRequest){
                        xhr=new XMLHttpRequest();
                    }else {
                        xhr=new ActiveXObject("Microsoft.XMLHTTP");
                    }
                    //初始化异步请求  发送
                    xhr.open("get" , "${pageContext.request.contextPath}/stu/ShowAllAction",true);
                    xhr.send();
                    //3.处理响应结果
                    xhr.onreadystatechange=function () {
                        if(xhr.readyState==4&&xhr.status==200){
                            var  result=xhr.responseText;
                            console.log(result);
                            console.log(typeof result);
                            //result 是一个String 不能直接遍历 需要转换成js里数组对象
                            var jsArr=$.parseJSON(result);
                            console.log("---------");
                            console.log(jsArr);
                            console.log(typeof jsArr);
                            //遍历JSArr数组
                            $("#tbody tr:gt(0)").remove();
                            for(var i=0;i< jsArr.length;i++){
                                var stu=jsArr[i];
                                $("<tr></tr>").append($("<td>"+stu.id+"</td>"))
                                    .append($("<td>"+stu.name+"</td>"))
                                    .append($("<td>"+stu.age+"</td>"))
                                    .append($("<td>"+stu.birthday+"</td>"))
                                    .appendTo($("#tbody"));
                            }

                        }
                    };
                });
                $("#btn2").click(function () {
                    //发送异步请求
                    var xhr;
                    if(window.XMLHttpRequest){
                        xhr=new XMLHttpRequest();
                    }else {
                        xhr=new ActiveXObject("Microsoft.XMLHTTP");
                    }
                    //初始化异步请求  发送
                    xhr.open("get" , "${pageContext.request.contextPath}/stu/ShowOneAction?id=1",true);
                    xhr.send();
                    //3.处理响应结果
                    xhr.onreadystatechange=function () {
                        if(xhr.readyState==4&&xhr.status==200){
                            var  result=xhr.responseText;
                            //result 是一个String 学生对象
                            var stu=$.parseJSON(result);
                            //清理之前的数据、
                            $("#tbody tr:gt(0)").remove();
                            $("<tr></tr>").append("<td>"+stu.id+"</td>")
                                .append("<td>"+stu.name+"</td>")
                                .append("<td>"+stu.age+"</td>")
                                .append("<td>"+stu.birthday+"</td>")
                                .appendTo($("#tbody"));
                        }
                    };

                });
            });

        </script>
    </head>
    <body>
        <form action="" method="get">
            <input type="button" id="btn1" value="查所有">
            <input type="button" id="btn2" value="查一个">
        </form>
        <table border="solid 1px" bordercolor="indianred" cellspacing="0px">
            <tbody id="tbody">
            <tr >
                <td>id</td>
                <td>name</td>
                <td>age</td>
                <td>birthday</td>
            </tr>
            </tbody>
        </table>
    </body>
</html>