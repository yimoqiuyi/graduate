<%--
  Created by IntelliJ IDEA.
  User: yang
  Date: 2019-04-16
  Time: 12:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="utf-8" import="com.yp.common.pojo.*,java.util.*" %>
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
    String roomId = String.valueOf(request.getAttribute("roomId"));
%>
<c:if test="${ empty sessionScope.user}">
    <li><a href="login.jsp">登录</a></li>
</c:if>
<div class="layui-layout layui-layout-admin">
        <%
        Parkassets parkassets=(Parkassets)request.getAttribute("parkassets");
        %>
    <c:if test="${not empty sessionScope.user}">
    <div class="layui-header">
        <div class="layui-logo">layui 后台布局</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a href="">首页</a></li>
            <li class="layui-nav-item"><a
                    href="${pageContext.request.contextPath}/general/GroupManagement.do?subParkId=${subParkId}">团队查看</a>
            </li>
            <li class="layui-nav-item"><a
                    href="${pageContext.request.contextPath}/general/selectBuildings.do?subParkId=${subParkId}">资产查看</a>
            </li>
            <li class="layui-nav-item"><a
                    href="${pageContext.request.contextPath}/general/generalAttendance.do?subParkId=${subParkId}">考勤查看</a>
            </li>
            <li class="layui-nav-item"><a
                    href="${pageContext.request.contextPath}/general/subparkSanitation.do?subParkId=${subParkId}">卫生查看</a>
            </li>
            <li class="layui-nav-item"><a
                    href="${pageContext.request.contextPath}/general/generalCertificate.do?subParkId=${subParkId}">团队证书</a>
            </li>
            <li class="layui-nav-item"><a
                    href="${pageContext.request.contextPath}/general/selectSubparkPerformance.do?subParkId=${subParkId}">绩效查看</a>
            </li>
            <li class="layui-nav-item"><a
                    href="${pageContext.request.contextPath}/general/selectSubparkAgreement.do?subParkId=${subParkId}">园区合同</a>
            </li>
            <li class="layui-nav-item"><a
                    href="${pageContext.request.contextPath}/general/checkSubpark.do?subParkId=${subParkId}">园区信息</a>
            </li>
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
    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <form class="layui-form" action="">
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <input type="text" name="roomId" value="<%=parkassets.getRoomId()%>" hidden>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">桌子数量:</label>
                    <div class="layui-input-block">
                        <input type="text" name="tableNum" required lay-verify="required"
                               value="<%=parkassets.getTableNum()%>" autocomplete="off" class="layui-input" readonly>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">椅子数量:</label>
                    <div class="layui-input-block">
                        <input type="text" name="chairNum" required lay-verify="required"
                               value="<%=parkassets.getChairNum()%>" autocomplete="off" class="layui-input" readonly>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">空调数量:</label>
                    <div class="layui-input-block">
                        <input type="text" name="airconditioningNum" required lay-verify="required"
                               value="<%=parkassets.getAirconditioningNum()%>" autocomplete="off" class="layui-input"
                               readonly>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">窗帘数量:</label>
                    <div class="layui-input-block">
                        <input type="text" name="curtainNum" required lay-verify="required"
                               value="<%=parkassets.getCurtainNum()%>" autocomplete="off" class="layui-input" readonly>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">饮水机数量:</label>
                    <div class="layui-input-block">
                        <input type="text" name="WaterdispenserNum" required lay-verify="required"
                               value="<%=parkassets.getWaterdispenserNum()%>" autocomplete="off" class="layui-input"
                               readonly>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">电插板数量:</label>
                    <div class="layui-input-block">
                        <input type="text" name="electricboardNum" required lay-verify="required"
                               value="<%=parkassets.getElectricboardNum()%>" autocomplete="off" class="layui-input"
                               readonly>
                    </div>
                </div>
            </form>
        </div>
    </div>
</body>
</html>