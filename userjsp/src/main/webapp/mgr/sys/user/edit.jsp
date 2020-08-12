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
            <label class="layui-form-label">*密码</label>
            <div class="layui-input-inline">
                <input name="password" lay-verify="required" id="password" type="password" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item" lay-filter="sex">
            <label class="layui-form-label DIV">姓名</label>
            <div class="layui-input-inline">
                <input name="name" id="name" type="text" readonly="true" class="layui-input">

            </div>
        </div>
        <div class="layui-form-item" lay-filter="sex">
            <label class="layui-form-label">*角色</label>
            <div class="layui-input-inline">

                <select name="role" id="role" lay-verify="required">
                    <option value="">请选择</option>
                    <option value="1">管理员</option>
                    <option value="0">普通用户</option>
                </select>
            </div>
        </div>
        <div class="layui-form-item" lay-filter="sex">
            <label class="layui-form-label">*部门</label>
            <div class="layui-input-inline">
                <input name="department" id="department" lay-verify="required" type="text" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item" lay-filter="sex">
            <label class="layui-form-label">职位</label>
            <div class="layui-input-inline">
                <input name="position" id="position" type="text" class="layui-input">

            </div>
        </div>
        <div class="layui-form-item" lay-filter="sex">
            <label class="layui-form-label">*用户类型</label>
            <div class="layui-input-inline">

                <select name="userType" id="userType" lay-verify="required">
                    <option value="">请选择</option>
                    <option value="1">可登陆</option>
                    <option value="0">不可登陆</option>
                </select>
            </div>
        </div>


        <div class="layui-form-item layui-hide">
            <input type="button" lay-submit lay-filter="LAY-user-role-submit" id="LAY-user-role-submit" value="确认">
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
                 userType: "${user.userType }",
                 name: "${user.name }",
                 role: "${user.role }"
             })
            
        })
    </script>
</body>

</html>