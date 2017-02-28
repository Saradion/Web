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
    <title>Yearbook : Bind</title>
</head>
<body>
<form method="post" action="yearbook">
    <!-- Selon le type de relation, on met des multiples ou non dans le select :) -->
    <label for="person_id">Choose a person</label>
    <select name="person_id" id="person_id" multiple="multiple">
        <c:forEach var="person" items="${persons}">
            <option value="${person.id}">
                <c:out value="${person.firstName}"/>
                <c:out value="${person.lastName}"/>
            </option>
        </c:forEach>
    </select>

    <label for="address_id">Choose an address</label>
    <select name="address_id" id="address_id" multiple="multiple">
        <c:forEach var="address" items="${addresses}">
            <option value="${address.id}">
                <c:out value="${address.street}"/>
                <c:out value="${address.city}"/>
            </option>
        </c:forEach>
    </select>
    <input type="submit" value="Submit"/>
    <input type="hidden" name="form" value="bind"/>
    <input type="hidden" name="action" value="bind"/>
</form>
<a href="yearbook">
    <button type="button">Back</button>
</a>
</body>
</html>
