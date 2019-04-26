<%--
  Created by IntelliJ IDEA.
  User: yang
  Date: 2019-04-15
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="com.yp.common.pojo.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>layui在线调试</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/css/layui.css?t=1551352891258"
          media="all">
    <style>
        body {
            margin: 10px;
        }

        .demo-carousel {
            height: 200px;
            line-height: 200px;
            text-align: center;
        }
    </style>
</head>
<body>
<div class="layui-layout layui-layout-admin">
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
        <div class="layui-body">
            <div style="padding: 15px;">
                <form id="sch-form" class="layui-form layui-form-pane"
                      action="${pageContext.request.contextPath}/subpark/selectSubparkPerformance.do" lay-filter="sch-form">
                    <div class="layui-inline">
                        <label class="layui-form-label">签订时间</label>
                        <div class="layui-input-block">
                            <input name="beginTime" type="text" autocomplete="off" id="startTime"
                                   placeholder="yyyy-MM-dd" class="layui-input laydate">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">截止时间</label>
                        <div class="layui-input-block">
                            <input name="endTime" type="text" autocomplete="off" id="endTime" placeholder="yyyy-MM-dd"
                                   class="layui-input laydate">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <button class="layui-btn" type="submit">查询</button>
                        <button class="layui-btn layui-btn-primary" type="reset" id="btn-resert"> 重置</button>
                    </div>
                </form>
            </div>
            <div style="padding: 15px;">
            <table class="layui-hide" id="demo" lay-filter="test"></table>
             <script type="text/html" id="barDemo">
                <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">详情</a>
                <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detai2">查看</a>
                <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
            </script>
            <div class="layui-tab layui-tab-brief" lay-filter="demo">
                <div class="layui-tab-item">
                    <div id="pageDemo"></div>
                </div>

                <div class="layui-tab-item">
                    <div id="sliderDemo" style="margin: 50px 20px;"></div>
                </div>
            </div>
        </div>
        </div>
    </div>
    <script src="${pageContext.request.contextPath}/static/layui/layui.js?t=1551352891258"></script>
    <script>
        layui.config({
            version: '1551352891258' //为了更新 js 缓存，可忽略
        });

        layui.use(['laypage', 'layer', 'table', 'element', 'slider','laydate'], function () {
            var laypage = layui.laypage //分页
                , layer = layui.layer //弹层
                , table = layui.table //表格
                , element = layui.element //元素操作
                , slider = layui.slider //滑块
                , laydate = layui.laydate//日期

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
            //向世界问个好
            layer.msg('Hello World');

            //监听Tab切换
            element.on('tab(demo)', function (data) {
                layer.tips('切换了 ' + data.index + '：' + this.innerHTML, this, {
                    tips: 1
                });
            });
            //执行一个 table 实例
            table.render({
                elem: '#demo'
                , height: 420
                , url: 'checkPerformance.do' //数据接口
                , title: '用户表'
                , page: true //开启分页
                , toolbar: 'default' //开启工具栏，此处显示默认图标，可以自定义模板，详见文档
                , totalRow: true //开启合计行
                , cols: [[ //表头
                    {type: 'checkbox', fixed: 'left'}
                    , {field: 'performanceId', title: '绩效Id', width: 80, sort: true, fixed: 'left', totalRowText: '合计：'}
                    , {field: 'getPerformanceScore', title: '绩效分数', width: 180}
                    , {field: 'startTime', title: '开始时间', width: 180}
                    , {field: 'endTime', title: '结束时间', width: 100}
                    , {field: 'groupName', title: '团队名称', width: 100}
                    , {field: 'groupId', title: '团队外键', width: 150}
                    , {field: 'subParkId', title: '分园区外键', width: 150}
                    , {fixed: 'right', width: 200, title:'操作', align: 'center', toolbar: '#barDemo'}
                ]]
            });
            //监听头工具栏事件
            table.on('toolbar(test)', function (obj) {
                <%--var checkStatus = table.checkStatus(obj.config.id)--%>
                    <%--, data = checkStatus.data; //获取选中的数据--%>
                <%--switch (obj.event) {--%>
                    <%--case 'add':--%>
                        <%--var id = checkStatus.data[0].subParkId;--%>
                        <%--window.location.href = "${pageContext.request.contextPath}/subpark/AddRoom.do?subParkId="+id--%>
                        <%--layer.msg('添加');--%>
                        <%--break;--%>
                    <%--case 'update':--%>
                        <%--if (data.length === 0) {--%>
                            <%--layer.msg('请选择一行');--%>
                        <%--} else if (data.length > 1) {--%>
                            <%--layer.msg('只能同时编辑一个');--%>
                        <%--} else {--%>
                            <%--var id = checkStatus.data[0].groupId;--%>
                            <%--window.location.href = "${pageContext.request.contextPath}/subpark/selectOneRoom.do?groupId="+id--%>
                            <%--layer.alert('编辑 [id]：' + checkStatus.data[0].id);--%>
                        <%--}--%>
                        <%--break;--%>
                    <%--case 'delete':--%>
                        <%--if (data.length === 0) {--%>
                            <%--layer.msg('请选择一行');--%>
                        <%--} else {--%>
                            <%--var id = checkStatus.data[0].groupId;--%>
                            <%--window.location.href = "${pageContext.request.contextPath}/subpark/deleteRooms.do?groupId="+id--%>
                            <%--layer.msg('删除');--%>
                        <%--}--%>
                        <%--break;--%>
                <%--}--%>
                <%--;--%>
            });
            //监听行工具事件
            table.on('tool(test)', function (obj) { //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
                var data = obj.data //获得当前行数据
                    , layEvent = obj.event; //获得 lay-event 对应的值
                if (layEvent === 'detail') {
                    window.location.href = "${pageContext.request.contextPath}/subpark/checkGroupPerformance.do?groupId=" + data.groupId
                    layer.msg('查看操作');
                } else if (layEvent === 'del') {
                    layer.confirm('真的删除行么', function (index) {
                        window.location.href = "${pageContext.request.contextPath}/subpark/deleteGroupPerformance.do?performanceId=" + data.performanceId
                        obj.del(); //删除对应行（tr）的DOM结构
                        layer.close(index);
                        //向服务端发送删除指令
                    });
                }else if (layEvent === 'detai2') {
                    window.location.href = "${pageContext.request.contextPath}/subpark/checkOnePerformance.do?performanceId=" + data.performanceId
                    layer.msg('编辑操作');
                }
            });
            //分页
            laypage.render({
                elem: 'pageDemo' //分页容器的id
                , count: 100 //总页数
                , skin: '#1E9FFF' //自定义选中色值
                //,skip: true //开启跳页
                , jump: function (obj, first) {
                    if (!first) {
                        layer.msg('第' + obj.curr + '页', {offset: 'b'});
                    }
                }
            });
            slider.render({
                elem: '#sliderDemo'
                , input: true //输入框
            });
        });
    </script>
</body>
</html>


