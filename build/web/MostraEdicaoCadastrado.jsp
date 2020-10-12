<%-- 
    Document   : MostraEdicaoCadastrado
    Created on : 06/10/2020, 23:39:24
    Author     : leandro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Edição cadastrado </title>
    </head>
    <body>
        <h2>Edição</h2>
        <p><%out.println("ID: " + request.getAttribute("editionId"));%></p>
        <p><%out.println("Numero Edição: " + request.getAttribute("editionNumber"));%></p>
        <p><%out.println("Ano Edição: " + request.getAttribute("editionYear"));%></p>
        <p><%out.println("Data Inicio: " + request.getAttribute("editionDateInit"));%></p>
        <p><%out.println("Data Fim: " + request.getAttribute("editionDateFinal"));%></p>
        <p><%out.println("Cidade Sede: " + request.getAttribute("editionMainCity"));%></p>
        <p><%out.println("País: " + request.getAttribute("editionMainCountry"));%></p>
    </body>
</html>
