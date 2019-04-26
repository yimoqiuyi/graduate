<%--
  Created by IntelliJ IDEA.
  User: yang
  Date: 2019-04-01
  Time: 14:35
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="com.yp.common.pojo.*,java.util.*" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${not empty sessionScope.user}">
          <%
            ArrayList<User> list = (ArrayList<User>) request.getAttribute("userList");
            for (int i = 0; i < list.size(); i++) {
                User type = (User) list.get(i);
        %>
        <input type="radio" id="patentCategory" name="patentCategory" value="<%=type.getUserName()%>"
               title="<%= type.getUserId()%>">
        <%
            }
        %>
    ${user.userName}
</c:if>
 </body>
</html>
