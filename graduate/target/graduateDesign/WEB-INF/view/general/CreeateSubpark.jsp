<%--
  Created by IntelliJ IDEA.
  User: yang
  Date: 2019-04-14
  Time: 21:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>layout 后台大布局 - Layui</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/css/layui.css">
</head>
<body class="layui-layout-body">
<%
    String generalParkId = String.valueOf(request.getAttribute("generalParkId"));
%>
<c:if test="${ empty sessionScope.user}">
    <li><a href="login.jsp">登录</a></li>
</c:if>
<c:if test="${not empty sessionScope.user}">
    <div class="layui-layout layui-layout-admin">
        <div class="layui-header">
            <div class="layui-logo">layui 后台布局</div>
            <!-- 头部区域（可配合layui已有的水平导航） -->
            <ul class="layui-nav layui-layout-left">
                <li class="layui-nav-item"><a href="">首页</a></li>
                <li class="layui-nav-item"><a
                        href="${pageContext.request.contextPath}/general/creeateSubpark.do">分园区创建</a></li>
                <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/general/selectAllSubpark.do">分园区查看</a>
                </li>
                <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/general/subparkSanitation.do">园区信息</a>
                </li>
            </ul>
            <ul class="layui-nav layui-layout-right">
                <li class="layui-nav-item">
                    <a href="javascript:;">
                        <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                            ${user.userName}
                    </a>
                    <dl class="layui-nav-child">
                        <dd><a href="${pageContext.request.contextPath}/user/select.do">个人资料</a></dd>
                        <dd><a href="${pageContext.request.contextPath}/logout.do">退了</a></dd>
                    </dl>
                </li>
            </ul>
        </div>

        <div class="layui-body">
            <!-- 内容主体区域 -->
            <div style="padding: 15px;">
                <form class="layui-form" action="${pageContext.request.contextPath}/general/insertRoom.do"
                      enctype="multipart/form-data" method="post">
                    <input type="text" name="generalParkId" value="<%=generalParkId%>" hidden>
                    <div class="layui-form-item">
                        <label class="layui-form-label">负责人:</label>
                        <div class="layui-input-block">
                            <input type="text" name="userId" required lay-verify="required" placeholder="负责人Id"
                                   autocomplete="off"
                                   class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">分园区名称:</label>
                        <div class="layui-input-block">
                            <input type="text" name="subparkName" style="width: 100px"
                                   required lay-verify="required" placeholder="名称" autocomplete="off"
                                   class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">联系电话:</label>
                        <div class="layui-input-block">
                            <input type="text" name="subparkPhone" style="width: 100px"
                                   required lay-verify="required" placeholder="电话" autocomplete="off"
                                   class="layui-input">
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">园区介绍:</label>
                        <div class="layui-input-block">
                            <textarea name="subparkIntroduce" placeholder="请输入简介" class="layui-textarea"></textarea>
                        </div>
                    </div>


                    <div class="layui-form-item">
                        <label class="layui-form-label">房间平面图:</label>
                        <div class="layui-input-block">
                            <input type="file" name="file" value="点击上传">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-input-block">
                            <button class="layui-btn" type="submit" lay-submit lay-filter="formDemo">上传</button>
                            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                        </div>
                    </div>
                </form>


            </div>
        </div>

        <div class="layui-footer">
            <!-- 底部固定区域 -->
            © layui.com - 底部固定区域
        </div>
    </div>
</c:if>
<script src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function () {
        var element = layui.element;

    });
</script>
</body>
</html>
