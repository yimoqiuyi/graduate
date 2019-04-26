<%--
  Created by IntelliJ IDEA.
  User: yang
  Date: 2019-04-04
  Time: 12:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="com.yp.common.pojo.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>layout 后台大布局 - Layui</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/css/layui.css">
</head>
<body class="layui-layout-body">
 <div class="layui-layout layui-layout-admin">
<c:if test="${not empty sessionScope.user}">
    <div class="layui-header">
        <div class="layui-logo">layui 后台布局</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a href="">首页</a></li>
            <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/user/viewUser.do">团队操作</a></li>
            <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/group/selectAchievements.do">成果展示</a></li>
            <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/group/Achievementoperation.do">成果操作</a></li>
            <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/group/select.do">考核报告</a></li>
            <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/group/userPosition.do">查看工位</a></li>
            <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/group/agreement.do">合同查看</a></li>
            <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/group/groupIntroduce.do">公司简介</a></li>

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
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="${pageContext.request.contextPath}/group/selectAdmissioncontract.do">
                        入园合同</a>
                </li>
                <li class="layui-nav-item">
                    <a href="${pageContext.request.contextPath}/group/selectManagementagreement.do">
                        资产协议</a>
                </li>
                <li class="layui-nav-item">
                    <a href="${pageContext.request.contextPath}/group/selectResponsibilityagreement.do">
                        卫生协议</a>
                </li>
            </ul>
        </div>
    </div>
    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">内容主体区域</div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © layui.com - 底部固定区域
    </div>
</div>
<script src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;

    });
</script>
</body>
</html>
