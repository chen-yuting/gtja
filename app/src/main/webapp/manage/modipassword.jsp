<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
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
.layui-form-mlabel {
	float: left;
	display: block;
	padding: 9px 15px;
	width: 90px;
	font-weight: 400;
	line-height: 20px;
	text-align: right;
}

.x-body {
	padding: 20px;
	margin-left: 30px;
}
</style>
</head>

<body style="align-text: center;">

	<div class="x-body">
		<form class="layui-form" method="post">
			<div class="layui-form-item">
				<label class="layui-form-mlabel"> 原密码： </label>
				<div class="layui-input-inline">
					<input name="oldpw" id="oldpw" type="password" autocomplete="off"
						class="layui-input">
				</div>
			</div>

			<div class="layui-form-item">
				<label class="layui-form-mlabel"> 新密码： </label>
				<div class="layui-input-inline">
					<input name="newpw" id="newpw" type="password" autocomplete="off"
						class="layui-input">
				</div>
			</div>

			<div class="layui-form-item">
				<label class="layui-form-mlabel"> 确认新密码： </label>
				<div class="layui-input-inline">
					<input name="againnewpw" id="againnewpw" type="password"
						autocomplete="off" class="layui-input">
				</div>
			</div>

			<div class="layui-form-item">
				<label class="layui-form-mlabel"> </label>
				<button type="button" id="btn" class="layui-btn layui-bg-cyan"
					>确定</button>
				<button type="button" class="layui-btn layui-bg-cyan"
					onclick="back()">返回</button>
			</div>
		</form>
	</div>

	<script>
		$(function() {
			$("#btn").click(function() {

				var oldpw = $("#oldpw").val();
				var newpw = $("#newpw").val();
				var againnewpw = $("#againnewpw").val();
				if (newpw != againnewpw) {
					alert("两次输入的新密码不一致");
					return;
				}
				$.ajax({

					type : "POST",

					url : "modipassword.ajax",

					data : {
						'oldpw' : oldpw,
						'newpw' : newpw,
						'againnewpw' : againnewpw
					},

					dataType : "json",
					success : function(data) {
						if (data.msg == '1') {
							alert("密码修改成功");
						} else {
							alert("密码修改失败");
						}

					}

				});

			});
		})

		/* $(function() {
						$.ajax({

							type: "POST",

							url: "",

							data: {
								'imeet': parent.transferData.imeet,
								'iempl': parent.transferData.iempl
							},

							dataType: "json",
							success: function(data) {
								if(data == '') {

								}

							}

						});
					}) */
	</script>
</body>

</html>