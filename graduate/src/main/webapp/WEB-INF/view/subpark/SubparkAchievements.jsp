<%--
  Created by IntelliJ IDEA.
  User: yang
  Date: 2019-04-13
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: yang
  Date: 2019-04-13
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.*" %>
<%@ page import="com.yp.common.pojo.WorkPosition" %>
<%@ page import="com.yp.common.pojo.Achievements" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/css/layui.css" media="all">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>
<%
    Achievements achievements=(Achievements)request.getAttribute("achievements");
%>
<form class="layui-form" action="${pageContext.request.contextPath}/subpark/updateToAchievements.do" lay-filter="example">
    <div class="layui-form-item">

        <div class="layui-input-block">
            <input type="text" name="achievementsId" value="<%=achievements.getAchievementsId()%>" hidden>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">成果名字:</label>
        <div class="layui-input-block">
            <input type="text" name="achievementsName" value="<%=achievements.getAchievementsName()%>" lay-verify="title" autocomplete="off" placeholder="请输入名字"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">成果类别:</label>
        <div class="layui-input-block">
            <input type="text" name="achievementsCategory" value="<%=achievements.getAchievementsCategory()%>"  lay-verify="title" autocomplete="off" placeholder="请输入类别"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">对应分数:</label>
        <div class="layui-input-block">
            <input type="text" name="achievementsScore" value="<%=achievements.getAchievementsScore()%>" lay-verify="title" autocomplete="off" placeholder="请输设置分数"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">成果简介:</label>
        <div class="layui-input-block">
            <textarea name="achievementsIntroduction" placeholder="请输入简介" class="layui-textarea">
                <%=achievements.getAchievementsIntroduction()%></textarea>
        </div>
    </div>
    <div class="layui-input-block">
        <button class="layui-btn" lay-submit="" type="submit" lay-filter="demo1">确认修改</button>
    </div>
    </div>
</form>
<script src="${pageContext.request.contextPath}/static/layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
    var filepath = ''
    layui.use(['form', 'layedit', 'laydate', 'upload'], function () {
        var form = layui.form
            , layer = layui.layer
            , layedit = layui.layedit
            , laydate = layui.laydate;
        var $ = layui.jquery
            , upload = layui.upload;
        //日期
        laydate.render({
            elem: '#joinTime'
        });
    });
</script>

</body>
</html>


