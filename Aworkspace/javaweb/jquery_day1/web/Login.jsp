<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>login</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css"
          href="css/style.css"/>
    <script src="jquery-1.8.3.js"></script>
    <style type="text/css">
        span{
            color: red;
            font-size: 15px;
        }
        .ok{
            color: green;
        }
    </style>
    <script type="text/javascript">
        $(function() {
            $("#username").blur(function() { checkName(this);});
            $("#psw1").blur(function() { checkPsw1(this);});
            $("#psw2").blur(function() { checkPsw2(this);});
            $("#form1").submit(function() { return  checkForm(this);});
        });
        function checkName(tag){
            //获取输入的数据
            var username=$(tag).val();
            //修改span的内容
            var mess1=$(tag).next();
            if(username.length<7){
                //alert("用户名长度非法");
                //修改mess1内容 用innerHTML属性
                mess1.removeClass().html("用户名长度非法,必须大于7位");
            }else {
                mess1.html("√").addClass("ok");
            }
        }
        function checkPsw1(tag){
            //获取输入的数据
            var psw1value=$(tag).val();
            //修改span的内容
            var mess2=$(tag).next();
            if(psw1value.length<6||psw1value.length>15 ){
                //修改mess2内容 用innerHTML属性
                mess2.removeClass().html("密码长度非法,必须大于等于6位小于等于15位");
                return false;
            }else {
                mess2.addClass("ok").html("√");
                return true;
            }
        }
        function checkPsw2(tag){
            //获取密码1
            var psw1value=$("#psw1").val();
            //获取输入的数据
            var psw2value=$(tag).val();
            //修改span的内容
            var mess3=$(tag).next();
            if(psw2value.length<6||psw2value.length>15){
                //修改mess3内容 用innerHTML属性
                mess3.removeClass().html("密码长度非法,必须大于等于6位小于等于15位");
                return false;
            }else {
                if(psw1value==psw2value){
                    mess3.addClass("ok").html("√");
                    return true;
                }else {
                    mess3.html("两次密码不一致").removeClass();
                    return false;
                }
            }
        }
        //$(tag).children().children().next().children().next().children().html()
        // 函数判断表单是否具备提交条件，span标签的数量  和  ok样式标签的数量  相等则返回true，反之返回false
        function checkForm(){
            checkName($("#username"));
            checkPsw1($("#psw1"));
            checkPsw2($("#psw2"));
            //span数量与“ok”数量相等
            //获取所有span标签 spans是一个数组
            var spans=$("span").length;
            //通过class样式名 获取网页中应用了这种样式的标签
            var oks=$("span[class=ok]").length;
            //alert(spans.length);alert(oks.length);
            if(spans == oks){
                return true;
            }else{
                return false;
            }
            //return spans.length == oks.length;
        }
    </script>
</head>
    <body>
        <div id="wrap">
            <div id="top_content">
                <div id="header">
                    <div id="rightheader">
                        <p>
                            2022/7/12
                            <br/>
                        </p>
                    </div>
                    <div id="topheader">
                        <h1 id="title">
                            <a href="#">main</a>
                        </h1>
                    </div>
                    <div id="navigation">
                    </div>
                </div>
                <div id="content">
                    <p id="whereami">
                    </p>
                    <h1>注册
                    </h1>
                    <form id="form1" action="${pageContext.request.contextPath}/index.jsp" method="get" >
                        <table cellpadding="0" cellspacing="0" border="0"
                               class="form_table">
                            <tr>
                                <td valign="middle" align="right">username:</td>
                                <td valign="middle" align="left">
                                    <input type="text" class="inputgri"  name="userName" id="username" />
                                    <span id="mess1">*</span>
                                </td>
                            </tr>
                            <tr>
                                <td valign="middle" align="right">password:</td>
                                <td valign="middle" align="left">
                                    <input type="password" class="inputgri" name="password" id="psw1" />
                                    <span id="mess2" >*</span>
                                </td>
                            </tr>
                            <tr>
                                <td valign="middle" align="right">password2:</td>
                                <td valign="middle" align="left">
                                    <input type="password" class="inputgri" name="password2" id="psw2" />
                                    <span id="mess3">*</span>
                                </td>
                            </tr>
                        </table>
                        <input type="submit" id="submit" value="注册">
                    </form>
                </div>
            </div>
            <div id="footer">
                <div id="footer_bg">
                    ABC@126.com
                </div>
            </div>
        </div>
    ${pageContext.session.removeAttribute("mess")}
    </body>
</html>
