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
<form class="layui-form" action="insertPaper.do" lay-filter="example" enctype="multipart/form-data" method="POST">
    <div class="layui-form-item">
        <label class="layui-form-label">论文名称</label>
        <div class="layui-input-block">
            <input type="text" name="paperName" lay-verify="title" autocomplete="off" placeholder="请输入标题"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">作者</label>
        <div class="layui-input-block">
            <input type="text" name="authors" lay-verify="title" autocomplete="off" placeholder="请输入标题"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">作者单位</label>
        <div class="layui-input-block">
            <input type="text" name="authorUnit" lay-verify="title" autocomplete="off" placeholder="请输入标题"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">期刊名称</label>
        <div class="layui-input-block">
            <input type="text" name="journalName" lay-verify="title" autocomplete="off" placeholder="请输入标题"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="col-sm-2 control-label">论文等级</label>
        <div class="layui-input-block">
            <%
                ArrayList<Achievements> list = (ArrayList<Achievements>) request.getAttribute("achievementsList");
                for (int i = 0; i < list.size(); i++) {
                    Achievements type = (Achievements) list.get(i);
            %>
            <input type="radio" id="grade" name="grade" value="<%=type.getAchievementsName()%>"
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

     });
</script>

</body>
</html>
