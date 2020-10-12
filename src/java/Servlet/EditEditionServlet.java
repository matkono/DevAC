/**
 *
 * @author leandro
 */
package Servlet;

import DAO.EditionDAO;
import Entities.Edition;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EditEditionServlet", urlPatterns = {"/EditEditionServlet"})
public class EditEditionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Edition edition = new Edition();

        if (request.getParameter("idEdition") != null && !"".equals(request.getParameter("idEdition"))) {
            edition.setId(Long.parseLong(request.getParameter("idEdition")));
        }
        if (request.getParameter("editionNumber") != null && !"".equals(request.getParameter("editionNumber"))) {
            edition.setNumber(request.getParameter("editionNumber"));
        }
        if (request.getParameter("editionYear") != null && !"".equals(request.getParameter("editionYear"))) {
            edition.setMainYear(request.getParameter("editionYear"));
        }
        if (request.getParameter("editionDateInit") != null && !"".equals(request.getParameter("editionDateInit"))) {
            edition.setDateInit(request.getParameter("editionDateInit"));
        }
        if (request.getParameter("editionDateFinal") != null && !"".equals(request.getParameter("editionDateFinal"))) {
            edition.setDateFinal(request.getParameter("editionDateFinal"));
        }
        if (request.getParameter("editionMainCity") != null && !"".equals(request.getParameter("editionMainCity"))) {
            edition.setMainCity(request.getParameter("editionMainCity"));
        }
        if (request.getParameter("editionMainCountry") != null && !"".equals(request.getParameter("editionMainCountry"))) {
            edition.setMainCountry(request.getParameter("editionMainCountry"));
        }

        processRequest(request, response, edition);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response, Edition edition)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ServletContext servletContext = request.getServletContext();

        EditionDAO editionDAO = new EditionDAO();
        if (editionDAO.recover(edition.getId()) != null) {
            Edition editionAux = editionDAO.recover(edition.getId());
            
            if (edition.getNumber() == null) {
                edition.setNumber(editionAux.getNumber());
            }
            if (edition.getMainYear() == null) {
                edition.setMainYear(editionAux.getMainYear());
            }
            if (edition.getDateInit() == null) {
                edition.setDateInit(editionAux.getDateInit());
            }
            if (edition.getDateFinal() == null) {
                edition.setDateFinal(editionAux.getDateFinal());
            }
            if (edition.getMainCity() == null) {
                edition.setMainCity(editionAux.getMainCity());
            }
            if (edition.getMainCountry() == null) {
                edition.setMainCountry(editionAux.getMainCountry());
            }
            
            editionDAO.edit(edition);
            
        } else {
            RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/ExibeFalha.jsp");
            dispatcher.include(request, response);
        }

    }
}
