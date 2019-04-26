<%--
  Created by IntelliJ IDEA.
  User: yang
  Date: 2019-04-16
  Time: 11:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.*" %>
<%@ page import="com.yp.common.pojo.*" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>用户角色</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/css/layui.css" media="all">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>
<%
    User user = (User) request.getAttribute("user");
%>
<form class="layui-form" action="${pageContext.request.contextPath}/admin/userRole.do">
    <div class="layui-form-item">
        <label class="layui-form-label">用户ID:</label>
        <div class="layui-input-block">
            <input type="text" name="userId" value="<%=user.getUserId()%>" readonly>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">用户名:</label>
        <div class="layui-input-block">
            <input type="text" name="userName" value="<%=user.getUserName()%>" required lay-verify="required"
                   placeholder="请输入标题" autocomplete="off" class="layui-input" readonly>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">身份证号:</label>
        <div class="layui-input-block">
            <input type="text" name="cardNumber" value="<%=user.getCardNumber()%>" required lay-verify="required"
                   placeholder="请输入标题" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item" pane="">
        <label class="layui-form-label">角色:</label>
        <div class="layui-input-block">
            <%
                ArrayList<Role> list = (ArrayList<Role>) request.getAttribute("roleList");
                for (int i = 0; i < list.size(); i++) {
                    Role role = (Role) list.get(i);
            %>
            <input type="radio" lay-skin="primary" name="rId" value="<%=role.getRoleId()%>"  title="<%=role.getName()%>"/>
              <%
                }
            %>
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" type="submit" lay-submit lay-filter="formDemo">提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
    </div>
</form>
<script src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use(['element','form'], function () {
        var form = layui.form
        var element = layui.element;

    });
</script>
</body>
</html>
