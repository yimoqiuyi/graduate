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
        <div class="layui-body">
            <!-- 内容主体区域 -->
            <div style="padding: 15px;">
                <form class="layui-form" action="${pageContext.request.contextPath}/group/insertGroupIntroduce.do">
                <div class="layui-form-item layui-form-text">
                    <label class="layui-form-label">公司简介</label>
                    <div class="layui-input-block">
                        <textarea placeholder="请输入内容" name="introduce" class="layui-textarea"></textarea>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn"  type="submit">立即提交</button>
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
    layui.use('element', function(){
        var element = layui.element;

    });
</script>
</body>
</html>
