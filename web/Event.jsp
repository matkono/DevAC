<%-- 
    Document   : Event
    Created on : 06/10/2020, 11:01:02
    Author     : leandro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detalhes Evento</title>
    </head>
    <body>
        <h1>Escolha uma ação para Evento</h1>
        <form action="SearchEvent.jsp">
            <h2>Pesquisar Evento</h2>
            <input type="submit" name="bt" value="Buscar Evento">
        </form>
        <form action="RegisterEvent.jsp">
            <h2>Registrar Evento</h2>
            <input type="submit" name="bt" value="Novo Evento">
        </form>
        <form action="EditEvent.jsp">
            <h2>Editar Evento</h2>
            <input type="submit" name="bt" value="Editar Evento">
        </form>
        <form action="RemoveEvent.jsp">
            <h2>Remover Evento</h2>
            <input type="submit" name="bt" value="Remover Evento">
        </form>
    </body>
</html>
