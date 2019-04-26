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
<form class="layui-form" action="insertCompetition.do" lay-filter="example" enctype="multipart/form-data" method="POST">
    <div class="layui-form-item">
        <label class="layui-form-label">竞赛名称</label>
        <div class="layui-input-block">
            <input type="text" name="competitionName" lay-verify="title" autocomplete="off" placeholder="请输入标题"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">主办方</label>
        <div class="layui-input-block">
            <input type="text" name="sponsor" lay-verify="title" autocomplete="off" placeholder="请输入标题"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">队员名称</label>
        <div class="layui-input-block">
            <input type="text" name="nameofMember" lay-verify="title" autocomplete="off" placeholder="请输入标题"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">竞赛级别</label>
        <div class="layui-input-block">
            <input type="text" name="competitionLevel" lay-verify="title" autocomplete="off" placeholder="请输入标题"
                   class="layui-input">
        </div>
    </div>
     <div class="layui-form-item">
        <label class="col-sm-2 control-label">获奖等级</label>
        <div class="layui-input-block">
            <%
                ArrayList<Achievements> list = (ArrayList<Achievements>) request.getAttribute("achievementsList");
                for (int i = 0; i < list.size(); i++) {
                    Achievements type = (Achievements) list.get(i);
            %>
            <input type="radio" id="awardLevel" name="awardLevel" value="<%=type.getAchievementsName()%>"
                   title="<%= type.getAchievementsName()%>">
            <%
                }
            %>
        </div>
    </div>
    <div class="layui-upload">
        <button type="button" class="layui-btn layui-btn-normal" id="testList">选择文件</button>
        <div class="layui-upload-list">
            <input type="file" name="file">
        </div>
        <%--<button type="button" class="layui-btn" id="testListAction">开始上传</button>--%>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" type="submit" lay-filter="demo1">立即提交</button>
        </div>
    </div>
</form>
<script src="${pageContext.request.contextPath}/static/layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
    var filepath = ''
    layui.use(['form', 'layedit', 'laydate', 'upload'], function () {
        var form = layui.form
            , layer = layui.layer
            , layedit = layui.layedit
            , laydate = layui.laydate;
        var $ = layui.jquery
            , upload = layui.upload;
        //日期
        laydate.render({
            elem: '#dateofAuthorization'
        });
        //  //创建一个编辑器
        // var editIndex = layedit.build('LAY_demo_editor');
        //
        // //监听指定开关
        // form.on('switch(switchTest)', function (data) {
        //     layer.msg('开关checked：' + (this.checked ? 'true' : 'false'), {
        //         offset: '6px'
        //     });
        //     layer.tips('温馨提示：请注意开关状态的文字可以随意定义，而不仅仅是ON|OFF', data.othis)
        // });

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
        // $('#submit').click(function () {
        //     $.post('insertSoftware.do', {
        //         Software: {
        //             softName: softName,
        //             softPeopleMame: softPeopleMame,
        //             certificateNumber: certificateNumber,
        //             registrationNumber: registrationNumber,
        //             dateofAuthorization: dateofAuthorization,
        //             softGrade:softGrade,
        //          },
        //         filepath: filepath
        //     })
        // })

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


    });
</script>

</body>
</html>
