layui.define(['table', 'form'], function (exports) {
    var $ = layui.$,
        table = layui.table,
        form = layui.form;

    //角色管理
    table.render({
        elem: '#LAY-user-back-manage',
        url: 'list.ajax' //模拟接口/layui/user/user_list.ajax
            ,
        cols: [
            [{
                    type: 'checkbox'
                }, //开启复选框    
                {
                    title: '主键',
                    field: 'istudent',
                    align: 'center',
                    width: 100,
                    unresize: true,
                    hide: true
                }, {
                    title: '姓名',
                    field: 'name',
                    align: 'center',
                    width: 140,
                    unresize: true
                }, {
                    title: '年龄',
                    field: 'age',
                    align: 'center',

                    unresize: true
                }, {
                    title: '入学时间',
                    field: 'time',
                    align: 'center',
                    unresize: true
                }, {
                    title: '操作',
                    width: 200,
                    align: 'center',
                    fixed: 'right',
                    toolbar: '#table-bar'
                }
            ]
        ],
        page: true,
        limit: 15,
        limits: [5, 10, 15, 30, 50],
        height: '500',
        text: {
            none: '暂无相关数据！'
        }
    });



    //监听表格双击事件
    table.on('rowDouble(LAY-user-back-manage)', function (obj) {
        var data = obj.data
        layer.open({
            type: 2,
            title: '详情',
            content: 'detail.mvc?istudent=' + data.istudent,
            area: ['500px', '450px']
        })
    })

    //监听工具条
    table.on('tool(LAY-user-back-manage)', function (obj) {
        var data = obj.data;
        if (obj.event === 'del') {
            layer.confirm('确定删除？', function (index) {
                $.ajax({
                    url: 'delete.ajax',
                    type: 'post', //如果无需自定义HTTP类型，可不加该参数
                    dataType: "json",
                    data: {
                        istudent: data.istudent
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
        } else if (obj.event === 'edit') {
            var tr = $(obj.tr);
            console.log();
            layer.open({
                type: 2,
                title: '编辑',
                content: 'edit.mvc?istudent=' + obj.data.istudent,
                area: ['500px', '450px'],
                btn: ['确定', '取消'],
                yes: function (index, layero) {
                    var iframeWindow = window['layui-layer-iframe' + index],
                        submit = layero.find('iframe').contents().find("#LAY-user-role-submit");

                    //监听提交
                    iframeWindow.layui.form.on('submit(LAY-user-role-submit)', function (data) {
                        var field = data.field; //获取提交的字段
                        //提交 Ajax 成功后，静态更新表格中的数据
                        //$.ajax({});
                        $.ajax({
                            type: "POST",
                            url: "edit.ajax",
                            data: {
                                istudent: field.istudent,
                                name: field.name,
                                age: field.age,
                                time: field.time
                            },
                            dataType: "json",
                            success: function (msg) {
                                var icon = 6;
                                if (msg.code == 1) {
                                    icon = 5
                                }
                                layer.alert(
                                    msg.msg, {
                                        icon: icon
                                    });
                                table.reload("LAY-user-back-manage");
                            },
                            error: function () {
                                layer
                                    .alert(
                                        "修改失败!", {
                                            icon: 5
                                        });
                            }

                        });

                        layer.close(index); //关闭弹层
                    });

                    submit.trigger('click');
                },
                success: function (layero, index) {

                }
            })
        }
    });

    exports('_school_student', {})
});