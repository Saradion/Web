<%--
  Created by IntelliJ IDEA.
  User: saradion
  Date: 28/11/16
  Time: 20:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8"/>
        <title>Affichage d'un client</title>
        <link type="text/css" rel="stylesheet" href="style.css"/>
    </head>
    <body>
        <%-- Affichage de la chaîne "message" transmise par la servlet --%>
        <p class="info">${ message }</p>
        <%-- Puis affichage des données enregistrées dans le bean "client" transmis par la servlet --%>
        <p>Nom : ${ client.nom }</p>
        <p>Prénom : ${ client.prenom }</p>
        <p>Adresse : ${ client.adresse }</p>
        <p>Numéro de téléphone : ${ client.telephone }</p>
        <p>Email : ${ client.email }</p>
    </body>
</html>
