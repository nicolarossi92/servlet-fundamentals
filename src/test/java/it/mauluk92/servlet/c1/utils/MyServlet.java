package it.mauluk92.servlet.c1.utils;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

// Configuration of servlet through annotation

@WebServlet(name = "MyServlet", urlPatterns = {"/my"})
public class MyServlet implements Servlet {

    // Storing ServletConfig as a servlet instance variable

    private transient ServletConfig servletConfig;

    // Init lifecycle method is invoked first time a request is made

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("Servlet init method!");
        this.servletConfig = servletConfig;
    }

    // getServletConfig is used to retrieve the ServletConfig object

    @Override
    public ServletConfig getServletConfig() {
        return this.servletConfig;
    }

    // service method is invoked each time a request is being made

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Servlet service method!");
    }

    // Method to return information about the servlet

    @Override
    public String getServletInfo() {
        return "MyServlet";
    }

    // Lifecycle method called when the servlet is being destroyed and shut down

    @Override
    public void destroy() {
        System.out.println("Servlet Destroyed!");
    }
}
