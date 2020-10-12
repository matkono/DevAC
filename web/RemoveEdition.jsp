<%-- 
    Document   : RemoveEdition
    Created on : 07/10/2020, 13:42:31
    Author     : leandro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Remover Edição </title>
    </head>
    <body>
        <form action="RemoveEditionServlet" method="post">
            <h2>Remover Edição</h2><br/>
            <b>ID da Edição: <input type="text" name="idEdition"></b><br/><br/>
            <input type="submit" name="bt" value="Remover">
        </form>
    </body>
</html>
