<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/x-admin/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/x-admin/css/xadmin.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/sdmscss/user.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath }/x-admin/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/x-admin/js/xadmin.js"></script>

</head>

<body class="user_add">
    <div class="x-body layui-anim layui-anim-up">
        <form class="layui-form " method="post">
            <fieldset class="layui-elem-field">
                <legend>用户信息</legend>
                <div class="layui-form-item">
                    <label class="layui-form-label DIV">*账号</label>
                    <div class="layui-input-inline">
                        <input name="accounts" id="accounts" type="text" class="layui-input" onblur="checkAccounts()">


                    </div>
                    <label class="layui-form-label DIV DIV" style="color: red; display: none" name='tishi"
                        id=' tishi'>账号已存在</label>

                    <label class="layui-form-label DIV DIV">*密码</label>
                    <div class="layui-input-inline">
                        <input name="password" id="password" type="text" " class=" layui-input">
                    </div>
                    <label class="layui-form-label " style="align: left;">*部门</label>
                    <div class="layui-input-inline">
                        <input name="department" id="department" type="text" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label DIV">职位</label>
                    <div class="layui-input-inline">
                        <input name="position" id="position" type="text" class="layui-input">
                    </div>
                    <label class="layui-form-label DIV DIV">姓名</label>
                    <div class="layui-input-inline">
                        <input name="name" id="name" type="text" class="layui-input">
                    </div>
                    <label class="layui-form-label DIV">*用户类型</label>
                    <div class="layui-input-inline">
                        <select name="userType" id="userType" lay-verify="">
                            <option value="">请选择</option>
                            <option value="1">可登陆</option>
                            <option value="0">不可登陆</option>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item"></div>
                <div class="layui-form-item">
                    <label class="layui-form-label DIV">*角色</label>
                    <div class="layui-input-inline">
                        <select name="role" id="role" lay-verify="">
                            <option value="">请选择</option>
                            <option value="1">管理员</option>
                            <option value="0">普通用户</option>
                        </select>

                    </div>
                </div>
    </div>
    </div>
    </fieldset>






    <center>
        <div class="layui-form-item">
            <button class="layui-btn" lay-submit="" lay-filter="add">提交</button>
            <!-- <button type="reset" class="layui-btn">重置</button> -->
            <button type="button" class="layui-btn layui-bg-cyan" onclick="back()">返回</button>
        </div>
    </center>
    </form>
    </div>

    <script>
        layui.use(['form', 'layer'], function () {
            $ = layui.jquery;
            var form = layui.form, layer = layui.layer;

            //监听提交
            form.on('submit(add)', function (data) {
                //发异步，把数据提交给php
                var postData = $("form").serialize(); //序列化表单，后台可正常通过post方法获取数据
                $.ajax({
                    type: "POST",
                    url: "/app2/user/user_add.ajax",
                    data: postData,
                    dataType: "json",
                    success: function (msg) {
                        if (msg.code == -1) {
                            layer.alert("该员工已存在，请重新输入", {
                                icon: 6
                            });
                        } else if (msg.code == "0") {
                            layer.alert("增加成功", {
                                icon: 6
                            }, function () {
                                // 获得frame索引

                                var index = parent.layer
                                    .getFrameIndex(window.name);
                                //关闭当前frame
                                parent.layer.close(index);
                                parent.tableIns.reload();
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

                return false;
            });

        });
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
        function displayHideUI() {
            var ui = document.getElementById("tishi");
            ui.style.display = "none";
        }

        function back() {
            // 获得frame索引

            var index = parent.layer.getFrameIndex(window.name);
            //关闭当前frame
            parent.layer.close(index);

            parent.tableIns.reload();

        }
    </script>



</body>

</html>