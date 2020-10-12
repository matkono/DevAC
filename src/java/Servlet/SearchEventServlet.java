/**
 *
 * @author leandro
 */

package Servlet;

import DAO.EventDAO;
import Entities.Event;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SearchEventServlet", urlPatterns = {"/SearchEventServlet"})
public class SearchEventServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Event event = new Event();
        
        event.setName(request.getParameter("searchEventName"));
        
        processRequest(request, response, event);
        
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response, Event event)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ServletContext servletContext = request.getServletContext();
        
        EventDAO eventDAO = new EventDAO();
        List<Event> events = eventDAO.searchByEventName(event.getName());
        
        Iterator<Event> eventsAsIterator = events.iterator();
        
        request.setAttribute("eventsAsIterator", eventsAsIterator);
        RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/DisplayEvents.jsp");
        dispatcher.include(request, response);
    }
}
