<%--
  Created by IntelliJ IDEA.
  User: acangou
  Date: 22/11/16
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>helloworld</title>
  </head>
  <body>
  helloworld
  <%--<form method="get" action="helloworld.jsp">--%>

<vaadin-form-layout width="535px" margin-left="true" margin-top="false" margin-bottom="false" method="get" action="hello">
  <vaadin-label for="nom">Quel est votre nom ?</vaadin-label>

  <vaadin-input type="text" name="nom" id="nom" />

  <vaadin-input type="submit" value="Envoyer" />
</vaadin-form-layout>
</body>
</html>