<%@page import="javassist.ClassPath"%>
<%@ page language="java" contentType="text/html; charset=utf8" isELIgnored="false"
	pageEncoding="utf8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>layuiAdmin 后台管理员</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
        content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/layuiadmin/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/layuiadmin/style/admin.css" media="all">
</head>

<body>

    <div class="layui-fluid">
        <div class="layui-card">
            <div class="layui-form layui-card-header layuiadmin-card-header-auto">
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">姓名</label>
                        <div class="layui-input-block">
                            <input type="text" name="roleName" placeholder="请输入" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">创建时间(起)</label>
                        <div class="layui-input-block">
                            <input type="text" name="beginCrtTime" id="beginCrtTime" placeholder="请输入"
                                autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">创建时间(终)</label>
                        <div class="layui-input-block">
                            <input type="text" name="endCrtTime" id="endCrtTime" placeholder="请输入" autocomplete="off"
                                class="layui-input">
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

                    <button class="layui-btn layuiadmin-btn-admin" data-type="batchdel">批量删除</button>
                    <button class="layui-btn layuiadmin-btn-admin" data-type="add"><i
                            class="layui-icon">&#xe654;</i>添加角色</button>
                </div>

                <table id="LAY-user-back-manage" lay-filter="LAY-user-back-manage"></table>
                <script type="text/html" id="table-bar">
                    <a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="edit"><i class="layui-icon layui-icon-edit"></i>编辑</a>
                    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del"><i class="layui-icon layui-icon-delete"></i>删除</a>
                </script>
            </div>
        </div>
    </div>

    <script src="${pageContext.request.contextPath }/layuiadmin/layui/layui.js"></script>
    <script>
        layui.config({
            base: '${pageContext.request.contextPath }/layuiadmin/' //静态资源所在路径
        }).extend({
            index: 'lib/index' //主入口模块
        }).use(['index', '_sys_role', 'table', 'laydate'], function () {
            var $ = layui.$
                , form = layui.form
                , table = layui.table
                , laydate = layui.laydate;


            //渲染时间选择框
            laydate.render({
                elem: '#beginCrtTime' //或 elem: document.getElementById('test')、elem: lay('#test') 等
            });
            laydate.render({
                elem: '#endCrtTime'
            });

            //监听搜索
            form.on('submit(LAY-user-back-search)', function (data) {
                var field = data.field;
                //执行重载
                table.reload('LAY-user-back-manage', {
                    where: field
                });
            });

            //事件
            var active = {
                batchdel: function () {
                    var checkStatus = table.checkStatus('LAY-user-back-manage')
                        , checkData = checkStatus.data
                        , iroles = []
                        , irole = {}; //得到选中的数据

                    if (checkData.length === 0) {
                        return layer.msg('请选择数据');
                    }
                    checkData.forEach(function (element) {
                        irole = {
                            irole: element.irole
                        }
                        iroles.push(irole);
                    });
                    if (iroles.length != 0) {
                        layer.confirm('确定删除？', function (index) {
                            $.ajax({
                                url: 'batchDelete.ajax',
                                type: 'post', //如果无需自定义HTTP类型，可不加该参数
                                dataType: "json",
                                data: {
                                    json: JSON.stringify(iroles)
                                },
                                success: function (res) {
                                    if (res.code == 0) {
                                        layer.alert("删除成功");
                                        table.reload("LAY-user-back-manage");
                                    } else {
                                        layer.alert("由于未知错误，删除失败，请稍后重试");
                                    }
                                }
                            });
                            layer.close(index);

                        });
                    }
                }
                , add: function () {
                    layer.open({
                        type: 2
                        , title: '添加'
                        , content: 'add.mvc'
                        , area: ['400px', '400px']
                        , btn: ['确定', '取消']
                        , yes: function (index, layero) {
                            var iframeWindow = window['layui-layer-iframe' + index]
                                , submitID = 'LAY-user-back-submit'
                                , submit = layero.find('iframe').contents().find('#' + submitID);

                            //监听提交
                            iframeWindow.layui.form.on('submit(' + submitID + ')', function (data) {
                                var field = data.field; //获取提交的字段
                                //提交 Ajax 成功后，静态更新表格中的数据
                                //$.ajax({});
                                $.ajax({
                                    type: "POST",
                                    url: "add.ajax",
                                    data: field,
                                    dataType: "json",
                                    success: function (msg) {
                                        if (msg.code == "0") {
                                            layer.alert("增加成功", {
                                                icon: 6
                                            });
                                            table.reload('LAY-user-back-manage'); //数据刷新
                                        }
                                    },
                                    error: function () {
                                        layer.alert("增加失败!", {
                                            icon: 6
                                        });
                                    }
                                });

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
        });
    </script>
</body>

</html>