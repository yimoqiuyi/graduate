<%--
  Created by IntelliJ IDEA.
  User: yang
  Date: 2019-03-30
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.yp.common.pojo.Achievements,java.util.*" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/css/layui.css" media="all">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>
<form class="layui-form" action="${pageContext.request.contextPath}/group/insertPatent.do" lay-filter="example" enctype="multipart/form-data" method="POST">
    <div class="layui-form-item">
        <label class="layui-form-label">专利名称</label>
        <div class="layui-input-block">
            <input type="text" name="patentName" lay-verify="title" autocomplete="off" placeholder="请输入标题"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">专利权人</label>
        <div class="layui-input-block">
            <input type="text" name="patentPeopleName" lay-verify="title" autocomplete="off" placeholder="请输入标题"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">专利发明人</label>
        <div class="layui-input-block">
            <input type="text" name="patentCreatePeopleName" lay-verify="title" autocomplete="off" placeholder="请输入标题"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">申请号</label>
        <div class="layui-input-block">
            <input type="text" name="patentApplyNumber" lay-verify="title" autocomplete="off" placeholder="请输入标题"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-inline">
        <label class="layui-form-label">申请日</label>
        <div class="layui-input-inline">
            <input type="text" name="patentApplyTime" id="patentApplyTime" lay-verify="date" placeholder="yyyy-MM-dd"
                   autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">授权专利号</label>
        <div class="layui-input-block">
            <input type="text" name="authorizedPatentNumber" lay-verify="title" autocomplete="off" placeholder="请输入标题"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-inline">
        <label class="layui-form-label">专利授权日期</label>
        <div class="layui-input-inline">
            <input type="text" name="dateofAuthorization" id="dateofAuthorization" lay-verify="date" placeholder="yyyy-MM-dd"
                   autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="col-sm-2 control-label">类型:</label>
        <div class="layui-input-block">
            <%
                ArrayList<Achievements> list = (ArrayList<Achievements>) request.getAttribute("achievementsList");
                for (int i = 0; i < list.size(); i++) {
                    Achievements type = (Achievements) list.get(i);
            %>
            <input type="radio" id="patentCategory" name="patentCategory" value="<%=type.getAchievementsName()%>"
                   title="<%= type.getAchievementsName()%>">
            <%
                }
            %>
        </div>
    </div>
    <div class="layui-upload">
        <button type="button" class="layui-btn layui-btn-normal" id="testList">选择多文件</button>
        <div class="layui-upload-list">
            <table class="layui-table">
                <thead>
                <tr>
                    <th>文件名</th>
                    <th>大小</th>
                    <th>状态</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody id="demoList"></tbody>
            </table>
        </div>
        <%--<button type="button" class="layui-btn" id="testListAction">开始上传</button>--%>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
        </div>
    </div>
</form>
<script src="${pageContext.request.contextPath}/static/layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
    var filepathlist = ''
    layui.use(['form', 'layedit', 'laydate', 'upload'], function () {
        var form = layui.form
            , layer = layui.layer
            , layedit = layui.layedit
            , laydate = layui.laydate;
        var $ = layui.jquery
            , upload = layui.upload;
        //日期
        laydate.render({
            elem: '#patentApplyTime'
        });
        laydate.render({
            elem: '#dateofAuthorization'
        });

        //创建一个编辑器
        var editIndex = layedit.build('LAY_demo_editor');

        //监听指定开关
        form.on('switch(switchTest)', function (data) {
            layer.msg('开关checked：' + (this.checked ? 'true' : 'false'), {
                offset: '6px'
            });
            layer.tips('温馨提示：请注意开关状态的文字可以随意定义，而不仅仅是ON|OFF', data.othis)
        });

        // //监听提交
        // form.on('submit(demo1)', function (data) {
        //     layer.alert(JSON.stringify(data.field), {
        //         title: '最终的提交信息',
        //         testList: filepathlist,
        //      })
        //     if(data=='success')
        //     {
        //         window.location.href('index.jsp')
        //     }
        //     return false;
        // });
        $('#submit').click(function () {
            $.post('insertPatent.do', {
                patent: {
                    patentName: patentName,
                    patentPeopleName: patentPeopleName,
                    patentCreatePeopleName: patentCreatePeopleName,
                    patentApplyNumber: patentApplyNumber,
                    patentApplyTime: patentApplyTime,
                    patentCategory: patentCategory
                },
                filepathlist: filepathlist
            })
        })

        // //表单初始赋值
        // form.val('example', {
        //     "patentName": "国家" // "name": "value"
        //     , "password": "123456"
        //     , "interest": 1
        //     , "like[write]": true //复选框选中状态
        //     , "close": true //开关状态
        //     , "sex": "女"
        //     , "desc": "我爱 layui"
        // })

        var demoListView = $('#demoList')
            , uploadListIns = upload.render({
            elem: '#testList'
            , url: 'upload.do'
            , accept: 'file'
            , multiple: true
            , auto: false
            , bindAction: '#testListAction'
            , choose: function (obj) {
                var files = this.files = obj.pushFile(); //将每次选择的文件追加到文件队列
                //读取本地文件
                obj.preview(function (index, file, result) {
                    filepathlist = result;
                    alert(filepathlist);
                    var tr = $(['<tr id="upload-' + index + '">'
                        , '<td>' + file.name + '</td>'
                        , '<td>' + (file.size / 1014).toFixed(1) + 'kb</td>'
                        , '<td>等待上传</td>'
                        , '<td>'
                        , '<button class="layui-btn layui-btn-xs demo-reload layui-hide">重传</button>'
                        , '<button class="layui-btn layui-btn-xs layui-btn-danger demo-delete">删除</button>'
                        , '</td>'
                        , '</tr>'].join(''));

                    //单个重传
                    tr.find('.demo-reload').on('click', function () {
                        obj.upload(index, file);
                    });

                    //删除
                    tr.find('.demo-delete').on('click', function () {
                        delete files[index]; //删除对应的文件
                        tr.remove();
                        uploadListIns.config.elem.next()[0].value = ''; //清空 input file 值，以免删除后出现同名文件不可选
                    });

                    demoListView.append(tr);
                });
            }
            , done: function (res, index, upload) {
                if (res.code != null) { //上传成功
                    var tr = demoListView.find('tr#upload-' + index)
                        , tds = tr.children();
                    tds.eq(2).html('<span style="color: #5FB878;">上传成功</span>');
                    tds.eq(3).html(''); //清空操作
                    return delete this.files[index]; //删除文件队列已经上传成功的文件
                }
                this.error(index, upload);
            }
            , error: function (index, upload) {
                var tr = demoListView.find('tr#upload-' + index)
                    , tds = tr.children();
                tds.eq(2).html('<span style="color: #FF5722;">上传失败</span>');
                tds.eq(3).find('.demo-reload').removeClass('layui-hide'); //显示重传
            }
        });
    });
</script>

</body>
</html>
