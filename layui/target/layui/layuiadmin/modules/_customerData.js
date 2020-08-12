


layui.define(['table', 'form'], function (exports) {
    var $ = layui.$,
        table = layui.table,
        form = layui.form;


    //客群数据管理
    table.render({
        elem: '#LAY-customerData-back-manage',
        url: 'list.ajax',
        toolbar: true,
        defaultToolbar: ['exports'],
        title: '客群数据表'
        ,cols: [
            	[{
                    type: 'checkbox'
                }, 
                {
                    title: '主键',
                    field: 'icustomerData',
                    align: 'center',
                    width: 100,
                    unresize: true
                }, {
                    title: '客户姓名',
                    field: 'customerName',
                    align: 'center',
                    width: 100,
                    unresize: true
                }, {
                    title: '营业部',
                    field: 'businessDepartment',
                    align: 'center',
                    width: 90,
                    unresize: true
                }, {
                    title: '资金账号',
                    field: 'capitalAccount',
                    align: 'center',
                    width: 130,
                    unresize: true
                }, {
                    title: '司内资产',
                    field: 'internalAssets',
                    align: 'center',
                    width: 140,
                    unresize: true
                }, {
                    title: '司外资产',
                    field: 'extradivisionalAssets',
                    align: 'center',
                    width: 100,
                    unresize: true
                }, {
                    title: '司内资产类别',
                    field: 'internalAssetsType',
                    align: 'center',
                    width: 150,
                    unresize: true,
                }, {
                    title: '投资偏好',
                    field: 'investmentPreference',
                    align: 'center',
                    width: 150,
                    unresize: true,
                }, {
                    title: '前次营销时间',
                    field: 'previousMarketingDate',
                    align: 'center',
                    width: 150,
                    unresize: true,
                }, {
                    title: '下次营销时间',
                    field: 'nextMarketingDate',
                    align: 'center',
                    width: 150,
                    unresize: true,
                }, {
                    title: '操作',
                    align: 'center',
                    toolbar: '#barDemo',
                    width: 250,
                    unresize: true
                }]
            ],
        page: true,
        limit: 15,
        limits: [5, 10, 15, 30, 50],
        height: '500',
        text: '对不起，加载出现异常！'
    });



    //监听表格双击事件
    table.on('rowDouble(LAY-customerData-back-manage)', function (obj) {
        var data = obj.data
        sessionStorage.setItem('icustomerData', data.icustomerData)
        layer.open({
            type: 2,
            title: '详情',
            content: '/layui/mgr/customerData/detail.html',
            area: ['500px', '450px']
        })
    })

    //监听工具条
    table.on('tool(LAY-customerData-back-manage)', function (obj) {
        var data = obj.data;
        sessionStorage.setItem('icustomerData', data.icustomerData);
        if (obj.event === 'del') {
            layer.confirm('确定删除此角色？', function (index) {
                $.ajax({
                    url: 'delete.ajax',
                    type: 'post', //如果无需自定义HTTP类型，可不加该参数
                    dataType: "json",
                    data: {
                    	icustomerData: data.icustomerData
                    },
                    success: function (res) {
                        if (res.code == 0) {
                            layer.alert("删除成功");
                            obj.del();
                            table.reload("LAY-customerData-back-manage");
                        } else {
                            layer.alert("由于未知错误，删除失败，请稍后重试");
                        }
                    }
                });

                layer.close(index);
            });
        } else if (obj.event === 'edit') {
            var tr = $(obj.tr);

            layer.open({
                type: 2,
                title: '编辑',
                content: '/layui/mgr/customerData/edit.html',
                area: ['500px', '450px'],
                btn: ['确定', '取消'],
                yes: function (index, layero) {
                    var iframeWindow = window['layui-layer-iframe' + index],
                        submit = layero.find('iframe').contents().find("#LAY-customerData-role-submit");

                    //监听提交
                    iframeWindow.layui.form.on('submit(LAY-customerData-role-submit)', function (data) {
                        var field = data.field; //获取提交的字段
                        //提交 Ajax 成功后，静态更新表格中的数据
                        //$.ajax({});
                        $.ajax({
                            type: "POST",
                            url: "edit.ajax",
                            data: field,
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
                                table.reload("LAY-customerData-back-manage"); //数据刷新

                            },
                            error: function () {
                                layer
                                    .alert(
                                        "修改失败!", {
                                            icon: 6
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

    exports('_customerData', {})
});