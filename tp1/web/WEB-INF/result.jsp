<%--
  Created by IntelliJ IDEA.
  User: saradion
  Date: 16/11/16
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Résultat</title>
</head>
<body>
    <p>
        The results of <%= request.getAttribute("nb1") %> <%= request.getAttribute("op") %> <%= request.getAttribute("nb2") %> is <%= request.getAttribute("result")%> .
    </p>
</body>
</html>
