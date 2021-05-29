import com.fasterxml.jackson.databind.ObjectMapper;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MappingEdit extends HttpServlet {
    StudentDAO dao = new StudentDAOImpl();
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuffer buffer = new StringBuffer();

        for(Student student:dao.getAllStudents()){

            buffer.append(student.getName()+",");
            for(String gmeetname:student.getGmeetnames()){
                buffer.append(gmeetname+",");
            }
            buffer.append("\n");
        }
        String toDisplay = buffer.toString();
        String html = "<textarea cols='200' rows='70'>"+toDisplay+"</textarea>";
        //resp.setContentType("text/html");
        resp.addHeader("Access-Control-Allow-Origin", "*");
        resp.setContentType("application/json");
        resp.getWriter().print(new ObjectMapper().writeValueAsString(dao.getAllStudents()));

    }

}
