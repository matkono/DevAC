/**
 *
 * @author leandro
 */

package Servlet;

import DAO.EventDAO;
import Entities.Event;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EditEventServlet", urlPatterns = {"/EditEventServlet"})
public class EditEventServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Event event = new Event();
        
        if (request.getParameter("idEvent") != null && !"".equals(request.getParameter("idEvent"))) {
            event.setId(Long.parseLong(request.getParameter("idEvent")));
        }
        if (request.getParameter("eventName") != null && !"".equals(request.getParameter("eventName"))) {
            event.setName(request.getParameter("eventName"));
        }
        if (request.getParameter("eventInitials") != null && !"".equals(request.getParameter("eventInitials"))) {
            event.setInitials(request.getParameter("eventInitials"));
        }
        if (request.getParameter("eventConcentrationArea") != null && !"".equals(request.getParameter("eventConcentrationArea"))) {
            event.setConcentrationArea(request.getParameter("eventConcentrationArea"));
        }
        if (request.getParameter("eventInstitution") != null && !"".equals(request.getParameter("eventInstitution"))) {
            event.setInstitution(request.getParameter("eventInstitution"));
        }
        
        processRequest(request, response, event);
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response, Event event)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ServletContext servletContext = request.getServletContext();
        
        EventDAO eventDAO = new EventDAO();
        if (eventDAO.recover(event.getId()) != null) {
            Event eventDTO = eventDAO.recover(event.getId());
            
            if (event.getName() == null) {
                event.setName(eventDTO.getName());
            }
            if (event.getInitials()== null) {
                event.setInitials(eventDTO.getInitials());
            }
            if (event.getConcentrationArea()== null) {
                event.setConcentrationArea(eventDTO.getConcentrationArea());
            }
            if (event.getInstitution()== null) {
                event.setInstitution(eventDTO.getInstitution());
            }
            
            eventDAO.edit(event);
        } else {
            RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/ExibeFalha.jsp");
            dispatcher.include(request, response);
        }
    }
}
