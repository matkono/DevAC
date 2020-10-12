<%-- 
    Document   : EditEvent
    Created on : 06/10/2020, 12:00:48
    Author     : leandro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Evento</title>
    </head>
    <body>
        <form action="EditEventServlet" method="post">
            <h2>Editar evento</h2><br/>
            <b>ID: <input type="text" name="idEvent"></b><br/><br/>
            <b>Nome: <input type="text" name="eventName"></b><br/><br/>
            <b>Sigla: <input type="text" name="eventInitials"></b><br/><br/>
            <b>Área de concentração <input type="text" name="eventConcentrationArea"></b><br/><br/>
            <b>Instituição organizadora: <input type="text" name="eventInstitution"></b><br/><br/>
            <input type="submit" name="bt" value="Editar">
        </form>
    </body>
</html>
