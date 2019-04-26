<%--
  Created by IntelliJ IDEA.
  User: yang
  Date: 2019-04-13
  Time: 11:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.*" %>
<%@ page import="com.yp.common.pojo.WorkPosition" %>
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
<form class="layui-form" action="${pageContext.request.contextPath}/subpark/insertAttendacne.do" lay-filter="example">
    <div class="layui-form-item">
        <label class="layui-form-label">考勤类别:</label>
        <div class="layui-input-block">
            <input type="text" name="attendanceCategory" lay-verify="title" autocomplete="off" placeholder="请输入类别"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">考勤分数:</label>
        <div class="layui-input-block">
            <input type="text" name="attendanceScore" lay-verify="title" autocomplete="off" placeholder="请输入分数"
                   class="layui-input">
        </div>
    </div>
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
            elem: '#joinTime'
        });
    });
</script>

</body>
</html>

