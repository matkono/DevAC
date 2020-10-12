<%-- 
    Document   : RegisterEvent
    Created on : 05/10/2020, 13:17:52
    Author     : leandro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Event</title>
    </head>
    <body>
        <form action="RegisterEventServlet" method="post">
            <h2>Cadastrar evento</h2><br/>
            <b>Nome: <input type="text" name="eventName"></b><br/><br/>
            <b>Sigla: <input type="text" name="eventInitials"></b><br/><br/>
            <b>Área de concentração: <input type="text" name="eventConcentrationArea"></b><br/><br/>
            <b>Instituição organizadora: <input type="text" name="eventInstitution"></b><br/><br/>
            <input type="submit" name="bt" value="Registrar">
        </form>
    </body>
</html>
