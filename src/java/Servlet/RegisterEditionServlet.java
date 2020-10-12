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
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RegisterEditionServlet", urlPatterns = {"/RegisterEditionServlet"})
public class RegisterEditionServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        Edition edition = new Edition();
        Event event = new Event();
        event.setId(Long.parseLong(request.getParameter("eventID")));
        edition.setNumber(request.getParameter("editionNumber"));
        edition.setMainYear(request.getParameter("editionYear"));
        edition.setDateInit(request.getParameter("editionDateInit"));
        edition.setDateFinal(request.getParameter("editionDateFinal"));
        edition.setMainCity(request.getParameter("editionMainCity"));
        edition.setMainCountry(request.getParameter("editionMainCountry"));
        
        processRequest(request, response, edition, event);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response, Edition edition, Event event)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ServletContext servletContext = request.getServletContext();
        
        EditionDAO editionDAO = new EditionDAO();
        EventDAO eventDAO = new EventDAO();
        Event e = eventDAO.recover(event.getId());
        request.setAttribute("teste", e.getEdition());
        if (e.getEdition()== null) {
            List<Edition> editList = new ArrayList();
            editList.add(edition);
            e.setEdition(editList);
        } else {
            List eveList =  e.getEdition();
            eveList.add(edition);
            e.setEdition(eveList);
        }
        edition.setEvent(event);
        editionDAO.save(edition);
        eventDAO.edit(e);
        
        request.setAttribute("eventObj", e);
        
        Long id = edition.getId();
        String editionNumber = edition.getNumber();
        String editionYear = edition.getMainYear();
        String editionDateInit = edition.getDateInit();
        String editionDateFinal = edition.getDateFinal();
        String editionMainCity = edition.getMainCity();
        String editionMainCountry = edition.getMainCountry();
        
        request.setAttribute("editionId", id);
        request.setAttribute("editionNumber", editionNumber);
        request.setAttribute("editionYear", editionYear);
        request.setAttribute("editionDateInit", editionDateInit);
        request.setAttribute("editionDateFinal", editionDateFinal);
        request.setAttribute("editionMainCity", editionMainCity);
        request.setAttribute("editionMainCountry", editionMainCountry);
        
        if (editionDAO.recover(id) != null) {
            RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/MostraEdicaoCadastrado.jsp");
            dispatcher.include(request, response);
        } else {
            RequestDispatcher dispatcher = servletContext.getRequestDispatcher("ExibeFalha.jsp");
            dispatcher.include(request, response);
        }
    }
}
