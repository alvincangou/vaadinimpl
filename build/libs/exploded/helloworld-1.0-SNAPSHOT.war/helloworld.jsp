<%--
  Created by IntelliJ IDEA.
  User: acangou
  Date: 16/11/16
  Time: 11:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
Today's date: <%= (new java.util.Date()).toLocaleString()%>
<p>

    Heltlo <%= (request.getParameter("nom"))%></p>

</body>
</html>

