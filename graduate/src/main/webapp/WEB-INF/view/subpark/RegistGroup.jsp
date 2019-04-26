<%--
  Created by IntelliJ IDEA.
  User: yang
  Date: 2019-04-15
  Time: 12:46
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: yang
  Date: 2019-04-09
  Time: 11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="com.yp.common.pojo.User" %>
<%@ page import="org.apache.shiro.session.Session" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>个人信息</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/css/layui.css" media="all">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>
<%
    String subParkId = String.valueOf(request.getAttribute("subParkId"));
%>
<form class="layui-form" action="">
    <div class="layui-form-item">
        <div class="layui-input-block">
            <input type="text" name="subParkId" value="<%=subParkId%>" hidden>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">团队名称:</label>
        <div class="layui-input-block">
            <input type="text" name="userName"   required lay-verify="required"
                   placeholder="团队名称" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">考核任务:</label>
        <div class="layui-input-block">
            <div class="layui-input-block">
                <input type="radio" name="attendancePass" value="1" title="通过">
                <input type="radio" name="attendancePass" value="0" title="未通过" checked>
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">考核卫生:</label>
        <div class="layui-input-block">
            <div class="layui-input-block">
                <input type="radio" name="groupWorkHealthPass" value="1" title="通过" checked>
                <input type="radio" name="groupWorkHealthPass" value="0" title="未通过">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">考核考勤:</label>
        <div class="layui-input-block">
            <div class="layui-input-block">
                <input type="radio" name="groupWorkAttendancePass" value="1" title="通过" checked>
                <input type="radio" name="groupWorkAttendancePass" value="0" title="未通过">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">团队状态:</label>
        <div class="layui-input-block">
            <div class="layui-input-block">
                <input type="radio" name="state" value="1" title="在园" checked>
                <input type="radio" name="state" value="0" title="未在园">
            </div>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">团队介绍</label>
        <div class="layui-input-block">
            <textarea name="groupIntroduce" placeholder="请输入内容" class="layui-textarea"></textarea>
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" type="submit" lay-filter="demo1">立即提交</button>
        </div>
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" type="reset" lay-filter="demo1">撤返</button>
        </div>
    </div>

</form>
<script src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function () {
        var element = layui.element;

    });
</script>
</body>
</html>