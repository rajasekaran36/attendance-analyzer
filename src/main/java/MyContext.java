import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyContext implements ServletContextListener{

    @Override
    public void contextDestroyed(ServletContextEvent e) {
        System.out.println("MyContextcontextDestroyed");
    }

    @Override
    public void contextInitialized(ServletContextEvent e) {
        System.out.println("MyContextcontextInitialized");
        StudentDAO dao = new StudentDAOImpl();
        e.getServletContext().setAttribute("studao", dao);
    }
    
}
