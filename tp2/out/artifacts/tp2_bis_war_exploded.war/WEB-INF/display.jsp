<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: saradion
  Date: 16/11/16
  Time: 17:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Yearbook</title>

</head>
<body>
<c:forEach var="person" items="${persons}">
    <c:out value="${person.firstName}" />
    <c:out value="${person.lastName}" />
    [<c:forEach var="address" items="${person.addresses}">
        (<c:out value="${address.street}" />
        <c:out value="${address.city}"/>)
    </c:forEach>]
    <br />
</c:forEach>
<a href="gens"><button type="button">Back</button></a>
</body>
</html>
