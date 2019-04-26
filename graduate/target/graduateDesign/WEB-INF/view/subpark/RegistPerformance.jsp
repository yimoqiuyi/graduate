<%--
  Created by IntelliJ IDEA.
  User: yang
  Date: 2019-04-15
  Time: 13:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="com.yp.common.pojo.*" %>
<%@ page import="org.apache.shiro.session.Session" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>个人信息</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/css/layui.css" media="all">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>
<%
    Performance performance = (Performance) request.getAttribute("performance");

%>
<form class="layui-form" action="${pageContext.request.contextPath}/subpark/insertToPerformance.do">
    <div class="layui-form-item">
        <label class="layui-form-label">绩效分数:</label>
        <div class="layui-input-block">
            <input type="text" name="userName" value="<%=performance.getPerformanceScore()%>" required lay-verify="required"
                   autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">团队名称:</label>
        <div class="layui-input-block">
            <input type="text" name="groupName" value="<%=performance.getGroupName()%>" required lay-verify="required"
                   autocomplete="off" class="layui-input">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">开始时间:</label>
        <div class="layui-input-block">
            <input name="startTime" type="text" autocomplete="off" id="startTime" placeholder="yyyy-MM-dd"
                   class="layui-input laydate">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">结束时间:</label>
        <div class="layui-input-block">
            <input name="endTime" type="text" autocomplete="off" id="endTime" placeholder="yyyy-MM-dd"
                   class="layui-input laydate">
        </div>
    </div>
    <input type="hidden" name="groupId" value="<%=performance.getGroupId()%>">
    <input type="hidden" name="generalParkId" value="<%=performance.getGeneralParkId()%>">
    <input type="hidden" name="subParkId" value="<%=performance.getSubParkId()%>">
    <div class="layui-form-item" style="width: 200px">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" style="width: 80px" type="submit" lay-filter="demo1">提交</button>
            <button class="layui-btn" lay-submit="" style="width: 80px" type="reset" lay-filter="demo2">撤回</button>
        </div>
    </div>

</form>
<script src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use('laydate', function () {
        var laydate = layui.laydate;
        //日期
        var nowTime = new Date();
        var startTime = laydate.render({
            elem: '#startTime',
            btns: ['confirm'],
            max: 'nowTime',//默认最大值为当前日期
            done: function (value, date) {
                endTime.config.min = {
                    year: date.year,
                    month: date.month - 1,//关键
                    date: date.date
                };
            }
        });
        var endTime = laydate.render({
            //type默认为yyyy-mm-dd
            elem: '#endTime',
        });

//重置
    })
</script>
</body>
</html>
