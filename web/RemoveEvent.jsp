<%-- 
    Document   : RemoveEvent
    Created on : 06/10/2020, 18:43:31
    Author     : leandro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Remover Evento</title>
    </head>
    <body>
        <form action="RemoveEventServlet" method="post">
            <h2>Remover evento</h2><br/>
            <b>ID do Evento: <input type="text" name="idEvent"></b><br/><br/>
            <input type="submit" name="bt" value="Remover">
        </form>
    </body>
</html>
