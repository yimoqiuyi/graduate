<%--
  Created by IntelliJ IDEA.
  User: yang
  Date: 2019-04-16
  Time: 11:21
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
<input type="hidden" value="${groupId}" id="groupId">
<div class="layui-layout layui-layout-admin">
    <c:if test="${not empty sessionScope.user}">
    <div class="layui-header">
        <div class="layui-logo">layui 后台布局</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
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
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class=""
                       href="${pageContext.request.contextPath}/general/sanitationHistogram.do?groupId=${groupId}">
                        卫生柱状图</a>
                </li>
                <li class="layui-nav-item layui-nav-itemed">
                    <a class=""
                       href="${pageContext.request.contextPath}/general/sanitationGraph.do?groupId=${groupId}">
                        卫生曲线图</a>
                </li>
            </ul>
         </div>
    </div>
    <div class="layui-body">
        <div style="padding: 15px;">
            <div id='main' style='width:600px;height:400px;'></div>
        </div>
    </div>
    <script src='${pageContext.request.contextPath}/static/echart/echarts.min.js'></script>
    <script src="${pageContext.request.contextPath}/static/js/jquery-1.7.2.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/layui/layui.js?t=1551352891258"></script>
    <script>
        //基于准备好的DOM，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));
        var groupId = document.getElementById("groupId").value;
        // 指定图表的配置项和数据
        //参数设置
        option = {
            title: {
                text: '成员卫生'
            },
            tooltip: {
                trigger: 'axis'
            },
            grid: {
                left: '3%',
                right: '4%',
                bottom: '3%',
                containLabel: true
            },
            toolbox: {
                feature: {
                    saveAsImage: {}
                }
            },
            xAxis: {
                type: 'category',
                boundaryGap: false,
                data: []
            },
            yAxis: {
                type: 'value'
            },
            series: [
                {
                    name:'分数',
                    type:'line',
                    stack: '总量',
                    data:[]
                }
            ]
        };
        myChart.setOption(option);   //参数设置方法
        myChart.hideLoading();
        //     getChartData();//aja后台交互
        getChartData();

        function getChartData() {
            //获得图表的options对象
            var options = myChart.getOption();
            //通过Ajax获取数据
            $.ajax({
                type: "post",
                async: false, //同步执行
                url: 'checkSanitationGraph.do?groupId=' + groupId,
                data: {},
                dataType: "json", //返回数据形式为json
                success: function (result) {
                    if (result) {
                        options.xAxis[0].data = result.categories;
                        options.series[0].data = result.data;
                        myChart.hideLoading();
                        myChart.setOption(options);
                    }
                },
                error: function (errorMsg) {
                    alert("不好意思,图表请求数据失败啦!");
                    myChart.hideLoading();
                }
            });
        }
    </script>
</body>
</html>

