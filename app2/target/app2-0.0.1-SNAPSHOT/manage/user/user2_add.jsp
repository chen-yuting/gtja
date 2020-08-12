<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>layuiAdmin 网站用户 iframe 框</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
        content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/layuiAdmin/layuiadmin/layui/css/layui.css"
        media="all">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
</head>

<body>

    <div class="layui-form" lay-filter="layuiadmin-form-useradmin" id="layuiadmin-form-useradmin"
        style="padding: 20px 0 0 0;">
        <div class="layui-form-item">
            <label class="layui-form-label">*账号</label>
            <div class="layui-input-inline">
                <input type="text" name="accounts" id="accounts" lay-verify="required" placeholder="请输入用户名"
                    autocomplete="off" class="layui-input" onblur="checkAccounts()">
            </div>
            <label class="layui-form-label DIV" style="color: red; display: none" name="tishi" id="tishi">账号已存在</label>
            <label class="layui-form-label DIV DIV">*密码</label>
            <div class="layui-input-inline">
                <input name="password" id="password" type="text" lay-verify="required" placeholder="请输入密码"
                    class="layui-input">
            </div>
            <label class="layui-form-label">*部门</label>
            <div class="layui-input-inline">
                <input name="department" id="department" type="text" lay-verify="required" placeholder="请输入部门"
                    class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label DIV">职位</label>
            <div class="layui-input-inline">
                <input name="position" id="position" type="text" class="layui-input">
            </div>
            <label class="layui-form-label DIV">姓名</label>
            <div class="layui-input-inline">
                <input name="name" id="name" type="text" class="layui-input">
            </div>
            <label class="layui-form-label DIV">*用户类型</label>
            <div class="layui-input-inline">
                <select name="userType" id="userType" lay-verify="required">
                    <option value="">请选择</option>
                    <option value="1">可登陆</option>
                    <option value="0">不可登陆</option>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label DIV">*角色</label>
            <div class="layui-input-inline">
                <select name="role" id="role" lay-verify="required">
                    <option value="">请选择</option>
                    <option value="1">管理员</option>
                    <option value="0">普通用户</option>
                </select>

            </div>
        </div>

        <div class="layui-form-item layui-hide">
            <input type="button" lay-submit lay-filter="LAY-user-back-submit" id="LAY-user-back-submit" value="确认">
        </div>
    </div>

    <script src="${pageContext.request.contextPath }/layuiAdmin/layuiadmin/layui/layui.js"></script>
    <script>
        layui.config({
            base: '${pageContext.request.contextPath }/layuiAdmin/layuiadmin/' //静态资源所在路径
        }).extend({
            index: 'lib/index' //主入口模块
        }).use(['index', 'form', 'upload'], function () {
            var $ = layui.$
                , form = layui.form;
        })
        function checkAccounts() {

            $.ajax({
                url: '/app2/user/check_accounts.ajax',
                type: 'post',
                dataType: "json",
                data: {
                    accounts: accounts.value
                },
                success: function (res) {

                    if (res.code == 1) {
                        $('#tishi').css("display", "none");
                        return true;
                    } else if (res.code == 0) {

                        $('#tishi').css("display", "block");
                        return false;
                    }
                }
            });
        }
    </script>
</body>

</html>