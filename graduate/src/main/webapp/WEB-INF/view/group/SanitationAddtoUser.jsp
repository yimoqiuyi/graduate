<%--
  Created by IntelliJ IDEA.
  User: yang
  Date: 2019-04-03
  Time: 10:57
  To change this template use File | Settings | File Templates.
  进行团队成员卫生配置以及显示
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" import="com.yp.common.pojo.*,java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>layout 后台大布局 - Layui</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/css/layui.css">
</head>
<body class="layui-layout-body">
<%
    User user = (User) request.getAttribute("user");  //获取操作用户的ID
%>
<div class="layui-layout layui-layout-admin">
    <c:if test="${not empty sessionScope.user}">
        <div class="layui-header">
            <div class="layui-logo">layui 后台布局</div>
            <!-- 头部区域（可配合layui已有的水平导航） -->
            <ul class="layui-nav layui-layout-left">
                <li class="layui-nav-item"><a href="">首页</a></li>
                <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/user/viewUser.do">团队操作</a></li>
                <li class="layui-nav-item"><a
                        href="${pageContext.request.contextPath}/group/selectAchievements.do">成果展示</a></li>
                <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/group/Achievementoperation.do">成果操作</a>
                </li>
                <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/group/select.do">考核报告</a></li>
                <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/group/userPosition.do">查看工位</a>
                </li>
                <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/group/agreement.do">合同查看</a></li>
                <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/group/groupIntroduce.do">公司简介</a>
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
                       href="${pageContext.request.contextPath}/group/selectSanitation.do?userId=<%=user.getUserId()%>">
                        卫生查看</a>
                </li>
                <li class="layui-nav-item">
                    <a href="${pageContext.request.contextPath}/group/insertsanitation.do?userId=<%=user.getUserId()%>">卫生配置</a>
                </li>
            </ul>
        </div>
    </div>
    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <form class="layui-form" action="${pageContext.request.contextPath}/group/insertToSanitation.do"
                  lay-filter="example">
                <input type="hidden" name="userId" value="<%=user.getUserId()%>">
                <div class="layui-form-item">
                    <label class="layui-form-label">用户:</label>
                    <div class="layui-input-block">
                        <input type="text" name="userName" lay-verify="title" autocomplete="off"
                               value="<%=user.getUserName()%>" readonly
                               class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">性别:</label>
                    <div class="layui-input-block">
                        <input type="text" name="sex" lay-verify="title" autocomplete="off" value="<%=user.getSex()%>"
                               readonly
                               class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">年龄:</label>
                    <div class="layui-input-block">
                        <input type="text" name="age" lay-verify="title" autocomplete="off" value="<%=user.getAge()%>"
                               readonly
                               class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="col-sm-2 control-label">卫生等级:</label>
                    <div class="layui-input-block">
                        <%
                            List<Sanitation> list = (ArrayList<Sanitation>) request.getAttribute("sanitationList");
                            for (int i = 0; i < list.size(); i++) {
                                Sanitation type = (Sanitation) list.get(i);
                        %>
                        <p><input type="checkbox" lay-skin="primary" name="sId" value="<%=type.getsId()%>"
                        /><%= type.getSanitationCategory()%>
                        </p>
                        <%
                            }
                        %>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-submit="" type="submit" lay-filter="demo1">立即提交</button>
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
    layui.use(['element','form'], function () {
        var form = layui.form
        var element = layui.element;
     });
</script>
</body>
</html>
