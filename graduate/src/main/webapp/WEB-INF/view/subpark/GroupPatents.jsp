<%--
  Created by IntelliJ IDEA.
  User: yang
  Date: 2019-04-14
  Time: 9:54
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
    Group group = (Group) request.getAttribute("group");
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
                <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/subpark/insertConfiguration.do">园区配置</a>
                </li>
                <li class="layui-nav-item"><a
                        href="${pageContext.request.contextPath}/subpark/GroupManagement.do">团队管理</a></li>
                <li class="layui-nav-item"><a
                        href="${pageContext.request.contextPath}/subpark/selectBuildings.do">资产管理</a></li>
                <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/subpark/subparkAttendance.do">考勤管理</a>
                </li>
                <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/subpark/subparkSanitation.do">卫生管理</a>
                </li>
                <li class="layui-nav-item"><a
                        href="${pageContext.request.contextPath}/subpark/checkCertificate.do">团队证书</a></li>
                <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/subpark/selectPerformance.do">绩效管理</a>
                </li>
                <li class="layui-nav-item"><a
                        href="${pageContext.request.contextPath}/subpark/subparkAgreement.do">园区合同</a></li>
                <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/subpark/checkSubpark.do">园区信息</a>
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
    </c:if>
    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class=""
                       href="${pageContext.request.contextPath}/subpark/selectGroupPatent.do?groupId=<%=group.getGroupId()%>">
                        专利审核</a>
                </li>
                <li class="layui-nav-item layui-nav-itemed">
                    <a class=""
                       href="${pageContext.request.contextPath}/subpark/checkAuditPatents.do?groupId=<%=group.getGroupId()%>">
                        查看专利</a>
                </li>
            </ul>
        </div>
    </div>
    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <table class="layui-table" lay-even lay-skin="nob">
                <colgroup>
                    <col width="100">
                    <col width="100">
                    <col width="100">
                    <col width="120">
                    <col width="120">
                    <col width="120">
                    <col width="120">
                    <col width="120">
                    <col width="200">
                </colgroup>
                <thead>
                <tr>
                    <th>序号</th>
                    <th>专利类型</th>
                    <th>专利名称</th>
                    <th>专利权人</th>
                    <th>专利发明人</th>
                    <th>申请日</th>
                    <th>申请号</th>
                    <th>授权专利号</th>
                    <th>授权日期</th>
                    <th>审核时间</th>
                    <th>状态</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${patentList}" var="item">
                    <tr>
                        <td>${item.patentId}</td>
                        <td>${item.patentCategory}</td>
                        <td>${item.patentName}</td>
                        <td>${item.patentPeopleName}</td>
                        <td>${item.patentCreatePeopleName}</td>
                        <td>${item.authorizedPatentNumber}</td>
                        <td>${item.dateofAuthorization}</td>
                        <td>${item.patentAuditTime}</td>
                        <td>${item.dateofAuthorization}</td>
                        <td>${item.patentAuditTime}</td>
                        <td><%="未审核"%>
                        </td>
                        <td>
                            <a href="${pageContext.request.contextPath}/subpark/auditPatent.do?patentId=${item.patentId}"
                               class="layui-btn layui-btn-sm layui-btn-normal">审核</a>
                            <a href="${pageContext.request.contextPath}/subpark/deletePatent.do?patentId=${item.patentId}"
                               class="layui-btn  layui-btn-sm layui-btn-danger">删除</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

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



