<%-- 
    Document   : RegisterEdition
    Created on : 06/10/2020, 21:46:40
    Author     : leandro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar Edição</title>
    </head>
    <body>
        <form action="RegisterEditionServlet" method="post">
            <h2>Cadastrar edição</h2><br/>
            <b>ID evento: <input type="text" name="eventID"></b><br/><br/>
            <b>Número edição: <input type="text" name="editionNumber"></b><br/><br/>
            <b>Ano edição: <input type="text" name="editionYear"></b><br/><br/>
            <b>Data início: <input type="text" name="editionDateInit"></b><br/><br/>
            <b>Data fim: <input type="text" name="editionDateFinal"></b><br/><br/>
            <b>Cidade sede: <input type="text" name="editionMainCity"></b><br/><br/>
            <b>País: <input type="text" name="editionMainCountry"></b><br/><br/>
            <input type="submit" name="bt" value="Registrar">
        </form>
    </body>
</html>
