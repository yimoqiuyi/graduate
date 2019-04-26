<%--
  Created by IntelliJ IDEA.
  User: yang
  Date: 2019-04-04
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="com.yp.common.pojo.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>layout 后台大布局 - Layui</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/css/layui.css">
</head>
<body>
<%
    User user = (User) request.getAttribute("user");
    WorkPosition workPosition = (WorkPosition) request.getAttribute("workPosition");
    WorkstylePicture workstylePicture = (WorkstylePicture) request.getAttribute("workstylePicture");
    Room room = (Room) request.getAttribute("room");
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

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <table class="layui-table" lay-even lay-skin="nob">
                <colgroup>
                    <col width="100">
                    <col width="100">
                    <col width="100">
                    <col width="100">
                    <col width="100">
                </colgroup>
                <thead>
                <tr>
                    <th>成员</th>
                    <th>房间号</th>
                    <th>工位号</th>
                    <th>工位样式</th>
                    <th>工位样式图</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td><%=user.getUserName()%>
                    </td>
                    <td><%=room.getRoomPosition()%>
                    </td>
                    <td><%=workPosition.getWorkPosition()%>
                    </td>
                    <td><%=workstylePicture.getWorkStyleName()%>
                    </td>
                    <td>
                        <img id="viewImg" src="<%=workstylePicture.getWorkStylePicture()%>"/>
                    </td>
                </tr>
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
    $(function () {
        $("#viewImg").click(function () {
            var _this = $(this);//将当前的pimg元素作为_this传入函数
            imgShow("#outerdiv", "#innerdiv", "#bigimg", _this);
        });
    });

    function imgShow(outerdiv, innerdiv, bigimg, _this) {
        var src = _this.attr("src");//获取当前点击的pimg元素中的src属性
        $('#outerdiv').attr('display', 'block');
        $(bigimg).attr("src", src);//设置#bigimg元素的src属性
        $(outerdiv).fadeIn("fast");

        $(outerdiv).click(function () {//再次点击淡出消失弹出层
            $(this).fadeOut("fast");
        });
    }
</script>
</body>
</html>
