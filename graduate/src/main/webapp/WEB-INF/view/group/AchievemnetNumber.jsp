<%--
  Created by IntelliJ IDEA.
  User: yang
  Date: 2019-04-10
  Time: 9:52
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
    AchievementsNumber achievementsNumber=(AchievementsNumber)request.getAttribute("achievementsNumber");
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
     <div class="layui-body">
        <!-- 内容主体区域 -->
         <div style="padding: 15px;" title="团队成就">
             <form class="layui-form" action="">
                 <div class="layui-form-item">
                     <label class="layui-form-label">专利数量</label>
                     <div class="layui-input-block">
                         <input type="text" name="title" required  lay-verify="required" value="<%=achievementsNumber.getPatentNum()%>" autocomplete="off" class="layui-input">
                     </div>
                 </div>
                 <div class="layui-form-item">
                     <label class="layui-form-label">软件数量</label>
                     <div class="layui-input-block">
                         <input type="text" name="title" required  lay-verify="required"  value="<%=achievementsNumber.getSoftwareNum()%>" autocomplete="off" class="layui-input">
                     </div>
                 </div>
                 <div class="layui-form-item">
                     <label class="layui-form-label">论文数量</label>
                     <div class="layui-input-block">
                         <input type="text" name="title" required  lay-verify="required"  value="<%=achievementsNumber.getPaperNum()%>" autocomplete="off" class="layui-input">
                     </div>
                 </div>
                 <div class="layui-form-item">
                     <label class="layui-form-label">竞赛数量</label>
                     <div class="layui-input-block">
                         <input type="text" name="title" required  lay-verify="required"  value="<%=achievementsNumber.getCompetitionNum()%>" autocomplete="off" class="layui-input">
                     </div>
                 </div>
              </form>
        </div>
         <div style="padding: 15px;" title="团队任务">
             <form class="layui-form" action="">
                 <div class="layui-form-item">
                     <label class="layui-form-label">专利数</label>
                     <div class="layui-input-block">
                         <input type="text" name="title" required  lay-verify="required" value="<%=assessmentTable.getPatentNum()%>" autocomplete="off" class="layui-input">
                     </div>
                 </div>
                 <div class="layui-form-item">
                     <label class="layui-form-label">软著数</label>
                     <div class="layui-input-block">
                         <input type="text" name="title" required  lay-verify="required"  value="<%=assessmentTable.getSoftwareNum()%>" autocomplete="off" class="layui-input">
                     </div>
                 </div>
                 <div class="layui-form-item">
                     <label class="layui-form-label">论文数</label>
                     <div class="layui-input-block">
                         <input type="text" name="title" required  lay-verify="required"  value="<%=assessmentTable.getPaperNum()%>" autocomplete="off" class="layui-input">
                     </div>
                 </div>
                 <div class="layui-form-item">
                     <label class="layui-form-label">获奖数</label>
                     <div class="layui-input-block">
                         <input type="text" name="title" required  lay-verify="required"  value="<%=assessmentTable.getCompetitionNum()%>" autocomplete="off" class="layui-input">
                     </div>
                 </div>
                 <div class="layui-form-item">
                     <label class="layui-form-label">任务开始日期</label>
                     <div class="layui-input-block">
                         <input type="text" name="title" required  lay-verify="required"  value="<%=assessmentTable.getAssessmentStartTime()%>" autocomplete="off" class="layui-input">
                     </div>
                 </div>
                 <div class="layui-form-item">
                     <label class="layui-form-label">任务结束日期</label>
                     <div class="layui-input-block">
                         <input type="text" name="title" required  lay-verify="required"  value="<%=assessmentTable.getAssessmentEndTime()%>" autocomplete="off" class="layui-input">
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


