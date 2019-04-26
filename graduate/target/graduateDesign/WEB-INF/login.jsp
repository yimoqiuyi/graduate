<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<head>
    <meta charset="utf-8">
    <title>后台登录</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/css/layui.css?t=1551352891258"
          media="all">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/style.css" />
</head>
<body>
<div class="main">
    <div class="mainin">
        <h1 style='font-size: 26px;font-weight: normal;color: white'>后台管理-登录</h1>
        <div class="mainin1">
            <form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/login.do" id="loginForm" method="post">
                <ul>
                    <li><span>用户名：</span><input name="userName" type="text" id="loginName" placeholder="登录名" class="SearchKeyword"></li>
                    <li><span>密码：</span><input type="password" name="userPassword" id="Possword" placeholder="密码" class="SearchKeyword2"></li>
                    <li> <input type="checkbox" class="form-control"  value="on"   name="remember">记住密码</li>
                    <li> <button type="submit" lay-filter="loginSubmit" class="tijiao">提交</button></li>
                </ul>
            </form>
        </div>
    </div>
</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
<script type="text/javascript">
    layui.use(['form','layer'], function() {
        var form = layui.form;
        var layer=layui.layer;
        form.on('submit(loginSubmit)',function(){
            $.ajax({
                type:"POST",
                url:"login.do",
                data:$("#loginForm").serialize(),
                success:function(data){
                    if(data=="success"){
                        layer.msg("登陆成功！",{icon:1,anim:2,time:2000},function(){
                            window.location.href="${pageContext.request.contextPath}/index.do";
                        });
                    }
                    else{
                        alert("用户名或密码错误")
                    }
                }
            });
        });
    });
</script>
</body>
