<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>欢迎页面-X-admin2.0</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/x-admin/css/font.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/x-admin/css/xadmin.css">
</head>

<body onload="startClock()" onunload="stopClock()">
	<div class="x-body layui-anim layui-anim-up">
		<blockquote class="layui-elem-quote">
			欢迎管理员： <span class="x-red"> <c:choose>
					<c:when test="${user != null }">${user.accounts }</c:when>
				</c:choose></span>！当前时间:
			<div id="show" style="display: inline"></div>
		</blockquote>

		<script>
			var timer = null;
			function displayClock(num) {//num是传入的startClock中的动态值
				if (num < 10) {
					return "0" + num;
				} else {
					return num;
				}
			}
			//停止计时
			function stopClock() {
				clearTimeout(timer);
			}
			//开始计时
			function startClock() {
				var time = new Date();
				var years = displayClock(time.getFullYear()) + "年";
				var months = displayClock(time.getMonth() + 1) + "月";
				var dates = displayClock(time.getDate()) + "日";
				var hours = displayClock(time.getHours()) + "时";
				var minutes = displayClock(time.getMinutes()) + "分";
				var seconds = displayClock(time.getSeconds()) + "秒";
				//显示时间
				show.innerHTML = years + months + dates + hours + minutes
						+ seconds;//在id为show的块区域显示
				timer = setTimeout("startClock()", 1000);//延时器
			}
		</script>


		<fieldset class="layui-elem-field">
			<legend>数据统计</legend>
			<div class="layui-field-box">
				<div class="layui-col-md12">
					<div class="layui-card">
						<div class="layui-card-body">
							<div class="layui-carousel x-admin-carousel x-admin-backlog"
								lay-anim="" lay-indicator="inside" lay-arrow="none"
								style="width: 100%; height: 90px;">
								<div carousel-item="">
									<ul class="layui-row layui-col-space10 layui-this">
										<li class="layui-col-xs2"><a href="javascript:;"
											class="x-admin-backlog-body">
												<h3></h3>
												<p>
													<cite></cite>
												</p>
										</a></li>
										<li class="layui-col-xs2"><a href="javascript:;"
											class="x-admin-backlog-body">
												<h3></h3>
												<p>
													<cite></cite>
												</p>
										</a></li>
										<li class="layui-col-xs2"><a href="javascript:;"
											class="x-admin-backlog-body">
												<h3></h3>
												<p>
													<cite></cite>
												</p>
										</a></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</fieldset>
		<fieldset class="layui-elem-field">
			<legend>系统通知</legend>
			<div class="layui-field-box">
				<table class="layui-table" lay-skin="line">
					<tbody>
						<tr>
							<td><a class="x-a" href="/" target="_blank"></a></td>
						</tr>
					</tbody>
				</table>
			</div>
		</fieldset>
		<fieldset class="layui-elem-field">
			<legend>系统信息</legend>
			<div class="layui-field-box">
				<table class="layui-table">
					<tbody>
						<tr>
							<th>xxx版本</th>
							<td>1.0.180420</td>
						</tr>
						<tr>
							<th>服务器地址</th>
							<td>x.xuebingsi.com</td>
						</tr>
						<tr>
							<th>操作系统</th>
							<td>WINNT</td>
						</tr>
						<tr>
							<th>运行环境</th>
							<td>Apache/2.4.23 (Win32) OpenSSL/1.0.2j mod_fcgid/2.3.9</td>
						</tr>
						<tr>
							<th>MYSQL版本</th>
							<td>5.5.53</td>
						</tr>
						<tr>
							<th>上传附件限制</th>
							<td>2M</td>
						</tr>
						<tr>
							<th>执行时间限制</th>
							<td>30s</td>
						</tr>
						<tr>
							<th>剩余空间</th>
							<td>86015.2M</td>
						</tr>
					</tbody>
				</table>
			</div>
		</fieldset>
	</div>
</body>
</html>