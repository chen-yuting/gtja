<%@page import="javassist.ClassPath"%>
<%@ page language="java" contentType="text/html; charset=utf8" isELIgnored="false"
	pageEncoding="utf8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>添加用户</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
        content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/layuiadmin/layui/css/layui.css" media="all">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
</head>

<body>

    <form class="layui-form" lay-filter="layuiadmin-form-useradmin" id="layuiadmin-form-useradmin"
        style="padding: 20px 45px 0 0;">
        <div class="layui-form-item">
            <label class="layui-form-label">*用户名</label>
            <div class="layui-input-inline">
                <input type="text" name="roleName" id="roleName" lay-verify="required" placeholder="请输入用户名"
                    autocomplete="off" class="layui-input">
            </div>
            <label class="layui-form-label DIV DIV">描述</label>
            <div class="layui-input-inline">
                <input name="description" id="description" type="text" placeholder="请输入描述" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item layui-hide">
            <input type="button" lay-submit lay-filter="LAY-user-back-submit" id="LAY-user-back-submit" value="确认">
        </div>
    </form>

    <script src="${pageContext.request.contextPath }/layuiadmin/layui/layui.js"></script>
    <script>
        layui.config({
            base: '${pageContext.request.contextPath }/layuiadmin/' //静态资源所在路径
        }).extend({
            index: 'lib/index' //主入口模块
        }).use(['index', 'form'], function () {
            var $ = layui.$
                , form = layui.form;
        })
    </script>
</body>

</html>