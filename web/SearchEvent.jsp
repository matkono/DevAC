<%-- 
    Document   : SearchEvent
    Created on : 06/10/2020, 20:14:10
    Author     : leandro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="SearchEventServlet" method="post">
            <h2>Remover evento</h2><br/>
            <b>Busca: <input type="text" name="searchEventName"></b><br/><br/>
            <input type="submit" name="bt" value="Buscar">
        </form>
    </body>
</html>
