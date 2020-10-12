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

@WebServlet(name = "RemoveEventServlet", urlPatterns = {"/RemoveEventServlet"})
public class RemoveEventServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Event event = new Event();
        
        event.setId(Long.parseLong(request.getParameter("idEvent")));
        
        processRequest(request, response, event);
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response, Event event)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ServletContext servletContext = request.getServletContext();
        
        EventDAO eventDAO = new EventDAO();
        if (eventDAO.recover(event.getId()) != null) {
            eventDAO.remove(event);
            servletContext.getRequestDispatcher("/Main.html");
            
        } else {
            RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/ExibeFalha.jsp");
            dispatcher.include(request, response);
        }
    }
}
