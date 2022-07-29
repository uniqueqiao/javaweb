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
                    $.ajax({
                        type:"get",//配置请求的发送方式
                        url:"${pageContext.request.contextPath}/stu/ShowAllAction",//配置请求目的地地址
                        dataType:"json",//json转换成js对象  text 直接使用
                        success:function(result){//result等价于responseText
                            //此时result 是一个数组
                            //处理结果数据的js代码 如果dataType 是json转换成js对象  text 直接使用
                            $("#tbody tr:gt(0)").remove();
                            for(var i=0;i< result.length;i++){
                                var stu=result[i];
                                $("<tr></tr>").append($("<td>"+stu.id+"</td>"))
                                              .append($("<td>"+stu.name+"</td>"))
                                              .append($("<td>"+stu.age+"</td>"))
                                              .append($("<td>"+stu.birthday+"</td>"))
                                              .appendTo($("#tbody"));
                            }
                        }
                    });
                });
                //为btn2添加单击事件
                $("#btn2").click(function () {
                    //通过$.get()
                    $.get(
                        "${pageContext.request.contextPath}/stu/ShowOneAction",
                        "id=1",
                        function(result){//此时result是js里的对象
                            $("#tbody tr:gt(0)").remove();
                            $("<tr></tr>").append("<td>"+result.id+"</td>")
                                .append("<td>"+result.name+"</td>")
                                .append("<td>"+result.age+"</td>")
                                .append("<td>"+result.birthday+"</td>")
                                .appendTo($("#tbody"));
                        },
                        "json"

                    );
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