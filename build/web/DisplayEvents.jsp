<%-- 
    Document   : DisplayEvents
    Created on : 06/10/2020, 19:59:25
    Author     : leandro
--%>

<%@page import="Entities.Edition"%>
<%@page import="Entities.Event"%>
<%@page import="java.util.Iterator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Show Events</title>
    </head>
    <body>
        <h2>Resultado Busca por Evento</h2>
        <%
            Iterator<Event> events = (Iterator<Event>) request.getAttribute("eventsAsIterator");

            while (events.hasNext()) {
                Event eve = events.next();
                out.println("<p>--------------------------------------------------------------------------------------------------------------");
                out.println("<p><h3>Evento:</h3>");
                out.println("<p><b>Nome:</b> " + eve.getName() + " / <b>Local:</b> " + eve.getConcentrationArea()
                        + " / <b>Intituição Organizadora:</b> " + eve.getInstitution());
                Iterator iterator = eve.getEdition().iterator();
                out.println("<p><h3>Edições:</h3> ");
                while (iterator.hasNext()) {
                    Edition ed = (Edition) iterator.next();
                    out.println("<p><b>Número:</b> " + ed.getNumber() + " / <b>Ano:</b> "
                            + ed.getMainYear() + " / <b>Data início:</b> " + ed.getDateInit() + " / <b>Data Fim:</b> "
                            + ed.getDateFinal() + " / <b>Cidade Sede:</b> " + ed.getMainCity() + " / <b>País:</b> " + ed.getMainCountry());
                }
            }
        %>
    </body>
</html>
