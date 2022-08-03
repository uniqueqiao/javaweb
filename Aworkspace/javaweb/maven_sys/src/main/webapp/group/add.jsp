<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<title>添加班级</title>

	<meta name="keywords" content="keyword1,keyword2,keyword3">
	<meta name="description" content="this is my page">
	<meta name="content-type" content="text/html; charset=utf-8">
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/statics/css/bootstrap.min.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-1.8.3.js"></script>
	<script type="text/javascript">
		$(function () {
			// 网页加载完成后执行
			//异步请求
			$.get(
					"${pageContext.request.contextPath}/clazz/ShowAllClazzAction",
					function (result){//result存的数组 存的clazz对象
						//遍历
						for(var i=0;i<result.length;i++){
							var c=result[i];
							$("#clazz").append("<option value='"+c.id+"'>"+c.name+"</option>")
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
		<div class="col-sm-12">
			<form action="${pageContext.request.contextPath}/group/AddAction" method="post">
				<div class="form-group">
					<label>组名称</label>
					<input type="text" class="form-control" name="g.name"/>
				</div>
				<div class="form-group">
					<label>选择班级</label>
					<select class="form-control" name="g.clazz.id" id="clazz">

					</select>
				</div>
				<input type="submit" class="btn btn-danger btn-block btn-sm" value="提交"/>
				<input type="button" class="btn btn-info btn-block btn-sm" value="返回上级" onclick="history.go(-1);"/>
			</form>
		</div>
	</div>
</div>


