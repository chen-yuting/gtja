<%@page import="javassist.ClassPath"%>
<%@ page language="java" contentType="text/html; charset=utf8" isELIgnored="false"
	pageEncoding="utf8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>编辑用户</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
        content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/layuiadmin/layui/css/layui.css" media="all">
</head>

<body>

    <div class="layui-form" lay-filter="layuiadmin-form-useradmin" id="layuiadmin-form-useradmin">
        <div class="layui-form-item">
            <input name="iuser" id="iuser" type="hidden" readonly="true" class="layui-input">
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">账号</label>
            <div class="layui-input-inline">
                <input name="accounts" id="accounts" type="text" readonly="true" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">密码</label>
            <div class="layui-input-inline">
                <input name="password" id="password" type="text" readonly="true" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item" lay-filter="sex">
            <label class="layui-form-label">姓名</label>
            <div class="layui-input-inline">
                <input name="name" id="name" type="text" readonly="true" class="layui-input">

            </div>
        </div>
        <div class="layui-form-item" lay-filter="sex">
            <label class="layui-form-label">角色</label>
            <div class="layui-input-inline">
                <input name="role" id="role" type="text" readonly="true" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item" lay-filter="sex">
            <label class="layui-form-label">部门</label>
            <div class="layui-input-inline">
                <input name="department" id="department" type="text" readonly="true" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item" lay-filter="sex">
            <label class="layui-form-label">职位</label>
            <div class="layui-input-inline">
                <input name="position" id="position" type="text" readonly="true" class="layui-input">

            </div>
        </div>
        <div class="layui-form-item" lay-filter="sex">
            <label class="layui-form-label">用户类型</label>
            <div class="layui-input-inline">
                <input name="userType" id="userType" type="text" readonly="true" class="layui-input">
            </div>
        </div>
    </div>
    <script src="${pageContext.request.contextPath }/layuiadmin/layui/layui.js"></script>
    <script>

        layui.config({
            base: '${pageContext.request.contextPath }/layuiadmin/' //静态资源所在路径
        }).extend({
            index: 'lib/index' //主入口模块
        }).use(['index', 'form'], function () {
            var $ = layui.$
                , form = layui.form
                , upload = layui.upload;
            form.val('layuiadmin-form-useradmin', {
                iuser: "${user.iuser }",
                accounts: "${user.accounts }",
                password: "${user.password }",
                department: "${user.department }",
                position: "${user.position }",
                userType: function () {
                    if ("${user.userType }" == 0) {
                        return '不可登录'
                    } else {
                        return '可登录'
                    }
                },
                name: "${user.name }",
                role: function () {
                    if ("${user.role }" == 0) {
                        return '普通用户'
                    } else {
                        return '管理员'
                    }
                }
            })

        })
    </script>
</body>

</html>