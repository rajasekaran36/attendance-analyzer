// Import required java libraries
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import java.io.*;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

// Extend HttpServlet class
public class ProcessServlet extends HttpServlet {
    private StudentDAO dao = new StudentDAOImpl();
    private String message;

    public void init() throws ServletException {
        // Do required initialization
        message = "Hello World";
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());
        List<FileItem> multifiles = null;
        try {
            multifiles = sf.parseRequest(request);
        } catch (FileUploadException e1) {
            e1.printStackTrace();
        }
        String fileName = "";
        for (FileItem item : multifiles) {
            try {
                item.write(new File("src/main/resources/", item.getName()));
                fileName = item.getName();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/"+fileName));
        String data = "";
        while (reader.ready()){
            try {
                String stu = reader.readLine().split(",")[0];
                System.out.println(stu);
                try {
                    data = data + stu + " ---- " + dao.getStudentByGmeetName(stu).getName() + "\n";
                }
                catch (NullPointerException e){
                    System.out.println("Student not found");
                }
            }catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Error");
            }
        }
        // Set response content type
        response.setContentType("text/html");
        // Actual logic goes here.
        PrintWriter out = response.getWriter();
        String s = "<textarea cols='30' rows='10'>"+data+"</textarea>";
        out.println(s);

    }

    public void destroy() {
        // do nothing.
    }
}