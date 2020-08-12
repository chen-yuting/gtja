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
            <input name="istudent" id="istudent" type="hidden" readonly="true" class="layui-input">
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">姓名</label>
            <div class="layui-input-inline">
                <input name="name" id="name" readonly="true" type="text" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">年龄</label>
            <div class="layui-input-inline">
                <input name="age" id="age" readonly="true" type="text" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item" lay-filter="sex">
            <label class="layui-form-label">入学时间</label>
            <div class="layui-input-inline">
                <input name="time" id="time" readonly="true" type="text" class="layui-input">
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
        }).use(['index', 'form', 'table','laydate'], function () {
            var $ = layui.$
                , form = layui.form
                , table = layui.table
                , laydate = layui.laydate;


                //渲染时间选择框
                laydate.render({
                    elem: '#time',
                    trigger:'click'
                });
                
            form.val('layuiadmin-form-useradmin', {
                istudent: "${student.istudent }",
                name: "${student.name}",
                age: "${student.age}",
                time: function () {
                    var date = "${student.time}"
                    date = date.substring(0, 10);
                    return date;
                }
            })
        })
    </script>
</body>

</html>