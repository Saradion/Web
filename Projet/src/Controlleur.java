import challenges.challenge1.Chall1;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;

@WebServlet(name = "Controlleur")
@MultipartConfig
public class Controlleur extends HttpServlet {


    /**
     *
     */
    private static final long serialVersionUID = -6248905885890153064L;

    @EJB
    private IPlayerManagerLocal facade;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String op = request.getParameter("op");
        String documentation = request.getParameter("documentation");
        String challenges = request.getParameter("challenges");


        if (op.equals("upload")) {
            final String path = "/tmp" + request.getParameter("destination");
            final Part filePart = request.getPart("file");
            final String fileName = getFileName(filePart);

            OutputStream out = null;
            InputStream filecontent = null;
            final PrintWriter writer = response.getWriter();

            try {
                out = new FileOutputStream(new File(path + File.separator
                        + fileName));
                filecontent = filePart.getInputStream();

                int read = 0;
                final byte[] bytes = new byte[1024];

                while ((read = filecontent.read(bytes)) != -1) {
                    out.write(bytes, 0, read);
                }
                writer.println("New file " + fileName + " created at " + path);
            } catch (FileNotFoundException fne) {
                writer.println("You either did not specify a file to upload or are "
                        + "trying to upload a file to a protected or nonexistent "
                        + "location.");
                writer.println("<br/> ERROR: " + fne.getMessage());
            } finally {
                if (out != null) {
                    out.close();
                }
                if (filecontent != null) {
                    filecontent.close();
                }
                if (writer != null) {
                    writer.close();
                }
            }

            Chall1 newChall = new Chall1();
            String[] parts= fileName.split("[.]");
            newChall.run(path + File.separator + fileName, parts[0]);

        } else if (op.equals("inscription")) {
            String identifiant = request.getParameter("pseudoVoulu");
            String mdp = request.getParameter("mdpVoulu");
            String mail = request.getParameter("mail");
            int res = facade.subscribe(identifiant,mail);
            if(res == 0) {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("inscription.html").forward(request, response);
            }
        } else if (documentation.equals("true")) {
            request.setAttribute("documentation", true);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else if (challenges.equals("true")) {
            request.setAttribute("challenges", true);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    private String getFileName(final Part part) {
        final String partHeader = part.getHeader("content-disposition");
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(
                        content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
}
