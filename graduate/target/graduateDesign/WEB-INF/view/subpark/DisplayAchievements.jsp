<%--
  Created by IntelliJ IDEA.
  User: yang
  Date: 2019-04-10
  Time: 10:42
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
    AssessmentTable assessmentTable=(AssessmentTable)request.getAttribute("assessmentTable");
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
                <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/subpark/insertConfiguration.do">园区配置</a></li>
                <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/subpark/GroupManagement.do">团队管理</a></li>
                <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/subpark/selectBuildings.do">资产管理</a></li>
                <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/subpark/subparkAttendance.do">考勤管理</a></li>
                <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/subpark/subparkSanitation.do">卫生管理</a></li>
                <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/subpark/checkCertificate.do">团队证书</a></li>
                <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/subpark/selectPerformance.do">绩效管理</a></li>
                <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/subpark/subparkAgreement.do">园区合同</a></li>
                <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/subpark/checkSubpark.do">园区信息</a></li>
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
         <!-- 内容主体区域 -->
    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <form class="layui-form" action="${pageContext.request.contextPath}/subpark/updateAssessmentTable.do" method="post">
                         <input type="hidden" name="assessmentId" value="<%=assessmentTable.getAssessmentId()%>" >
                 <div class="layui-form-item">
                    <label class="layui-form-label">专利数:</label>
                    <div class="layui-input-block">
                        <input type="text" name="patentNum" value="<%=assessmentTable.getPatentNum()%>" required  lay-verify="required" placeholder="请输入.." autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">软著数:</label>
                    <div class="layui-input-block">
                        <input type="text" name="softwareNum"  value="<%=assessmentTable.getSoftwareNum()%>" required  lay-verify="required" placeholder="请输入.." autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">论文数</label>
                    <div class="layui-input-block">
                        <input type="text" name="paperNum" value="<%=assessmentTable.getPaperNum()%>" required  lay-verify="required" placeholder="请输入.." autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">获奖数</label>
                    <div class="layui-input-block">
                        <input type="text" name="competitionNum" value="<%=assessmentTable.getCompetitionNum()%>" required  lay-verify="required" placeholder="请输入.." autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">任务开始日期</label>
                    <div class="layui-input-block">
                        <input type="text" name="assessmentStartTime" id="assessmentStartTime" value="<%=assessmentTable.getAssessmentStartTime()%>" required  lay-verify="required"  placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">任务结束日期</label>
                    <div class="layui-input-block">
                        <input type="text" name="assessmentEndTime"  id="assessmentEndTime" value="<%=assessmentTable.getAssessmentEndTime()%>" required  lay-verify="required" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <input type="text" name="groupId" value="<%=assessmentTable.getGroupId()%>"  hidden>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" type="submit" lay-submit lay-filter="formDemo">提交</button>
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
    layui.use(['form', 'layedit', 'laydate', 'upload'], function () {
        var form = layui.form
            , layer = layui.layer
            , layedit = layui.layedit
            , laydate = layui.laydate;
        var $ = layui.jquery
            , upload = layui.upload;
        //日期
        laydate.render({
            elem: '#assessmentStartTime'
        });
        laydate.render({
            elem: '#assessmentEndTime'
        });
    });
</script>
</body>
</html>



