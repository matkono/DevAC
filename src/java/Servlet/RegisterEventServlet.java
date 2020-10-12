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

@WebServlet(name = "RegisterEventServlet", urlPatterns = {"/RegisterEventServlet"})
public class RegisterEventServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Event event = new Event();
        
        event.setName(request.getParameter("eventName"));
        event.setInitials(request.getParameter("eventInitials"));
        event.setConcentrationArea(request.getParameter("eventConcentrationArea"));
        event.setInstitution(request.getParameter("eventInstitution"));
        
        processRequest(request, response, event);
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response, Event event)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ServletContext servletContext = request.getServletContext();
        
        EventDAO eventDAO = new EventDAO();
        eventDAO.save(event);
        
        Long id = event.getId();
        String eventName = event.getName();
        String eventInitials = event.getInitials();
        String eventConcArea = event.getConcentrationArea();
        String eventInst = event.getInstitution();

        request.setAttribute("id", id);
        request.setAttribute("eventName", eventName);
        request.setAttribute("eventInitials", eventInitials);
        request.setAttribute("eventConcArea", eventConcArea);
        request.setAttribute("eventInst", eventInst);
        
        if (eventDAO.recover(id) != null) {
            RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/MostraEventoCadastrado.jsp");
            dispatcher.include(request, response);
        } else {
            RequestDispatcher dispatcher = servletContext.getRequestDispatcher("ExibeFalha.jsp");
            dispatcher.include(request, response);
        }
    }
}
