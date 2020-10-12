<%-- 
    Document   : Edition
    Created on : 06/10/2020, 22:55:21
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
        <h1>Escolha uma ação para Edição</h1>
        <form action="RegisterEdition.jsp">
            <h2>Registrar Edição</h2>
            <input type="submit" name="bt" value="Nova Edição">
        </form>
        <form action="EditEdition.jsp">
            <h2>Editar Edição</h2>
            <input type="submit" name="bt" value="Editar Edição">
        </form>
        <form action="RemoveEdition.jsp">
            <h2>Remover Edição</h2>
            <input type="submit" name="bt" value="Remover Edição">
        </form>
    </body>
</html>
