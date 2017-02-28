import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.StreamCorruptedException;
import java.net.InetAddress;

/**
 * Created by saradion on 16/11/16.
 */
@WebServlet("/Calculatrice")
public class Calculatrice extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String form = request.getParameter("form");
        if (form == null) {
            this.getServletContext().getRequestDispatcher("/WEB-INF/calculatrice.jsp").forward(request, response);
        } else {
            int nb1 = Integer.parseInt(request.getParameter("nb1"));
            int nb2 = Integer.parseInt(request.getParameter("nb2"));
            String op = request.getParameter("op");
            int result = operation(nb1, nb2, op);
            request.setAttribute("nb1", nb1);
            request.setAttribute("nb2", nb2);
            request.setAttribute("op", op);
            request.setAttribute("result", result);
            this.getServletContext().getRequestDispatcher("/WEB-INF/result.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    private int operation(int nb1, int nb2, String op) {
        switch (op) {
            case "+":
                return nb1 + nb2;
            case "-":
                return nb1 - nb2;
            case "*":
                return nb1 * nb2;
            case "/":
                return nb1 / nb2;
            case "%":
                return nb1 % nb2;
            default:
                throw new RuntimeException("Unknown op!");
        }
    }
}
