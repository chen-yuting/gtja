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
            <input name="irole" id="irole" type="hidden" readonly="true" class="layui-input">
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">用户名</label>
            <div class="layui-input-inline">
                <input name="roleName" id="roleName" readonly="true" type="text" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">描述</label>
            <div class="layui-input-inline">
                <input name="description" id="description" readonly="true" type="text" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item" lay-filter="sex">
            <label class="layui-form-label">创建时间</label>
            <div class="layui-input-inline">
                <input name="crtTime" id="crtTime" readonly="true" type="text" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item" lay-filter="sex">
            <label class="layui-form-label">修改时间</label>
            <div class="layui-input-inline">
                <input name="updTime" id="updTime" readonly="true" type="text" class="layui-input">
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
        }).use(['index', 'form', 'table'], function () {
            var $ = layui.$
                , form = layui.form
                , table = layui.table;
            form.val('layuiadmin-form-useradmin', {
                irole: "${role.irole }",
                roleName: "${role.roleName}",
                description: "${role.description}",
                crtTime: function () {
                    var date = "${role.crtTime}"
                    date = date.substring(0, 19);
                    return date;
                },
                updTime: function () {
                    var date = "${role.updTime}"
                    date = date.substring(0, 19);
                    return date;
                }
            })
        })
    </script>
</body>

</html>