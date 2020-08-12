<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!doctype html>
<html lang="en">

	<head>
		<meta charset="UTF-8">
		<title>后台登录</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/x-admin/css/font.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath }/x-admin/css/xadmin.css">
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.3.1.js"></script>
		<script src="${pageContext.request.contextPath }/x-admin/lib/layui/layui.js" charset="utf-8"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/x-admin/js/xadmin.js"></script>
	</head>

	<body onload="loadTopWindow()" class="login-bg">
		<div class="login layui-anim layui-anim-up">
			<div class="message">国泰君安系统人员登录</div>
			<div id="darkbannerwrap"></div>

			<form method="post" class="layui-form" id="login_form">
				<input id="accounts"  lay-verify="required" placeholder="用户名" type="text"  class="layui-input">
				<hr class="hr15">
				<input id="password" lay-verify="required" placeholder="密码" type="password" class="layui-input">
				<hr class="hr15">
				<input value="登录" lay-submit lay-filter="login" style="width: 100%;" type="submit">
				<hr class="hr20">
			</form>
		</div>

		<script>
			$(function() {
				layui.use('form', function() {
					var form = layui.form;
					form.on('submit(login)', function(data) {
						var accounts=$('#accounts').val()
						var password=$('#password').val()
						$.ajax({
							type: "post",
							url: "checklogin.ajax",
							dataType: "json",
							data: {
								accounts:accounts,
								password:password
							},
							success: function(data) {
								if(data.status == "1") {
									window.location.href = 'index.mvc';
								} else {
									alert("密码错误");
								}
							},
							error: function() {
								alert("网络错误");
							}
						});
						return false;
					});
				});
			})
			
			function loadTopWindow(){
			    if (window.top != null && window.top.document.URL != document.URL){
			    	window.top.location = document.URL; 
			    }
			}
		</script>

		<!-- 底部结束 -->
	</body>

</html>