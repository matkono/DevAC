<%-- 
    Document   : MostraRecuperado
    Created on : 05/10/2020, 14:28:22
    Author     : leandro
--%>

<%@page import="java.util.Iterator"%>
<%@page import="Entities.Event"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Evento Cadastrado </title>
    </head>
    <body>
        <h2>Evento</h2>
        <p><%out.println("ID: " + request.getAttribute("id"));%></p>
        <p><%out.println("Nome do evento: " + request.getAttribute("eventName"));%></p>
        <p><%out.println("Sigla: " + request.getAttribute("eventInitials"));%></p>
        <p><%out.println("Área de concentração: " + request.getAttribute("eventConcArea"));%></p>
        <p><%out.println("Instituição organizadora: " + request.getAttribute("eventInst"));%></p>
    </body>
</html>
