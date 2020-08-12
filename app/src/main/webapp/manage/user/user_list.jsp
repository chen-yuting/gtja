<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>JSP Page</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/x-admin/css/font.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/x-admin/css/xadmin.css">
<script type="text/javascript"
	src="http://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/x-admin/lib/layui/layui.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/x-admin/js/xadmin.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/export-excel.js"></script>
</head>

<body class="user_list">
	<div class="x-nav">
		<span class="layui-breadcrumb"> <a
			href="${pageContext.request.contextPath }/manage/index.html">首页</a> <a
			href="${pageContext.request.contextPath }/user/user_list.html">用户列表</a>

		</span> <a class="layui-btn layui-btn-small"
			style="line-height: 1.6em; margin-top: 3px; float: right"
			href="javascript:location.replace(location.href);" title="刷新"> <i
			class="layui-icon" style="line-height: 30px">ဂ</i></a>
	</div>
	<div class="x-body">
		<form class="layui-form " action="/user_list.ajax">
			<left>
			<div class="layui-form-item ">
				<div class="layui-inline">

					<label class="layui-form-label" style="width: 50px;">账号</label>
					<div class="layui-input-inline" style="width: 100px;">
						<input name="accounts" id="accounts" autocomplete="off"
							class="layui-input" >
						<span id="accounts_tishi"></span>
					</div>

					<label class="layui-form-label" style="width: 50px;">姓名</label>
					<div class="layui-input-inline" style="width: 100px;">
						<input class="layui-input"  name="name" id="name"
							autocomplete="off">
					</div>
					<label class="layui-form-label" style="width: 70px;">用户类型</label>
					<div class="layui-input-inline" style="width: 100px;">
						<input name="userType" id="userType"  autocomplete="off"
							class="layui-input">
					</div>

					<label class="layui-form-label" style="width: 50px;">角色</label>
					<div class="layui-input-inline" style="width: 100px;">
						<input name="role" id="role" required="required" autocomplete="off"
							class="layui-input">
					</div>
					<div class="layui-input-inline">
						<button class="layui-btn" lay-submit="" lay-filter="search">
							<i class="layui-icon">&#xe615;</i>
						</button>
					</div>
				</div>
			</div>
			</left>
		</form>
	</div>
	<xblock>
	<button class="layui-btn"
		onclick="x_admin_show('增加用户','user_add.html',1200,600)">
		<i class="layui-icon">&#xe654;</i>增加用户
	</button>

	</xblock>
	<table style="display: none;" class="layui-table" id="list"
		lay-filter="demo">
	</table>
</body>
<!--初始静态参数以及表格数据初始化-->

<script>
	var curr = 1;
	var limit = 15;
	var count;
	var tableIns;
	layui.use([ 'table', 'laypage' ], function() {
		var form = layui.form;
		var table = layui.table;
		var laypage = layui.laypage;
		/*渲染数据表格*/
		tableIns = table.render({
			elem : '#list',
			url : '/app/user/user_list.ajax',
			id : 'list',
			even : true,
			loading : true,
			limit : 15,
			limits : [ 5, 10, 15, 30, 50 ],
			page : {
				curr : 1,
				groups : 3,
				first : '首页',
				last : '尾页',
			},
			where : {
				accounts : $('#accounts').val(),
				name : $('#name').val(),
				userType : $('#userType').val(),
				role : $('#role').val()
			},
			cols : [ [ {
				title : '主键',
				field : 'iuser',
				align : 'center',
				width : 100,
				unresize : true
			}, {
				title : '账号',
				field : 'accounts',
				align : 'center',
				width : 100,
				unresize : true
			}, {
				title : '密码',
				field : 'password',
				align : 'center',
				width : 90,
				unresize : true
			}, {
				title : '部门',
				field : 'department',
				align : 'center',
				width : 130,
				unresize : true
			}, {
				title : '职位',
				field : 'position',
				align : 'center',
				width : 60,
				unresize : true
			}, {
				title : '姓名',
				field : 'name',
				align : 'center',
				width : 100,
				unresize : true
			}, {
				title : '用户类型',
				field : 'userType',
				align : 'center',
				width : 150,
				unresize : true,
				templet:function(item){
					if(item.userType == 1){
						return "可登陆";
					}else{
						return "不可登陆";
					}
				}
			}, {
				title : '角色',
				field : 'role',
				align : 'center',
				width : 100,
				unresize : true,
				templet:function(item){
					if(item.role==1){
						return "管理员";
					}else{
						return "普通用户";
					}
					
				}
			}, {
				title : '操作',
				align : 'center',
				toolbar : '#barDemo',
				width : 250,
				unresize : true
			}, {
				title : '',
				field : '',
				align : 'right',
			} ] ],
		});
	});
</script>
<!--表单提交的监听-->
<script>
	layui.use('form', function() {
		var form = layui.form;
		//监听提交
		form.on('submit(search)', function(data) {
			tableIns.reload({
				page : {
					curr : 1,
				},
				where : {
					accounts : $('#accounts').val(),
					name : $('#name').val(),
					userType : $('#userType').val(),
					role : $('#role').val()
				},
			});
			return false;
		});
	});
</script>
<!--在工具栏中添加增删改查按钮-->
<script type="text/html" id="barDemo">
		
		<a title="修改" class="layui-btn layui-btn-xs" lay-event="edit" href="javascript:;">
			修改&nbsp;
		</a>
		<a title="删除" class="layui-btn layui-btn-xs" lay-event="delete" href="javascript:;">
			删除
		</a>
	</script>
<script>
	var user;
	layui.use('table', function() {
		var table = layui.table;
		//监听工具条
		table.on('tool(demo)', function(obj) {
			var data = obj.data;
			console.log(obj);

			if (obj.event === 'edit') {
				post('user_edit.html', {
					'iuser' : data.iuser,
				});

			}
			if (obj.event === 'delete') {
				if (confirm("警告！确定删除用户【" + data.iuser + "】吗？")) {
					$.ajax({
						url : '/app/user/user_delete.ajax',
						type : 'post', //如果无需自定义HTTP类型，可不加该参数
						dataType : "json",
						data : {
							iuser : data.iuser
						},
						success : function(res) {
							if (res.code == 0) {
								layer.alert("删除成功");
								tableIns.reload();
							} else {
								layer.alert("由于未知错误，删除失败，请稍后重试");
							}
						}
					});
				}

			}
		});
	});

	function showd(url, width, height) {
		var indext = layer.open({
			type : 2,
			title : '编辑',
			maxmin : false,
			area : [ width + "px", height + "px" ],
			content : [ url, 'yes' ],
			resize : false
		});
	}

	function post(URL, PARAMS) {
		var temp = document.createElement("form");
		temp.action = URL;
		temp.method = "post";
		temp.style.display = "none";
		for ( var x in PARAMS) {
			var opt = document.createElement("textarea");
			opt.name = x;
			opt.value = PARAMS[x];
			temp.appendChild(opt);
		}
		document.body.appendChild(temp);
		temp.submit();
	}

	
</script>


</html>