<%--
  Created by IntelliJ IDEA.
  User: yang
  Date: 2019-04-10
  Time: 9:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="utf-8" import="com.yp.common.pojo.*,java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    AchievementsNumber achievementsNumber=(AchievementsNumber)request.getAttribute("achievementsNumber");
%>
<c:if test="${ empty sessionScope.user}">
    <li><a href="login.jsp">登录</a></li>
</c:if>
<div class="layui-layout layui-layout-admin">
    <c:if test="${not empty sessionScope.user}">
        <div class="layui-header">
            <div class="layui-logo">layui 后台布局</div>
            <!-- 头部区域（可配合layui已有的水平导航） -->
            <ul class="layui-nav layui-layout-left">
                <li class="layui-nav-item"><a href="">首页</a></li>
                <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/subpark/insertConfiguration.do">园区配置</a></li>
                <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/subpark/GroupManagement.do">团队管理</a></li>
                <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/subpark/selectBuildings.do">资产管理</a></li>
                <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/subpark/subparkAttendance.do">考勤管理</a></li>
                <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/subpark/subparkSanitation.do">卫生管理</a></li>
                <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/subpark/checkCertificate.do">团队证书</a></li>
                <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/subpark/selectPerformance.do">绩效管理</a></li>
                <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/subpark/subparkAgreement.do">园区合同</a></li>
                <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/subpark/checkSubpark.do">园区信息</a></li>
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
    </c:if>
    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="${pageContext.request.contextPath}/subpark/getAllAchievements.do?groupId=${groupId}">
                        成果配置</a>
                </li>
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="${pageContext.request.contextPath}/subpark/distributionAchievements.do?groupId=${groupId}">
                        分配任务</a>
                </li>
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="${pageContext.request.contextPath}/subpark/getGroupAchievements.do?groupId=${groupId}">
                        团队成果</a>
                </li>
            </ul>
        </div>
    </div>
    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;"><a href="${pageContext.request.contextPath}/subpark/insertAchievement.do" class="layui-btn layui-btn-normal">添加</a></div>
        <div style="padding: 15px;">
            <form class="layui-form" action="">
                <div class="layui-form-item">
                    <label class="layui-form-label">专利数量:</label>
                    <div class="layui-input-block">
                        <input type="text" name="title" required  lay-verify="required" value="<%=achievementsNumber.getPatentNum()%>" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">软件数量:</label>
                    <div class="layui-input-block">
                        <input type="text" name="title" required  lay-verify="required" value="<%=achievementsNumber.getSoftwareNum()%>" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">论文数量:</label>
                    <div class="layui-input-block">
                        <input type="text" name="title" required  lay-verify="required" value="<%=achievementsNumber.getPaperNum()%>" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">竞赛数量:</label>
                    <div class="layui-input-block">
                        <input type="text" name="title" required  lay-verify="required" value="<%=achievementsNumber.getCompetitionNum()%>" autocomplete="off" class="layui-input">
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
<script src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function () {
        var element = layui.element;

    });
</script>
</body>
</html>


