<%--
  Created by IntelliJ IDEA.
  User: yang
  Date: 2019-03-24
  Time: 13:52
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
    User user = (User) request.getAttribute("user");
%>

<form class="layui-form" action="${pageContext.request.contextPath}/user/updateUser.do" method="post">
    <div class="layui-form-item">
        <div class="layui-input-block">
            <input type="text" name="userId" hidden>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">用户名:</label>
        <div class="layui-input-block">
            <input type="text" name="userName" value="<%=user.getUserName()%>" required lay-verify="required"
                   placeholder="请输入标题" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">密码:</label>
        <div class="layui-input-block">
            <input type="text" name="userPwd" value="<%=user.getUserPwd()%>" required lay-verify="required"
                   placeholder="请输入标题" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">加入时间</label>
        <div class="layui-input-block">
            <input type="text" name="joinTime" value="<%=user.getJoinTime()%>" required lay-verify="required"
                   placeholder="请输入标题" autocomplete="off" class="layui-input" readonly>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">离开时间</label>
        <div class="layui-input-block">
            <input type="text" name="awayTime" value="<%=user.getAwayTime()%>" required lay-verify="required"
                   placeholder="请输入标题" autocomplete="off" class="layui-input" readonly>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">性别</label>
        <div class="layui-input-block">
            <input type="text" name="sex" value="<%=user.getSex()%>" required lay-verify="required" placeholder="请输入标题"
                   autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">年龄</label>
        <div class="layui-input-block">
            <input type="text" name="age" value="<%=user.getAge()%>" required lay-verify="required" placeholder="请输入标题"
                   autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">电话</label>
        <div class="layui-input-block">
            <input type="text" name="phone" value="<%=user.getPhone()%>" required lay-verify="required"
                   placeholder="请输入标题" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">身份证号</label>
        <div class="layui-input-block">
            <input type="text" name="cardNumber" value="<%=user.getCardNumber()%>" required lay-verify="required"
                   placeholder="请输入标题" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">邮件</label>
        <div class="layui-input-block">
            <input type="text" name="email" value="<%=user.getEmail()%>" required lay-verify="required"
                   placeholder="请输入标题" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">居住地址</label>
        <div class="layui-input-block">
            <input type="text" name="address" value="<%=user.getAddress()%>" required lay-verify="required"
                   placeholder="请输入标题" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">卫生得分</label>
        <div class="layui-input-block">
            <input type="text" name="sanitationScore" value="<%=user.getSanitationScore()%>" required
                   lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input" readonly>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">考勤得分</label>
        <div class="layui-input-block">
            <input type="text" name="attendanceScore" value="<%=user.getAttendanceScore()%>" required
                   lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input" readonly>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">工位利用率</label>
        <div class="layui-input-block">
            <input type="text" name="workRatio" value="<%=user.getWorkRatio()%>" required lay-verify="required"
                   placeholder="请输入标题" autocomplete="off" class="layui-input" readonly>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">工位卫生状况</label>
        <div class="layui-input-block">
            <input type="text" name="workSanitation" value="<%=user.getWorkSanitation()%>" required
                   lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input" readonly>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">工位外键</label>
        <div class="layui-input-block">
            <input type="text" name="workId" value="<%=user.getWorkId()%>" required lay-verify="required"
                   placeholder="请输入标题" autocomplete="off" class="layui-input" readonly>
        </div>
    </div>
     <div class="layui-form-item">
        <div class="layui-input-block" style="width:200px">
            <button class="layui-btn" lay-submit="" type="submit" lay-filter="demo1">提交</button>
             <button class="layui-btn" lay-submit="" type="reset" lay-filter="demo1">撤返</button>
        </div>
    </div>
</form>
<script src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;

    });
</script>
</body>
</html>
