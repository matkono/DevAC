/**
 *
 * @author leandro
 */
package Servlet;

import DAO.EditionDAO;
import DAO.EventDAO;
import Entities.Edition;
import Entities.Event;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RemoveEditionServlet", urlPatterns = {"/RemoveEditionServlet"})
public class RemoveEditionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Edition edition = new Edition();
        edition.setId(Long.parseLong(request.getParameter("idEdition")));

        processRequest(request, response, edition);
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response, Edition edition)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ServletContext servletContext = request.getServletContext();

        EditionDAO editionDAO = new EditionDAO();
        EventDAO eventDAO = new EventDAO();
        
        Edition editionAux = editionDAO.recover(edition.getId());
        
        if (editionDAO.recover(editionAux.getId()) != null) {
            Event event = editionAux.getEvent();
            List<Edition> editList = event.getEdition();
        
            editList.remove(editionAux);
            event.setEdition(editList);
            eventDAO.edit(event);
        } else {
            RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/ExibeFalha.jsp");
            dispatcher.include(request, response);
        }
    }
}
