package by.itechart.tutorial;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName="destinationFilter")
public class DestinationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest)  request;
        String requestURI = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());
        System.out.println("Going to check URI in case it needs to be modified ");
        if ("/page2".equals(requestURI)){
            String newURI = "page3";
            System.out.println(requestURI  + " will be replaced by " + newURI);
            request.getRequestDispatcher(newURI).forward(request, response);
        } else {
            System.out.println("No URI changes");
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
