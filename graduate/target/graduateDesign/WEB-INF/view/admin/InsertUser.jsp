<%--
  Created by IntelliJ IDEA.
  User: yang
  Date: 2019-03-30
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.*" %>
<%@ page import="com.yp.common.pojo.WorkPosition" %>
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
<form class="layui-form" action="${pageContext.request.contextPath}/admin/insertToUser.do" lay-filter="example" enctype="multipart/form-data" method="POST">
    <div class="layui-form-item">
        <label class="layui-form-label">用户</label>
        <div class="layui-input-block">
            <input type="text" name="userName" lay-verify="title" autocomplete="off" placeholder="请输入标题"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">密码</label>
        <div class="layui-input-block">
            <input type="text" name="userPwd" lay-verify="title" autocomplete="off" placeholder="请输入标题"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">单选框</label>
        <div class="layui-input-block">
            <input type="radio" name="sex" value="男" title="男" checked="">
            <input type="radio" name="sex" value="女" title="女">
            <input type="radio" name="sex" value="禁" title="禁用" disabled="">
        </div>
    </div>
    <div class="layui-inline">
        <label class="layui-form-label">加入公司时间</label>
        <div class="layui-input-inline">
            <input type="text" name="joinTime" id="joinTime" lay-verify="date" placeholder="yyyy-MM-dd"
                   autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">年龄</label>
        <div class="layui-input-block">
            <input type="text" name="age" lay-verify="title" autocomplete="off" placeholder="请输入标题"
                   class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">电话</label>
        <div class="layui-input-block">
            <input type="text" name="phone" lay-verify="title" autocomplete="off" placeholder="请输入标题"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">身份证号</label>
        <div class="layui-input-block">
            <input type="text" name="cardNumber" lay-verify="title" autocomplete="off" placeholder="请输入标题"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">邮件</label>
        <div class="layui-input-block">
            <input type="text" name="email" lay-verify="title" autocomplete="off" placeholder="请输入标题"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">居住地址</label>
        <div class="layui-input-block">
            <input type="text" name="address" lay-verify="title" autocomplete="off" placeholder="请输入标题"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">座位安排</label>
        <div class="layui-input-block">
            <%
                ArrayList<WorkPosition> list = (ArrayList<WorkPosition>) request.getAttribute("workPositionList");
                for (int i = 0; i < list.size(); i++) {
                    WorkPosition workPosition = (WorkPosition) list.get(i);
            %>
            <input type="radio" id="workId" name="workId" value="<%=workPosition.getWorkId()%>"
                   title="<%= workPosition.getWorkPosition()%>">
            <%
                }
            %>
        </div>
    </div>
    <div class="layui-input-block">
        <button class="layui-btn" lay-submit="" type="submit" lay-filter="demo1">立即提交</button>
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
