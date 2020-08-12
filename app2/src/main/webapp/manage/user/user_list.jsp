<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>layuiAdmin 后台管理员</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
        content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/layuiAdmin/layuiadmin/layui/css/layui.css"
        media="all">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/layuiAdmin/layuiadmin/style/admin.css" media="all">
</head>

<body>

    <div class="layui-fluid">
        <div class="layui-card">
            <div class="layui-form layui-card-header layuiadmin-card-header-auto">
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label" style="width: 50px;">账号</label>
                        <div class="layui-input-inline" style="width: 100px;">
                            <input name="accounts" id="accounts" autocomplete="off" class="layui-input">
                            <span id="accounts_tishi"></span>
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label" style="width: 50px;">姓名</label>
                        <div class="layui-input-inline" style="width: 100px;">
                            <input class="layui-input" name="name" id="name" autocomplete="off">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label" style="width: 70px;">用户类型</label>
                        <div class="layui-input-inline" style="width: 100px;">
                            <input name="userType" id="userType" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">角色</label>
                        <div class="layui-input-block">
                            <select name="role">
                                <option value="">请选择</option>
                                <option value="1">管理员</option>
                                <option value="0">普通用户</option>
                            </select>
                        </div>
                    </div>
                    <div class="layui-inline">
                        <button class="layui-btn layuiadmin-btn-admin" lay-submit lay-filter="LAY-user-back-search">
                            <i class="layui-icon layui-icon-search layuiadmin-button-btn"></i>
                        </button>
                    </div>
                </div>
            </div>

            <div class="layui-card-body">
                <div style="padding-bottom: 10px;">
                    <button class="layui-btn layuiadmin-btn-admin" data-type="add"><i
                            class="layui-icon">&#xe654;</i>添加用户</button>
                </div>

                <table id="LAY-user-back-manage" lay-filter="LAY-user-back-manage"></table>
                <script type="text/html" id="barDemo">
                    <a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="edit"><i class="layui-icon layui-icon-edit"></i>编辑</a>
                    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del"><i class="layui-icon layui-icon-delete"></i>删除</a>
                  </script>
            </div>
        </div>
    </div>

    <script src="${pageContext.request.contextPath }/layuiAdmin/layuiadmin/layui/layui.js"></script>
    <script>
        layui.config({
            base: '${pageContext.request.contextPath }/layuiAdmin/layuiadmin/' //静态资源所在路径
        }).extend({
            index: 'lib/index' //主入口模块
        }).use(['index', 'table', 'form'], function () {
            var $ = layui.$
                , form = layui.form
                , table = layui.table;

            //表格渲染
            table.render({
                elem: '#LAY-user-back-manage',
                url: '/app2/user/user_list.ajax' //模拟接口
                ,
                cols: [
                    [{
                        title: '主键',
                        field: 'iuser',
                        align: 'center',
                        width: 100,
                        unresize: true
                    }, {
                        title: '账号',
                        field: 'accounts',
                        align: 'center',
                        width: 100,
                        unresize: true
                    }, {
                        title: '密码',
                        field: 'password',
                        align: 'center',
                        width: 90,
                        unresize: true
                    }, {
                        title: '部门',
                        field: 'department',
                        align: 'center',
                        width: 130,
                        unresize: true
                    }, {
                        title: '职位',
                        field: 'position',
                        align: 'center',
                        width: 140,
                        unresize: true
                    }, {
                        title: '姓名',
                        field: 'name',
                        align: 'center',
                        width: 100,
                        unresize: true
                    }, {
                        title: '用户类型',
                        field: 'userType',
                        align: 'center',
                        width: 150,
                        unresize: true,
                        templet: function (item) {
                            if (item.userType == 1) {
                                return "可登陆";
                            } else {
                                return "不可登陆";
                            }
                        }
                    }, {
                        title: '角色',
                        field: 'role',
                        align: 'center',
                        width: 100,
                        unresize: true,
                        templet: function (item) {
                            if (item.role == 1) {
                                return "管理员";
                            } else {
                                return "普通用户";
                            }

                        }
                    }, {
                        title: '操作',
                        align: 'center',
                        toolbar: '#barDemo',
                        width: 250,
                        unresize: true
                    }, {
                        title: '',
                        field: '',
                        align: 'right',
                    }]
                ],
                page: true,
                limit: 15,
                limits: [5, 10, 15, 30, 50],
                height: 'full-220',
                text: '对不起，加载出现异常！'
            });


            //监听搜索
            form.on('submit(LAY-user-back-search)', function (data) {
                var field = data.field;
                console.log(field);
                //执行重载
                table.reload('LAY-user-back-manage', {
                    where: field
                });
            });

            //事件
            var active = {
                add: function () {
                    layer.open({
                        type: 2
                        , title: '添加用户'
                        , content: 'user2_add.jsp'
                        , maxmin: true
                        , area: ['1100px', '500px']
                        , btn: ['确定', '取消']
                        , yes: function (index, layero) {
                            var iframeWindow = window['layui-layer-iframe' + index]
                                , submitID = 'LAY-user-back-submit'
                                , submit = layero.find('iframe').contents().find('#' + submitID);
                            //监听提交
                            iframeWindow.layui.form.on('submit(' + submitID + ')', function (data) {
                                var field = data.field; //获取提交的字段
                                //提交 Ajax 成功后，更新表格中的数据
                                //$.ajax({});
                                $.ajax({
                                    type: "POST",
                                    url: "/app2/user/user_add.ajax",
                                    data: field,
                                    dataType: "json",
                                    success: function (msg) {
                                        if (msg.code == -1) {
                                            layer.alert("该员工已存在，请重新输入", {
                                                icon: 6
                                            });
                                        } else if (msg.code == "0") {
                                            layer.alert("增加成功", {
                                                icon: 6
                                            });
                                        } else if (msg.code == "-2") {
                                            layer.alert(msg.verify, {
                                                icon: 6
                                            });
                                        }
                                    },
                                    error: function () {
                                        layer.alert("增加失败!", {
                                            icon: 6
                                        });
                                    }
                                });
                                table.reload('LAY-user-back-manage'); //数据刷新
                                layer.close(index); //关闭弹层
                            });

                            submit.trigger('click');
                        }
                    });
                }
            }
            $('.layui-btn.layuiadmin-btn-admin').on('click', function () {
                var type = $(this).data('type');
                active[type] ? active[type].call(this) : '';
            });

            //监听工具条
            table.on('tool(LAY-user-back-manage)', function (obj) {
                var data = obj.data;
                sessionStorage.setItem('iuser', data.iuser)
                if (obj.event === 'del') {
                    layer.confirm('确定删除此角色？', function (index) {
                        $.ajax({
                            url: '/app2/user/user_delete.ajax',
                            type: 'post', //如果无需自定义HTTP类型，可不加该参数
                            dataType: "json",
                            data: {
                                iuser: data.iuser
                            },
                            success: function (res) {
                                if (res.code == 0) {
                                    layer.alert("删除成功");
                                    obj.del();
                                    table.reload("LAY-user-back-manage");
                                } else {
                                    layer.alert("由于未知错误，删除失败，请稍后重试");
                                }
                            }
                        });

                        layer.close(index);
                    });
                } else if (obj.event === 'edit') {
                    // var tr = $(obj.tr);

                    layer.open({
                        type: 2,
                        title: '编辑用户',
                        content: 'user2_edit.html',
                        area: ['500px', '480px'],
                        btn: ['确定', '取消'],
                        yes: function (index, layero) {
                            var iframeWindow = window['layui-layer-iframe' + index],
                                submit = layero.find('iframe').contents().find("#LAY-user-role-submit");

                            //监听提交
                            iframeWindow.layui.form.on('submit(LAY-user-role-submit)', function (data) {
                                var field = data.field; //获取提交的字段
                                console.log(field);
                                //提交 Ajax 成功后，静态更新表格中的数据
                                //$.ajax({});
                                $.ajax({
                                    type: "POST",
                                    url: "/app2/user/user_edit.ajax",
                                    data: field,
                                    dataType: "json",
                                    success: function (
                                        msg) {
                                        if (msg.code == 0) {
                                            layer.alert(
                                                "修改成功",
                                                {
                                                    icon: 6
                                                });
                                        } else if (msg.code == -2) {
                                            layer.alert(
                                                msg.verify,
                                                {
                                                    icon: 6
                                                });
                                        }

                                    },
                                    error: function () {
                                        layer
                                            .alert(
                                                "修改失败!",
                                                {
                                                    icon: 6
                                                });
                                    }

                                });
                                table.reload('LAY-user-back-manage'); //数据刷新
                                layer.close(index); //关闭弹层
                            });

                            submit.trigger('click');
                        },
                        success: function (layero, index) {
                        }
                    })

                }
            });
        });

    </script>
</body>

</html>