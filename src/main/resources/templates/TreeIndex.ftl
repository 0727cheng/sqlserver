<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>报表</title>
    <script src="/static/js/jquery.min.js"></script>
    <!-- 引入样式 -->
    <link rel="stylesheet" href="/static/layui/css/layui.css" media="all">
    <!-- 引入组件库 -->
    <script src="/static/layui/layui.js" charset="UTF-8"></script>
    <style>
        #iframeid {
            float: left;
            height: 1000px;
            width: 79%;
            border: 1px solid #c0c4cc;
        }

        #ureport2Box {
            width: 20.5%;
            float: left;
        }

        #ureport2 {
            margin: 30px 30px;
        }

        #button {
            margin: -8px 50px;
        }
        .selected{
            color: #01AAED;
        }
    </style>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">

    <div id="ureport2Box">
        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 21px;">
            <legend>报表菜单</legend>
        </fieldset>
        <a href="/ureport/designer" target="demo">
            <button class="layui-btn layui-btn-sm layui-btn-normal" id="button">新建报表</button>
        </a>
        <div id="ureport2" class="demo-tree-more" ></div>
    </div>


    <iframe name="demo" src="" frameborder="0" id="iframeid"></iframe>
</div>
</body>
<script type="text/javascript">
    //----------------------表格区域-------------------------
    layui.use(['tree', 'element'], function () {
        var $ = layui.jquery,
            tree = layui.tree,
            element = layui.element,
            data = [{
                title: '报表文件夹',
                spread: true,
                children: [
                    <#list fileNames as string>
                    {
                        title: '<a href="/ureport/designer?_u=file:${string!}" target="demo">${string!}</a>',
                        id:'${string!}'
                    },
                    </#list>
                ]
            }];
        //无连接线风格
        tree.render({
            elem: '#ureport2',
            data: data,
            edit: ['del'],
            showLine: false,  //是否开启连接线
            click: function (obj) { //点击节点回调
            },
            operate: function(obj) {
                var type = obj.type; //得到操作类型：add、edit、del
                var data = obj.data; //得到当前节点的数据

                if (type === 'del') { //删除节点
                    //Ajax 操作
                    $.ajax({
                        type: "post",
                        url: "ureport/designer/deleteReportFile",
                        dateType: "json",
                        data: {"file":"file:"+data.id},
                        success: function () {
                            layer.msg("删除成功", {icon: 1});
                        },
                        error: function () {
                        }
                    })
                }
            }
        });
        //树形组件点击后样式
        $('#ureport2 a').on('click', function(){
            $('#ureport2 a').removeClass('selected');
            $(this).addClass('selected')
        })
    });
</script>
</html>
