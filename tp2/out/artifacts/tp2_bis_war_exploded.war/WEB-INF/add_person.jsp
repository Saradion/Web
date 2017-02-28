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
    <title>Yearbook : Add a person</title>
</head>
<body>
    <form method="post" action="gens">
        <fieldset>
            <legend>Add a person</legend>

            <label for="first_name">First Name</label>
            <input type="text" name="first_name" id="first_name" />

            <label for="last_name">Last Name</label>
            <input type="text" name="last_name" id="last_name" />

            <input type="submit" value="Submit" />
            <input type="hidden" name="form" value="add_person" />
            <input type="hidden" name="action" value="add_person" />
        </fieldset>
    </form>
    <a href="gens"><button type="button">Back</button></a>
</body>
</html>
