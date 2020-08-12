<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/x-admin/css/font.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/x-admin/css/xadmin.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/sdmscss/user.css">
<script type="text/javascript"
	src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script
	src="${pageContext.request.contextPath }/x-admin/lib/layui/layui.js"
	charset="utf-8"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/x-admin/js/xadmin.js"></script>

</head>
<body class="user_add">
	<div class="x-body layui-anim layui-anim-up">
		<form class="layui-form " method="post">

			<fieldset class="layui-elem-field">

				<legend>用户信息</legend>
				<tr class="odd" hidden="hidden">

				</tr>

				<div class="layui-field-box" style="align: left;">
					<div class="layui-form-item">
						<div class="layui-input-inline">
							<input name="iuser" id="iuser" type="hidden" value=${user.iuser }
								readonly="true" class="layui-input">

						</div>
						<label class="layui-form-label DIV">账号</label>
						<div class="layui-input-inline">
							<input name="accounts" id="accounts" type="text"
								value=${user.accounts } readonly="true" class="layui-input">

						</div>

						<label class="layui-form-label DIV DIV">*密码</label>
						<div class="layui-input-inline">
							<input name="password" id="password" type="password"
								class="layui-input" value=${user.password }>

						</div>

						<label class="layui-form-label " style="align: left;">*部门</label>
						<div class="layui-input-inline">
							<input name="department" id="department" type="text"
								class="layui-input" value=${user.department }>
						</div>
					</div>
					<div class="layui-form-item">

						<label class="layui-form-label DIV">职位</label>
						<div class="layui-input-inline">
							<input name="position" id="position" type="text"
								class="layui-input" value=${user.department }>

						</div>


						<label class="layui-form-label DIV">*用户类型</label>
						<div class="layui-input-inline">

							<select name="userType" id="userType" lay-verify="">
								<option value="">请选择</option>
								<option value="1">可登陆</option>
								<option value="0">不可登陆</option>
							</select>
						</div>
						<label class="layui-form-label DIV">姓名</label>
						<div class="layui-input-inline">
							<input name="name" id="name" type="text" class="layui-input" readonly="true" value=${user.name }
								 >

						</div>
					</div>
					<div class="layui-form-item"></div>
					<div class="layui-form-item">

						<label class="layui-form-label DIV">*角色</label>
						<div class="layui-input-inline">

							<select name="role" id="role" lay-verify="">
								<option value="">请选择</option>
								<option value="1">管理员</option>
								<option value="0">普通用户</option>
							</select>
						</div>
					</div>

				</div>
			</fieldset>
	</div>

	<center>
		<div class="layui-form-item">
			<button class="layui-btn" lay-submit="" lay-filter="add">提交</button>
			<!-- <button type="reset" class="layui-btn">重置</button> -->
			<button type="button" class="layui-btn layui-bg-cyan"
				onclick="back()">返回</button>
		</div>
	</center>
	</form>
	</div>


	<script>
		layui
				.use(
						[ 'form', 'layer' ],
						function() {
							$ = layui.jquery;
							var form = layui.form, layer = layui.layer;

							//监听提交
							form
									.on(
											'submit(add)',
											function(data) {
												//发异步，把数据提交给php
												var postData = $("form")
														.serialize(); //序列化表单，后台可正常通过post方法获取数据
												$
														.ajax({
															type : "POST",
															url : "/app/user/user_edit.ajax",
															data : postData,
															dataType : "json",
															success : function(
																	msg) {
																if (msg.code == 0) {
																	layer
																			.alert(
																					"修改成功",
																					{
																						icon : 6
																					},
																					function() {
																						// 获得frame索引
																						window.location.href = "/app/user/user_list.html";
																					});
																} else if (msg.code == -2) {
																	layer
																			.alert(
																					msg.verify,
																					{
																						icon : 6
																					});
																}

															},
															error : function() {
																layer
																		.alert(
																				"修改失败!",
																				{
																					icon : 6
																				});
															}

														});

												return false;
											});

						});

		function back() {
			// 获得frame索引

			window.history.go(-1);

		}
	</script>


</body>

</html>