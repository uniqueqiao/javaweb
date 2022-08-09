<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
		.form-control{
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
							$("#clazz").append("<option name='stu.group.id' value='"+c.id+"'>"+c.clazz.name+"----"+c.name+"</option>")
						}
					},
					"json"
			);
			//异步请求 根据id查到一个学生并填入
			$.get(
					"${pageContext.request.contextPath}/student/ShowOneAction",
					"id="+${param.id},
					function (result){//result存的数组 存的Student对象
						//name
						$("input[name='stu.name']").val(result.name);
						//qq
						$("input[name='stu.qq']").val(result.qq);
						//phone
						$("input[name='stu.phone']").val(result.phone);
						//group_clazz
						$("#clazz option[value="+result.city.id+"]").prop("selected",true);
						//city
						$("#city option[value="+result.city.id+"]").prop("selected",true);
						//遍历tags
						for(var i=0;i<result.tags.length;i++){
							var id=result.tags[i].id;
							$("#tag input[value="+id+"]").prop("checked",true);
						}
						//mark
						$("input[name='stu.mark']").val(result.mark );
						/*$("#div1").append().html(result.mark );*/
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
			<form action="${pageContext.request.contextPath}/student/UpdateAction" method="post">
				<div class="form-group">
					<label>ID:</label>
					<input readonly name="stu.id" value="${param.id}" class="form-control" >
				</div>
				<div class="form-group">
					<label>名称:</label>
					<input type="text" name="stu.name" value="" class="form-control"/>
				</div>
				<div class="form-group">
					<label>QQ:</label>
					<input type="text" name="stu.qq" value="" class="form-control" />

				</div>
				<div class="form-group">
					<label>Phone:</label>
					<input type="text" name="stu.phone" value="" class="form-control">
				</div>
				<div class="form-group">
					<label for="clazz">选择班级-小组:</label>
					<select class="form-control" name="stu.group.id" id="clazz">
						<%-- ajax --%>
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
						<%-- ajax --%>
					</div>
				</div>
				<div class="form-group">
					<label>备注:</label>
					<div id="div1">

					</div>
					<input type="text" name="stu.mark" <%--style="display: none;"--%>class="form-control"  id="markContent"/>
				</div>
				<button type="submit" class="btn btn-info btn-block btn-sm">保存学生信息</button>
			</form>
		</div>
	</div>
</div>
</body>
</html>
<%--<script src="https://cdn.jsdelivr.net/npm/wangeditor@latest/dist/wangEditor.min.js"></script>
<script type="text/javascript">
	const E = window.wangEditor
	const editor = new E('#div1');
	editor.config.height = 250;
	editor.config.onchange = function (newHtml) {
		document.getElementById("markContent").value = newHtml;
	};
	editor.create();
</script>--%>
