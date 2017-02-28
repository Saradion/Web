<%--
  Created by IntelliJ IDEA.
  User: saradion
  Date: 16/11/16
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculatrice</title>
</head>
<body>
    <form action="Calculatrice" method="post">
        <fieldset>
            <legend>Parameters</legend>

            <label for="nb1">First operand</label>
            <input type="text" name="nb1" id="nb1" />

            <label for="nb2">Second operand</label>
            <input type="text" name="nb2" id="nb2" />

            <label for="op">Operation</label>
            <input type="text" name="op" id="op" />

            <input type="submit" value="Compute" />
            <input type="hidden" name="form" value="compute" />
        </fieldset>
    </form>
</body>
</html>
