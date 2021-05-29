import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;


@WebServlet(urlPatterns = {"/test"})
public class Test extends HttpServlet{
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
       StudentDAO dao =  (StudentDAOImpl)getServletContext().getAttribute("studao");
       res.addHeader("Access-Control-Allow-Origin", "*");
       res.setContentType("application/json");
       res.getWriter().println(new ObjectMapper().writeValueAsString(dao.getAllStudents()));
    }
}
