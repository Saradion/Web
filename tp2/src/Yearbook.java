import beans.Person;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by saradion on 16/11/16.
 */
@WebServlet(name = "Yearbook", description = "A simple servlet for a yearbook")
public class Yearbook extends HttpServlet {
    @EJB
    private FacadeLocal facade;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String form = request.getParameter("form");
        if (form == null) {
            this.getServletContext().getRequestDispatcher("/WEB-INF/misdirection.jsp").forward(request, response);
        } else if (form.equals("add_person")) {
            String fname = request.getParameter("first_name");
            String lname = request.getParameter("last_name");
            facade.addPerson(lname, fname);
            doGet(request, response);
        } else if (form.equals("add_address")) {
            String city = request.getParameter("city");
            String street = request.getParameter("street");
            facade.addAddress(street, city);
            doGet(request, response);
        } else if (form.equals("bind")) {
            String person_id = request.getParameter("person_id");
            String[] address_tab = request.getParameterValues("address_id");
            for (String address_id : address_tab) {
                facade.associer(person_id, address_id);
            }
            doGet(request, response);
        } else {
            this.getServletContext().getRequestDispatcher("/WEB-INF/misdirection.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
        } else if (action.equals("add_person")) {
            this.getServletContext().getRequestDispatcher("/WEB-INF/add_person.jsp").forward(request, response);
        } else if (action.equals("add_address")) {
            this.getServletContext().getRequestDispatcher("/WEB-INF/add_address.jsp").forward(request, response);
        } else if (action.equals("bind")) {
            request.setAttribute("persons",facade.listePersonnes());
            request.setAttribute("addresses",facade.listeAddress());

            facade.listePersonnes().forEach(Person::getId);
            this.getServletContext().getRequestDispatcher("/WEB-INF/bind.jsp").forward(request, response);
        } else if (action.equals("display")) {
            request.setAttribute("persons",facade.listePersonnes());
            this.getServletContext().getRequestDispatcher("/WEB-INF/display.jsp").forward(request, response);
        } else {
            this.getServletContext().getRequestDispatcher("/WEB-INF/misdirection.jsp").forward(request, response);
        }
    }
}
