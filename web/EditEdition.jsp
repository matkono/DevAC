<%-- 
    Document   : EditEdition
    Created on : 07/10/2020, 13:42:18
    Author     : leandro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Editar Edição </title>
    </head>
    <body>
        <form action="EditEditionServlet" method="post">
            <h2>Editar Edição</h2><br/>
            <b>ID: <input type="text" name="idEdition"></b><br/><br/>
            <b>Número Edição: <input type="text" name="editionNumber"></b><br/><br/>
            <b>Ano Edição: <input type="text" name="editionYear"></b><br/><br/>
            <b>Data Início: <input type="text" name="editionDateInit"></b><br/><br/>
            <b>Data Final: <input type="text" name="editionDateFinal"></b><br/><br/>
            <b>Cidade Sede: <input type="text" name="editionMainCity"></b><br/><br/>
            <b>País: <input type="text" name="editionMainCountry"></b><br/><br/>
            <input type="submit" name="bt" value="Editar">
        </form>
    </body>
</html>
