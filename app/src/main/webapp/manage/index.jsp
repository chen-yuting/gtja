<%@page import="javassist.ClassPath"%>
<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">

<head>
<meta charset="UTF-8">
<base target="_self">
<title>后台管理导航</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/x-admin/css/font.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/x-admin/css/xadmin.css">
<script type="text/javascript"
	src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script
	src="${pageContext.request.contextPath }/x-admin/lib/layui/layui.js"
	charset="utf-8"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/x-admin/js/xadmin.js"></script>
<style>
.layui-nav .layui-nav-child a {
	color: black;
}
</style>
</head>

<body>
	<!-- 顶部开始 -->
	<div class="container">
		<div class="logo">
			<a href="${pageContext.request.contextPath }/manage/index.html">国泰君安后台管理系统</a>
		</div>
		<div class="left_open">
			<i title="展开左侧栏" class="iconfont">&#xe699;</i>
		</div>

		<ul class="layui-nav right" lay-filter="">
			<li class="layui-nav-item"><span style="cursor: pointer;">
					<c:choose>
						<c:when test="${user != null }">${user.accounts }</c:when>
					</c:choose>
			</span> <c:if test="${user != null }">
					<dl class="layui-nav-child">
						<!-- 二级菜单 -->
						<dd onclick="persInfo();"
							style="color: black; cursor: pointer; text-align: center;"
							onfocus="">
							<span>个人信息</span>
						</dd>
						<dd onclick="modiPW();"
							style="color: black; cursor: pointer; text-align: center;">
							<span>修改密码</span>
						</dd>
						<dd onclick="logout();"
							style="color: black; cursor: pointer; text-align: center;">
							<span>退出</span>
						</dd>
						<!-- <dd>
							<a onclick="x_admin_show('切换帐号','http://www.baidu.com')">切换帐号</a>
						</dd> -->
					</dl>
				</c:if></li>
			<!--<li class="layui-nav-item to-index">
					<a href="/">前台首页</a>
				</li>-->
		</ul>

	</div>
	<!-- 顶部结束 -->
	<!-- 中部开始 -->
	<!-- 左侧菜单开始 -->
	<div class="left-nav">
		<div id="side-nav">
			<ul id="nav">

				<ul>
					<li><a
						_href="${pageContext.request.contextPath }/customerData/customerData_list.html">
							<i class="iconfont">&#xe6a7;</i> <cite>客群数据管理</cite>
					</a></li>
				</ul>

				<ul>
					<li><a _href="${pageContext.request.contextPath }"> <i
							class="iconfont">&#xe6a7;</i> <cite>*客群数据流水管理</cite>
					</a></li>
				</ul>

				<ul>
					<li><a _href="${pageContext.request.contextPath }"> <i
							class="iconfont">&#xe6a7;</i> <cite>*客群归属管理</cite>
					</a></li>
				</ul>

				<ul>
					<li><a _href="${pageContext.request.contextPath }"> <i
							class="iconfont">&#xe6a7;</i> <cite>*后台数据管理</cite>
					</a></li>
				</ul>

				<ul>
					<li><a _href="${pageContext.request.contextPath }"> <i
							class="iconfont">&#xe6a7;</i> <cite>*报表管理</cite>
					</a></li>
				</ul>

				<ul>
					<li><a _href="${pageContext.request.contextPath }"> <i
							class="iconfont">&#xe6a7;</i> <cite>*权限管理</cite>
					</a></li>
				</ul>

				<ul>
					<li><a
						_href="${pageContext.request.contextPath }/user/user_list.html">
							<i class="iconfont">&#xe6a7;</i> <cite>系统用户管理</cite>
					</a></li>
				</ul>
			</ul>
		</div>
	</div>
	<!-- 右侧主体开始 -->
	<div class="page-content">
		<div class="layui-tab tab" lay-filter="xbs_tab" lay-allowclose="false">
			<ul class="layui-tab-title">
				<li class="home"><i class="layui-icon">&#xe68e;</i>我的桌面</li>
			</ul>
			<div class="layui-tab-content">
				<div class="layui-tab-item layui-show">
					<iframe id="mainFrame"
						src="${pageContext.request.contextPath }/manage/welcome.html"
						frameborder="0" scrolling="yes" class="x-iframe"></iframe>
				</div>
			</div>
		</div>
	</div>
	<div class="page-content-bg"></div>
	<!-- 右侧主体结束 -->
	<!-- 中部结束 -->
	<!-- 底部开始 -->
	<div class="footer">
		<div class="copyright">Copyright ©2017 x-admin v2.3 All Rights
			Reserved</div>
	</div>
	<!-- 底部结束 -->
	<script>
		layui.use('element', function() {
			var element = layui.element;

			//一些事件监听
			element.on('leftMenu', function() {
				window.open('javascript:;', 'mainFrame');
			});
			element.on('nav()', function(elem) {
				window.open('javascript:;', 'mainFrame');
			});
		});

		function logout() {
			$.ajax({
				type : "get",
				url : "${pageContext.request.contextPath }/manage/logout.ajax",
				async : true
			});

			window.location.href = "${pageContext.request.contextPath }/manage/login.mvc";
		}
		function persInfo() {

			x_admin_show('个人信息',
					'${pageContext.request.contextPath }/manage/test/test_edit.jsp');

		}
		function modiPW() {

			x_admin_show(
					'修改密码',
					'${pageContext.request.contextPath }/manage/modipassword.jsp',
					500, 300);

		}
	</script>
</body>

</html>