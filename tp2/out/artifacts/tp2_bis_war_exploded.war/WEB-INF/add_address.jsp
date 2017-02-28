<%--
  Created by IntelliJ IDEA.
  User: saradion
  Date: 16/11/16
  Time: 17:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Yearbook : Add an address</title>
</head>
<body>
    <form method="post" action="gens">
        <fieldset>
            <legend>Add an address</legend>

            <label for="street">Street</label>
            <input type="text" name="street" id="street" />

            <label for="city">City</label>
            <input type="text" name="city" id="city" />

            <input type="submit" value="Submit" />
            <input type="hidden" name="form" value="add_address" />
            <input type="hidden" name="action" value="add_address" />
        </fieldset>
    </form>
    <a href="gens"><button type="button">Back</button></a>
</body>
</html>
