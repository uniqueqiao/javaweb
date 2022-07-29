<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8" %>
<%@page import="java.util.* , java.io.* " %>
<%@page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <script type="text/javascript" src="${pageContext.request.contextPath}/jquery-1.8.3.js"></script>
        <script type="text/javascript">
            //网页全部加载完成
            $(function () {
                //异步请求
                $.get(
                    "${pageContext.request.contextPath}/prov/ShowAllProvinceAction",
                    function (result){//result存的数组 存的province对象
                        //遍历
                        for(var i=0;i<result.length;i++){
                            var p=result[i];
                            $("#prov").append("<option value='"+p.code+"'>"+p.name+"</option>")
                        }
                    },
                    "json"
                );
                // 为prov添加change事件
                $("#prov").change(function(){
                    // 发送异步请求，加载city数据
                    $.get(
                        "${pageContext.request.contextPath}/city/ShowCityByPcodeAction",
                        "pcode="+$("#prov option:selected").val() ,
                        function(result){   // result是city数组
                            // 清空city option
                            $("#city option:gt(0)").remove();
                            for (var i = 0; i < result.length; i++) {
                                var c = result[i];
                                $("#city").append("<option value='"+c.code+"'>"+c.name+"</option>");
                            }
                        },
                        "json"
                    );
                });
                // 为city添加change事件
                $("#city").change(function () {
                    // 发送异步请求，加载area数据
                    $.get(
                        "${pageContext.request.contextPath}/area/ShowAreaByCityCodeAction",
                        "ccode="+$("#city option:selected").val(),
                        function (result){//result存的area对象数组
                            //清空area的option
                            $("#area option:gt(0)").remove();
                            for (var i=0;i<result.length;i++){
                                var a=result[i];
                                $("#area").append("<option value='"+a.code+"'>"+a.name+"</option>");
                            }
                        },
                        "json"
                    );
                });

            });
        </script>
    </head>
    <body>
    <h2>省市区二级联动下拉列表</h2>
    <select id="prov" name="prov">
        <option>请选择</option>
    </select>
    <select id="city" name="city">
        <option>请选择</option>
    </select>
    <select id="area" name="area">
        <option>请选择</option>
    </select>
    </body>
</html>