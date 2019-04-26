<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="com.yp.common.pojo.*"
         pageEncoding="utf-8"%>
<%@ page import="javax.swing.text.Position" %>
<%@ page import="com.yp.common.pojo.WorkPosition" %>
<%@ page import="com.yp.common.pojo.WorkstylePicture" %>
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
   User user1= (User) request.getAttribute("user");
    WorkPosition workPosition= (WorkPosition) request.getAttribute("workPosition");
    WorkstylePicture workstylePicture= (WorkstylePicture) request.getAttribute("workstylePicture");
    Group group= (Group) request.getAttribute("group");
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
                <li class="layui-nav-item"><a href="viewPosition.do">工位情况</a></li>
            </ul>
            <ul class="layui-nav layui-layout-right">
                <li class="layui-nav-item">
                    <a href="javascript:;">
                             ${user.userName}
                    </a>
                    <dl class="layui-nav-child">
                        <dd><a href="select.do">基本资料</a></dd>
                        <dd><a href="${pageContext.request.contextPath}/logout.do">退了</a></dd>
                    </dl>
                </li>
            </ul>
        </div>


            <div class="layui-side layui-bg-black">
                <div class="layui-side-scroll">
                    <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
                    <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                        <li class="layui-nav-item layui-nav-itemed">
                            <a class="" href="viewPosition.do">工位展示</a>
                        </li>
                        <li class="layui-nav-item">
                            <a href="sanitation.do">卫生情况</a>
                        </li>
                        <li class="layui-nav-item"><a href="attendance.do">考勤情况</a></li>
                    </ul>
                </div>
            </div>
            <div class="layui-body">
                <!-- 内容主体区域 -->
                <div style="padding: 15px;">
                    工位利用率:<%= user1 .getWorkRatio()%>
                </div>
                <div style="padding: 15px;">
                     工位所在:<%= workPosition.getWorkPosition()%>
                </div>
                <div style="padding: 15px;">工位所在房间:<%=workPosition.getRoomId()%></div>
                <div style="padding: 15px;">团队负责人:<%= group.getGroupName()%></div>
                <div style="padding: 15px;">团队介绍:<%=group.getGroupIntroduce()%></div>
                 <div>
                    <img alt="工位样式图"  style="width:100px"  src="<%=workstylePicture.getWorkStylePicture()%>">
                </div>
            </div>
        <div class="layui-footer">
            <!-- 底部固定区域 -->
            © layui.com - 底部固定区域
        </div>
    </div>
</c:if>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;

    });
</script>
</body>
</html>
