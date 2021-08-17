import javax.servlet.*;
import java.io.IOException;

public class First implements Servlet {
    ServletConfig config;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.config = servletConfig;
        System.out.println("creating object.................");
    }

    @Override
    public ServletConfig getServletConfig() {
        return this.config;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Servicing..............");
    }

    @Override
    public String getServletInfo() {
        return "this servlet is created by someone else";
    }

    @Override
    public void destroy() {
        System.out.println("Destroying....................");
    }
}
