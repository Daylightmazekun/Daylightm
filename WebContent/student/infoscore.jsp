<%@ page import="com.nukezam.model.User" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="base.jsp"%>
<html>
<head>
    <title></title>
</head>
<body>

  <div class="container">
    <h5><b>当前位置</b>：信息查询 > 成绩查询</h5>
    <hr>
    <div>
      <% StudentDAO studentDAO = new StudentDAO();%>
      <%=studentDAO.getScore(((User)session.getAttribute("currentUser")).getEmail())%>
    </div>
  </div>

</body>
</html>