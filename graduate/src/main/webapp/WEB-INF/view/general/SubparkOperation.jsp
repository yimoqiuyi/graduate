<%@ page import="com.yp.common.pojo.SubPark" %><%--
  Created by IntelliJ IDEA.
  User: yang
  Date: 2019-04-16
  Time: 9:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="utf-8"%>
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
            </ul>
        </div>
        <div class="layui-body">
            <!-- 内容主体区域 -->
            <div style="padding: 15px;">显示总园区图片</div>
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
    layui.use('element', function(){
        var element = layui.element;

    });
</script>
</body>
</html>

