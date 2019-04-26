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
    SubPark subPark = (SubPark) request.getAttribute("subPark");
    String userName = String.valueOf(request.getAttribute("userName"));
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
                    <a class="" href="${pageContext.request.contextPath}/subpark/insertConfiguration.do">
                        园区配置</a>
                </li>
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="${pageContext.request.contextPath}/subpark/selectBuilding.do">
                        栋配置</a>
                </li>
                <li class="layui-nav-item">
                    <a href="${pageContext.request.contextPath}/subpark/selectRoom.do">房间配置</a>
                </li>
            </ul>
        </div>
    </div>
    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <form class="layui-form" action="${pageContext.request.contextPath}/subpark/updateSubPark.do">
                 <input type="hidden" name="subParkId" value="<%=subPark.getSubParkId()%>"  >
                <input type="hidden" name="generalParkId" value="<%=subPark.getGeneralParkId()%>">
                 <div class="layui-form-item">
                    <label class="layui-form-label">分园区名称:</label>
                    <div class="layui-input-block">
                        <input type="text" name="subparkName" style="width: 100px" value="<%=subPark.getSubParkName()%>"
                               required lay-verify="required" placeholder="名称" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">联系电话:</label>
                    <div class="layui-input-block">
                        <input type="text" name="subParkPhone" style="width: 100px"
                               value="<%=subPark.getSubParkPhone()%>" required lay-verify="required" placeholder="电话"
                               autocomplete="off" class="layui-input">
                    </div>
                </div>

                <div class="layui-form-item layui-form-text">
                    <label class="layui-form-label">分园区介绍:</label>
                    <div class="layui-input-block">
                        <textarea name="subParkIntroduce"
                                  class="layui-input"><%=subPark.getSubParkIntroduce()%></textarea>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" type="submit" lay-submit lay-filter="formDemo">修改</button>
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
<script src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function () {
        var element = layui.element;

    });
</script>
</body>
</html>
